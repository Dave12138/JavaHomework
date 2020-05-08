package Test4;


public class Circle extends circle.Circle {
    private Point center;
    Circle(Point core, int r){
        if(core==null)
            throw new NullPointerException("点不存在");
        if(r<0)
            throw new IllegalArgumentException("半径不能为负");
        center=new Point(core.getX(),core.getY());
        setRadius(r);
    }

    @Override
    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public void setCenter(int x, int y) {
        center = new Point(x, y);
    }


    @Override
    public String toString() {
        return "{center=" + center +
                ", radius=" + getRadius()+"}" ;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        var tmp = (Circle) obj;
        return center.equals(tmp.center) && getRadius() == tmp.getRadius();
    }
}
