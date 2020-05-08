package Test4;


import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.println("输入第一个圆的坐标与半径");
        Circle c1 = new Circle(new Point(sc.nextInt(), sc.nextInt()), sc.nextInt());
        System.out.println("⚪1:" + c1);
        System.out.println("输入第二个圆的坐标与半径");
        Circle c2 = new Circle(new Point(sc.nextInt(), sc.nextInt()), sc.nextInt());
        System.out.println("⚪2:" + c2);
        System.out.println("两圆equals：" + c1.equals(c2));
        System.out.println("两圆心equals：" + c1.getCenter().equals(c2.getCenter()));
    }
}
