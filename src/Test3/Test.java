package Test3;
import Test2.Circle;
import Test2.CircleRelationship;
import Test2.Point;

import java.util.Scanner;

public final class Test {
    public static void main(String[] args) {
        var sc=new Scanner(System.in);
        ColoredCircle c1,c2,c3,c4;
        System.out.println("现按顺序调用以下构造方法：");
        System.out.println("ColoredCircle()");
        System.out.println("ColoredCircle(Point center,int r)");
        System.out.println("ColoredCircle(Color centerColor,Color borderColor)");
        System.out.println("ColoredCircle(Point center,int r,Color centerColor,Color borderColor)");
        System.out.println("---------------------------------------");
        System.out.println("ColoredCircle()called");
        c1=new ColoredCircle();
        System.out.println("⚪1:" + c1 + "面积：" + c1.area() + "周长：" + c1.perimeter());
        System.out.println("---------------------------------------");

        System.out.println("ColoredCircle(Point center,int r)called");
        System.out.println("输入圆心坐标与半径");
        c2=new ColoredCircle(new Point(sc.nextInt(),sc.nextInt()),sc.nextInt());
        System.out.println("⚪2:" + c2 + "面积：" + c2.area() + "周长：" + c2.perimeter());
        System.out.println("---------------------------------------");

        System.out.println("ColoredCircle(Color centerColor,Color borderColor)called");
        System.out.println("输入两种颜色（6个8bit整数）");
        c3 = new ColoredCircle(new Color(sc.nextInt(), sc.nextInt(), sc.nextInt()), new Color(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        System.out.println("⚪3：" + c3 + "面积：" + c3.area() + "周长：" + c3.perimeter());
        System.out.println("---------------------------------------");

        System.out.println("ColoredCircle(Point center,int r,Color centerColor,Color borderColor)called");
        c4=new ColoredCircle(c2.getCenter(),c2.getRadius(),c3.getCenterColor(),c3.getBorderColor());
        System.out.println("⚪4：" + c4 + "面积：" + c4.area() + "周长：" + c4.perimeter());
        var tmp=new Circle();
        System.out.println("---------------------------------------");
        System.out.println("圆之间关系：");
        System.out.println("⚪2&⚪3:" + c2.relation(c3) + new CircleRelationship(c2.relation(c3)));
        System.out.println("⚪2&⚪4:" + c2.relation(c4) + new CircleRelationship(c2.relation(c4)));
        System.out.println("⚪1&无色单位圆:" + c1.relation(tmp) + new CircleRelationship(c1.relation(tmp)));

    }
}
