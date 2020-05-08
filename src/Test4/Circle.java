package Test4;


public class Circle extends circle.Circle {
    private Point center;
    Circle(Point core, int r){
        super(core,r);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        return relation((Circle) obj) == 0;
    }
}
