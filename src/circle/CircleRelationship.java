package circle;

public class CircleRelationship {
    int type;
    public CircleRelationship(int type){
        this.type = type;
    }

    @Override
    public String toString() {
        switch (type) {
            case 0:
                return "同圆";
            case 1:
                return "同心圆";
            case 2:
                return "相交";
            case 3:
                return "相离";
            case 4:
                return "内含";
            case 5:
                return "异色同圆";
            default:
                return "未知关系类型";
        }

    }
}
