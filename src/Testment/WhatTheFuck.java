package Testment;

public class WhatTheFuck {
    static{
        System.out.println("父静初始化块Called");
    }
    {

        System.out.println("父初始化块Called");
    }
    WhatTheFuck(){
        System.out.println("父构造方法Called");
    }
    WhatTheFuck(int i){
        System.out.println("含参父构造方法Called");
    }
    WhatTheFuck(double i){
        System.out.println("含参父构造方法Called");
    }
}
