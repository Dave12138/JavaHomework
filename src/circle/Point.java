package circle;

import java.util.Objects;

public final class Point {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * 构造方法
     * @param x 点横坐标
     * @param y 点纵坐标
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * 求两点间距离
     * @param other 另一个点
     * @return 两点间距离
     */
    public double distance(Point other){
        if(other==null)
            throw new NullPointerException("点不存在");
        double dx=x-other.x;
        double dy=y-other.y;
        return Math.sqrt(dx*dx+dy*dy);
    }

    public static double distance(Point p1,Point p2) {
        return p1.distance(p2);
    }

    @Override
    public String toString() {
        return "(" + x + ',' + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
