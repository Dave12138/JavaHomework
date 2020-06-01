package Test1;

import java.util.Scanner;

public final class Factorial {
    /**
     * 递归法求取自然数阶乘
     * 
     * @param x 待求阶乘数 对于负数，抛出IllegalArgumentException
     * @return 返回求阶乘结果
     */
    private static long fact(long x) {
        if (x == 0)
            return 1;
        if (x < 0)
            throw new IllegalArgumentException("无法求得负数阶乘");
        return x * fact(x - 1);
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.print("输入待求阶乘数值：");
        var i = sc.nextInt();
        while (i > 20 || i < 0) {
            System.out.println("数值超出范围,请重新输入");
            i = sc.nextInt();
        }
        System.out.println(i + "的阶乘为" + fact(i));
    }
}
