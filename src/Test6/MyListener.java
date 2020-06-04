package Test6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener {
    SimpleCalculator calculator;

    public MyListener(SimpleCalculator sc) {
        calculator = sc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 4; i++)
            if (e.getSource() == calculator.getButton(i)) {
                try {
                    switchOperator(i);
                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(null, "请输入整数");
                } catch (ArithmeticException exc) {
                    JOptionPane.showMessageDialog(null, "0不可作为除数");
                }
            }
    }

    /**
     * 把运算选择部分提取出来
     * 
     * @param operator 运算符，0为加，1为减，2为乘，3为除
     */
    private void switchOperator(int operator) {
        switch (operator) {
            case 0:
                calculator.add();
                break;
            case 1:
                calculator.sub();
                break;
            case 2:
                calculator.mul();
                break;
            case 3:
                calculator.div();
                break;
        }
    }
}
