package Test7;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.*;
import java.io.*;

public final class MyListener implements ActionListener, /*KeyListener,*/ WindowListener,DocumentListener {
    private boolean changed;
    private NotepadFrame notepad;
    private JFileChooser fileChooser;
    private File file;

    /**
     * 构造
     * 
     * @param frame
     */
    MyListener(NotepadFrame frame) {
        notepad = frame;
        changed = false;
        fileChooser = new JFileChooser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* 新建 */
        if (e.getSource() == notepad.getMenu(0)) {

            trySave();
            createNew();
        }

        /* 打开 */
        if (e.getSource() == notepad.getMenu(1)) {
            System.out.println("按下“打开文件”");
            if (fileChooser.showOpenDialog(notepad.getWindow()) == JFileChooser.APPROVE_OPTION) {
                var s = fileChooser.getSelectedFile();
                if (!s.exists()) {
                    System.out.println("文件 " + s.getPath() + " 不存在");
                    return;
                }
                setFile(s);
                read();

                if (s.exists()) {
                    System.out.println("打开： " + s.getPath());
                }

            }
        }
        /* 保存 */
        if (e.getSource() == notepad.getMenu(2)) {
            System.out.println("按下“保存文件”");

            if (file != null) {
                try {
                    write();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(notepad.getWindow(), "保存出错", "文件保存失败",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(notepad.getWindow(), ex, "文件保存失败", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                try {
                    setFile(SaveAs());
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(notepad.getWindow(), "保存出错", "文件保存失败",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(notepad.getWindow(), ex, "文件保存失败", JOptionPane.ERROR_MESSAGE);
                }
            }
            var s = file;
            System.out.println("储存： " + s.getPath());
            System.out.println("文件改变重置");
            changed = false;
        }
        /* 另存为 */
        if (e.getSource() == notepad.getMenu(3)) {
            System.out.println("按下“另存为”");

            File s = null;
            try {
                s = SaveAs();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(notepad.getWindow(), "保存出错", "文件保存失败", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(notepad.getWindow(), ex, "文件保存失败", JOptionPane.ERROR_MESSAGE);
            }
            if (s != null) {
                System.out.println("另存为 " + s.getPath());
            }
        }
        /* 退出 */
        if (e.getSource() == notepad.getMenu(4)) {
            System.out.println("按下“退出”");

            windowClosing(null);
        }
        /* 切换文件编码 */
        if (e.getSource() == notepad.getEncode()) {
            System.out.println("点击切换文件编码");

            notepad.changeEncode();
            if (changed) {
                if (JOptionPane.showConfirmDialog(notepad.getWindow(), "任何未保存的更改将丢失,要继续吗?", "更改未保存",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                    return;
                }
            }
            if (changed && file == null) {
                try {
                    File s = SaveAs();
                    if (s != null) {
                        System.out.println("另存为 " + s.getPath());
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(notepad.getWindow(), "保存出错", "文件保存失败",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(notepad.getWindow(), ex, "文件保存失败", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                read();
            }
        }

    }

    private File SaveAs() throws IOException {
        if (fileChooser.showSaveDialog(notepad.getWindow()) == JFileChooser.CANCEL_OPTION) {
            return null;
        }

        File f = fileChooser.getSelectedFile();
        if (f.exists()) {
            if (JOptionPane.showConfirmDialog(notepad.getWindow(), "是否覆盖？", "目标文件存在",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
                throw new IOException();
        }
        /*
         * try { f.createNewFile(); } catch (IOException ex) { ex.printStackTrace(); }
         */
        write(f);
        return f;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        trySave();
        System.exit(0);

    }

    private void trySave() {
        if (changed && JOptionPane.showConfirmDialog(notepad.getWindow(), "是否保存?", "文件尚未保存",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                if (file == null) {
                    SaveAs();
                } else {
                    write();
                }
                changed = false;
                System.out.println("文件改变重置");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(notepad.getWindow(), "保存出错", "文件保存失败", JOptionPane.INFORMATION_MESSAGE);
                trySave();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(notepad.getWindow(), ex, "文件保存失败", JOptionPane.ERROR_MESSAGE);
                trySave();
            }
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public void read() {
        try (FileInputStream f = new FileInputStream(this.file)) {
            BufferedReader file = new BufferedReader(new InputStreamReader(f, notepad.getCoder()));
            StringBuffer str = new StringBuffer();
            String s;
            while ((s = file.readLine()) != null) {
                str.append(s).append('\n');
            }
            file.close();

            notepad.setText(str.toString());

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(notepad.getWindow(), "文件未找到", "文件打开失败", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(notepad.getWindow(), e, "文件打开失败", JOptionPane.ERROR_MESSAGE);
        }

        changed = false;
        System.out.println("文件改变重置");
    }

    public void write() throws IOException {
        write(file);
    }

    public void write(File writingFile) throws IOException {
        FileOutputStream f = new FileOutputStream(writingFile);
        OutputStreamWriter file = new OutputStreamWriter(f, notepad.getCoder());
        file.write(notepad.getText());
        file.close();

    }

    public void setFile(File file) {
        this.file = file;
        if (file != null && file.exists()) {
            notepad.getWindow().setTitle(file.getName() + " - What the Hell Code");
        } else {
            notepad.getWindow().setTitle("What the Hell Code");
        }
    }

    public void createNew() {
        notepad.setText("");
        file = null;
    }

/*
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("按下 " + e.getKeyChar() + "(按键码：" + e.getKeyCode() + ")");
        if (!e.isControlDown()) {
            System.out.println("文件已经改变");

            changed = true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
*/

    @Override
    public void insertUpdate(DocumentEvent e) {

        changed=true;
        System.out.println("文件已经改变(插入)");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {

        changed=true;
        System.out.println("文件已经改变(删除)");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        changed=true;
        System.out.println("文件已经改变");
    }
}
