package Test7;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class MyListener implements ActionListener, KeyListener, WindowListener {
    private boolean changed;
    private NotepadFrame notepad;

    /**
     * 构造
     * 
     * @param frame
     */
    MyListener(NotepadFrame frame) {
        notepad = frame;
        changed = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* 新建 */
        if (e.getSource() == notepad.getMenu(0)) {

            trySave();
            notepad.createNew();
        }

        /* 打开 */
        if (e.getSource() == notepad.getMenu(1)) {
            System.out.println("按下“打开文件”");
            String file = JOptionPane.showInputDialog("请输入欲打开文件名(含路径)");
            if (file != null) {
                notepad.setFile(new File(file));
                notepad.read();
                changed = false;

                var s = notepad.getFile();
                if (s.exists()) {
                    System.out.println("打开： " + s.getPath() + s.getName());
                } else {
                    System.out.println("文件 " + file + " 不存在");
                }

            }
        }
        /* 保存 */
        if (e.getSource() == notepad.getMenu(2)) {
            System.out.println("按下“保存文件”");

            if (notepad.getFile() != null) {
                try {
                    notepad.write();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(notepad.getWindow(), "保存出错", "文件保存失败",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(notepad.getWindow(), ex, "文件保存失败", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                try {
                    notepad.setFile(SaveAs());
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(notepad.getWindow(), "保存出错", "文件保存失败",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(notepad.getWindow(), ex, "文件保存失败", JOptionPane.ERROR_MESSAGE);
                }
            }
            var s = notepad.getFile();
            System.out.println("储存： " + s.getPath());
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
            notepad.read();
            changed = false;

        }

    }

    private File SaveAs() throws IOException {
        String file = JOptionPane.showInputDialog("请输入欲保存文件名(含路径)");
        if (file == null) {
            return null;
        }
        if (file.equals("")) {
            JOptionPane.showMessageDialog(notepad.getWindow(), "文件名为空！");
            return null;
        }

        File f = new File(file);
        /*
         * try { f.createNewFile(); } catch (IOException ex) { ex.printStackTrace(); }
         */
        notepad.write(f);
        return f;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("按下 " + e.getKeyChar() + "(按键码：" + e.getKeyCode() + ")");
        if (!e.isControlDown()) {
            changed = true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

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
                if (notepad.getFile() == null) {
                    SaveAs();
                } else {
                    notepad.write();
                }
                changed = false;
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

}
