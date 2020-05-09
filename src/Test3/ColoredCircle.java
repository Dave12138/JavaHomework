package Test3;

import Test2.Circle;
import Test2.Point;

public class ColoredCircle extends Circle {
    private Color borderColor;
    private Color centerColor;
    /*
    构造器
     */
    public ColoredCircle(){
        borderColor=new Color();
        centerColor=new Color();
    }

    /**
     *
     * @param center 圆心坐标
     * @param r 半径
     */
    public ColoredCircle(Point center,int r){
        super(center,r);
        borderColor = new Color();
        centerColor = new Color(); 
    }

    /**
     *
     * @param centerColor 中心颜色
     * @param borderColor 边颜色
     */
    public ColoredCircle(Color centerColor,Color borderColor){
        this.centerColor=new Color(centerColor);
        this.borderColor=new Color(borderColor);
    }

    /**
     *
     * @param center 圆心
     * @param r 半径
     * @param centerColor 圆心颜色
     * @param borderColor 边颜色
     */
    public ColoredCircle(Point center,int r,Color centerColor,Color borderColor){
        super(center,r);
        this.centerColor=new Color(centerColor);
        this.borderColor=new Color(borderColor);
    }

    /*
    set器
     */
    public void setBorderColor(Color borderColor) {
        this.borderColor=new Color(borderColor);
    }

    public void setCenterColor(Color centerColor) {
        this.centerColor=new Color(centerColor);
    }


    /*
    get器
     */
    public Color getBorderColor() {
        return borderColor;
    }

    public Color getCenterColor() {
        return centerColor;
    }


    @Override
    public int relation(Circle other) {
        var i = super.relation(other);
        if (i == 0) {
            if(other.getClass()==getClass()){
                var o=(ColoredCircle)other;
                if(centerColor.equals(o.centerColor)&&borderColor.equals(o.borderColor)){
                    return 0;
                }
            }
            return 5;
        }
        return i;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", borderColor=" + borderColor +
                ", centerColor=" + centerColor;
    }
}
