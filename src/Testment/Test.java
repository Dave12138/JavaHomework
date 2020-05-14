package Testment;

public class Test {
    /**
     *  测试实例初始化顺序
     */
    public static void main(String[] args) {

        System.out.println("使用无参构造方法创建对象：");
        var l=new TheFuckThing();
        System.out.println("接着使用含参构造方法创建对象：");
        TheFuckThing i=new TheFuckThing(1);
        System.out.println("最后使用调用父含参构造方法的含参构造方法创建对象：");
        TheFuckThing F=new TheFuckThing(1.2);
    }
}
