package Test7;

import javax.swing.*;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public final class NotepadFrame {
    private JMenuItem[] menu;
    private JFrame window;
    private TextArea textArea;
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
                KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        /* 文本编辑框 */
        textArea = new TextArea();
        /* 底边状态栏 */
        JPanel status = new JPanel();
        encode = new JButton("UTF-8");
        status.setLayout(new BorderLayout());
        status.add(encode, BorderLayout.EAST);
        /* 左边没点啥总感觉别扭 */
        JLabel label = new JLabel("<html>左<br/>边<br/>没<br/>点<br/>啥<br/>总<br/>感<br/>觉<br/>别<br/>扭</html>");
        JPanel leftPanel = new JPanel();
        leftPanel.add(label);
        /* 组件拼入窗体 */
        window = new JFrame("What the Hell Code");
        window.setJMenuBar(bar);
        window.add(textArea, BorderLayout.CENTER);
        window.add(status, BorderLayout.SOUTH);
        window.add(leftPanel, BorderLayout.WEST);
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

    public void setText(String string) {
        textArea.setText(string);
    }

    public void changeEncode() {
        if (getCoder().equals("UTF-8")) {
            encode.setText("GBK");
        } else if (getCoder().equals("GBK")) {
            encode.setText("UTF-16");
        } else if (getCoder().equals("UTF-16")) {
            encode.setText("UTF-8");
        }
    }

    public String getCoder() {
        return encode.getText();
    }

    public JButton getEncode() {
        return encode;
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

    public String getText() {
        return textArea.getText();
    }

    public void setVisible(boolean sign) {
        window.setVisible(sign);
    }
}
