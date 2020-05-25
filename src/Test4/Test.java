package Test4;


import java.util.Scanner;

public final class Test {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.println("输入第一个圆的坐标与半径");
        Point p1 = new Point(sc.nextInt(), sc.nextInt());
        Circle c1 = new Circle(p1, sc.nextInt());
        System.out.println("⚪1:" + c1);
        System.out.println("输入第二个圆的坐标与半径");
        Point p2 = new Point(sc.nextInt(), sc.nextInt());
        Circle c2 = new Circle(p2, sc.nextInt());
        System.out.println("⚪2:" + c2);
        System.out.println("两圆equals：" + c1.equals(c2));
        System.out.println("两圆心equals：" + p1.equals(p2));
    }
}
