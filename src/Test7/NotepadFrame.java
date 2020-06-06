package Test7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;

public final class NotepadFrame {
    private File file;
    private JMenuItem[] menu;
    private JFrame window;
    private JTextArea textArea;
    private JButton encode;

    public NotepadFrame() {
        /* 顶部菜单栏 */
        String[] menuName = { "新建", "打开", "保存", "另存为", "退出" };
        menu = new JMenuItem[5];
        JMenu menuList = new JMenu("文件");
        for (int i = 0; i < 5; i++) {
            menu[i] = new JMenuItem(menuName[i]);
            if (i == 4)
                menuList.add(new JSeparator());
            menuList.add(menu[i]);
        }
        JMenuBar bar = new JMenuBar();
        bar.add(menuList);
        /* 快捷键 */
        menu[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        menu[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        menu[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        menu[3].setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        /* 文本编辑框 */
        textArea = new JTextArea();
        JScrollPane pane = new JScrollPane(textArea);
        JPanel status = new JPanel();
        encode = new JButton("UTF-8");
        status.setLayout(new BorderLayout());
        status.add(encode, BorderLayout.EAST);
        window = new JFrame("What the Hell Code");
        window.setJMenuBar(bar);
        window.add(pane, BorderLayout.CENTER);
        window.add(status, BorderLayout.SOUTH);
    }

    public void go() {
        /* Listener */
        MyListener listener = new MyListener(this);
        for (int i = 0; i < 5; i++) {
            menu[i].addActionListener(listener);
        }
        window.addWindowListener(listener);
        textArea.addKeyListener(listener);
        encode.addActionListener(listener);
        /* 窗口 */
        window.setLocation(500, 500);
        window.setSize(600, 500);
        window.setVisible(true);
    }

    public void dispose() {
        window.dispose();
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void changeEncode() {
        if (encode.getText().equals("UTF-8")) {
            encode.setText("GBK");
        } else {
            encode.setText("UTF-8");
        }
    }

    public String getCoder() {
        return encode.getText();
    }

    public JButton getEncode() {
        return encode;
    }

    public File getFile() {
        return file;
    }

    /**
     * @param index 0: 新建 1: 打开 2: 保存 3: 另存为 4: 退出
     * @return
     */
    public JMenuItem getMenu(int index) {
        return menu[index];
    }

    public JFrame getWindow() {
        return window;
    }

    public void read() {
        try (FileInputStream f = new FileInputStream(this.file)) {
            BufferedReader file = new BufferedReader(new InputStreamReader(f, getCoder()));
            StringBuffer str = new StringBuffer();
            String s;
            while ((s = file.readLine()) != null) {
                str.append(s + '\n');
            }
            file.close();
            textArea.setText(str.toString());
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(window, "文件未找到", "文件打开失败", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(window, e, "文件打开失败", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void write() throws IOException {
        write(file);
    }

    public void write(File writingFile) throws IOException {
        FileOutputStream f = new FileOutputStream(writingFile);
        OutputStreamWriter file = new OutputStreamWriter(f, getCoder());
        file.write(textArea.getText());
        file.close();

    }

    public void createNew() {
        textArea.setText("");
        file = null;
    }
}
