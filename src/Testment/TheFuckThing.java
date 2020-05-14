package Testment;

public class TheFuckThing extends WhatTheFuck {
    static{
        System.out.println("静初始化块Called");
    }
    {

        System.out.println("初始化块Called");
    }

    TheFuckThing(){
        System.out.println("构造方法Called");
    }
    TheFuckThing(int i){
//        super(2);
        System.out.println("含参构造方法Called");
    }
    TheFuckThing(double i){
        super(3.14);
        System.out.println("含参构造方法Called");
    }

}
