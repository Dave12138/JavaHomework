package circle;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        var sc=new Scanner(System.in);
        System.out.println("---------------------Notice----------------------");
        System.out.println("\tCircle无参构造方法默认为单位圆");
        System.out.println("-------------------------------------------------");
        System.out.println("输入第一个圆的坐标与半径");
        Circle c1 = new Circle(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.println("⚪1:" + c1 + "面积：" + c1.area() + "周长：" + c1.perimeter());
        System.out.println("输入第二个圆的坐标与半径");
        Circle c2 = new Circle(new Point(sc.nextInt(), sc.nextInt()), sc.nextInt());
        System.out.println("⚪2:" + c2 + "面积：" + c2.area() + "周长：" + c2.perimeter());
        System.out.println("关系返回值:" + c1.relation(c2) + "(" + new CircleRelationship(c1.relation(c2)) + ")");
        System.out.println("同一个圆（返回0）、同心圆（返回1）、相交的圆（返回2）、分离的圆（返回3）、包含的圆（返回4）");
        System.out.println("修改⚪2圆心的坐标：");
        c2.getCenter().setX(sc.nextInt());
        c2.getCenter().setY(sc.nextInt());
        System.out.println("修改⚪2圆心的半径：");
        c2.setRadius(sc.nextInt());
        System.out.println("⚪2:" + c2 + "面积：" + c2.area() + "周长：" + c2.perimeter());
        System.out.println("关系返回值:" + c1.relation(c2) + "(" + new CircleRelationship(c1.relation(c2)) + ")");
        System.out.println("同一个圆（返回0）、同心圆（返回1）、相交的圆（返回2）、分离的圆（返回3）、包含的圆（返回4）");
    }
}
