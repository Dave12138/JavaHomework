package Test2;

public class Circle {
    private Point center;
    private int radius;
    /*构造器*/
    public Circle(){
        this(0,0,1);
    }
    /**
     * 构造方法
     * @param core 圆心
     * @param r 半径
     */
    protected Circle(Point core, int r){
        if(core==null)
            throw new NullPointerException("点不存在");
        if(r<0)
            throw new IllegalArgumentException("半径不能为负");
        center=new Point(core.getX(),core.getY());
        radius=r;
    }

    /**
     * 构造方法
     * @param x 圆心横坐标
     * @param y 圆心纵坐标
     * @param r 半径
     */
    Circle(int x,int y,int r){
        center = new Point(x, y);
        radius=r;
    }
/*功能*/
    /**
     * 求圆周长
     * @return 周长
     */
    public double perimeter(){
        return Math.PI*2*radius;
    }

    /**
     * 求圆面积
     * @return 面积
     */
    public double area(){
        return Math.PI*radius*radius;
    }

    /**
     * 取得圆的关系
     * @param other 比较圆
     * @return 比照结果 同一个圆（返回0）、同心圆（返回1）、相交的圆（返回2）、分离的圆（返回3）、包含的圆（返回4）
     */
    public int relation(Circle other){
        if(other==null)
            throw new NullPointerException("待判断关系圆不存在");

        if(other.center.equals(center)){
            if(other.radius==radius)
                return 0;
            return 1;
        }
        double OO = other.center.distance(center);
        if(OO>radius+other.radius)
            return 3;
        if(OO<Math.abs(radius-other.radius))
            return 4;
        return 2;
    }

/*
get
 */
    public int getRadius() {
        return radius;
    }

    public Point getCenter() {
        return center;
    }
/*
set
*/
    public void setCenter(int x,int y) {
        center = new Point(x, y);
    }

    public void setCenter(Point center) {
        if(center==null)
            throw new NullPointerException("点不存在");
        this.center = new Point(center.getX(),center.getY());
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    /*toString*/
    @Override
    public String toString() {
        return "(x" + (-center.getX() >= 0 ? "+" : "") + -center.getX() + ")^2+" +
                "(y" + (-center.getY() >= 0 ? "+" : "") + -center.getY() + ")^2=" +
                getRadius() + "^2";
    }

}
