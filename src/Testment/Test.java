package Testment;

public class Test {
    /**
     *  测试实例初始化顺序
     */
    public static void main(String[] args) {

        System.out.println("使用无参构造方法创建对象：");
        var l=new TheFuckThing();
        System.out.println("使用含参构造方法创建对象：");
        TheFuckThing i=new TheFuckThing(1);
        WhatTheFuck j=(WhatTheFuck)i;
        System.out.println(""+i.getClass()+"\n"+j.getClass());
    }
}
