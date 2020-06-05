package Test6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListener implements ActionListener {
    SimpleCalculator calculator;

    public MyListener(final SimpleCalculator sc) {
        calculator = sc;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        for (int i = 0; i < 4; i++)
            if (e.getSource() == calculator.getButton(i)) {
                try {
                    switchOperator(i);
                } catch (final NumberFormatException exc) {
                    System.out.println(exc);
                    JOptionPane.showMessageDialog(null, "请输入32位整数");
                } catch (final ArithmeticException exc) {
                    System.out.println(exc);
                    JOptionPane.showMessageDialog(null, "0不可作为除数");
                }
            }
    }

    /**
     * 把运算选择部分提取出来
     * 
     * @param operator 运算符，0为加，1为减，2为乘，3为除
     */
    private void switchOperator(final int operator) {
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
