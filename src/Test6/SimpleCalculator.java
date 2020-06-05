package Test6;

import javax.swing.*;
import java.awt.*;

public final class SimpleCalculator {
    private final JFrame window;
    private final JTextField pre, suf, result;

    public JButton getButton(final int i) {
        return buttons[i];
    }

    private final JButton[] buttons;
    private final JLabel operator;

    public SimpleCalculator() {
        this("憨批计算器");
    }

    public SimpleCalculator(final String title) {
        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(500, 500);
        window.setSize(600, 300);
        pre = new JTextField(10);
        suf = new JTextField(10);
        result = new JTextField(10);
        result.setEditable(false);
        operator = new JLabel("  ");
        buttons = new JButton[4];
        final JPanel top = new JPanel();
        top.add(pre);
        top.add(operator);
        top.add(suf);
        top.add(new Label("="));
        top.add(result);
        final JPanel bottom = new JPanel();
        top.setLayout(new FlowLayout());
        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton("+-*/ ".substring(i, i + 1));
            bottom.add(buttons[i]);
        }
        window.add(top, BorderLayout.CENTER);
        window.add(bottom, BorderLayout.SOUTH);
    }

    /**
     * 启动函数
     */
    public void go() {
        final MyListener listener = new MyListener(this);
        for (int i = 0; i < 4; i++) {
            buttons[i].addActionListener(listener);
        }
        window.pack();
        window.setVisible(true);
    }

    void setOperator(final String operator) {
        this.operator.setText(operator);
    }

    private int getPre() {
        return Integer.decode(pre.getText());
    }

    private int getSuf() {
        return Integer.decode(suf.getText());
    }

    void setResult(final String s) {
        result.setText(s);
    }

    void setResult(final int integer) {
        setResult("" + integer);
    }

    void setResult(final double i) {
        setResult("" + i);
    }

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
        final double a = getPre();
        final double b = getSuf();
        if (b == 0)
            throw new ArithmeticException("除以0");
        setResult(a / b);
    }

}
