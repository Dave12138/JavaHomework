package Test6;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public final class SimpleCalculator {
    private JFrame window;
    private JTextField pre, suf, result;
    private JButton[] buttons;
    private JLabel operator;

    /**
     * 默认标题 “憨批计算器”
     */
    public SimpleCalculator() {
        this("憨批计算器");
    }

    /**
     * 构造函数 自定标题
     * 
     * @param title 标题
     */
    public SimpleCalculator(String title) {
        /* 搓出来主窗口 禁用窗口大小拖动 设定初始位置 */
        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocation(500, 500);
        /* 三个文本框 */
        pre = new JTextField(10);
        suf = new JTextField(10);
        result = new JTextField(12);
        result.setEditable(false);
        /* 运算符 四个按钮 */
        operator = new JLabel("  ");
        /* 上面那些都塞一个容器里 放上排 */
        JPanel top = new JPanel();
        top.add(pre);
        top.add(operator);
        top.add(suf);
        top.add(new JLabel("="));
        top.add(result);
        window.add(top, BorderLayout.CENTER);
        /* 再加一个容器放下排 里面塞按钮 */
        JPanel bottom = new JPanel();
        buttons = new JButton[4];
        top.setLayout(new FlowLayout());
        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton("+-*/ ".substring(i, i + 1));
            bottom.add(buttons[i]);
        }
        window.add(bottom, BorderLayout.SOUTH);
    }

    /**
     * 启动函数
     */
    public void go() {
        MyListener listener = new MyListener(this);
        for (int i = 0; i < 4; i++) {
            buttons[i].addActionListener(listener);
        }
        window.pack();
        window.setVisible(true);
    }

    void setOperator(String operator) {
        this.operator.setText(operator);
    }

    /* getter */
    private int getPre() {
        return Integer.decode(pre.getText());
    }

    private int getSuf() {
        return Integer.decode(suf.getText());
    }

    public JButton getButton(int i) {
        return buttons[i];
    }

    public JFrame getWindow() {
        return window;
    }

    /* setter */
    void setResult(String s) {
        result.setText(s);
    }

    void setResult(int integer) {
        setResult("" + integer);
    }

    void setResult(double i) {
        setResult("" + i);
    }

    /* 运算部分 */
    void add() {
        setOperator("+");
        setResult(getPre() + getSuf());
    }

    void sub() {
        setOperator("-");
        setResult(getPre() - getSuf());
    }

    void mul() {
        setOperator("X");
        setResult(getPre() * getSuf());
    }

    void div() {
        setOperator("/");
        double a = getPre();
        double b = getSuf();
        if (b == 0)
            throw new ArithmeticException("除以0");
        setResult(a / b);
    }
}
