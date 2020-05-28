package Test5;

public final class Test {
    public static void main(String[] args) throws Exception{
        Matrix m = new Matrix(2, 3);
        for (int i = 1; i <= m.getRows(); i++) {
            for (int j = 1; j <= m.getCols(); j++) {
                m.setData(i, j, (i * 3 + j) );
            }
        }
        System.out.println("m:\n" + m);
        double[][] list = new double[2][3];
        for (int i = 0; i <2; i++) {
            for (int j = 0; j <3; j++) {
                list[i][j] = i * 4 + j*11;
            }
        }
        Matrix n = new Matrix(list);
        System.out.println("n:\n" + n);
        System.out.println("m.equals(n)="+m.equals(n));
        System.out.println("m与n的转置相乘得：");
        System.out.println(m.multiply(n.transpose()));
        System.out.println("计算行列式得：");
        System.out.println(m.multiply(n.transpose()).determinant());
        System.out.println("m的转置与n相乘得：");
        System.out.println(m.transpose().multiply(n));
        System.out.println("计算行列式得：");
        System.out.println(m.transpose().multiply(n).determinant());
        System.out.println("异常处理部分：");
        try {
            new Matrix((double[][])null);
        } catch (IllegalArgumentException e) {
            System.out.println("使用new Matrix((double[][])null):" + e);
        }
        try {
            m.getData(5, 6);
        } catch (IllegalIndexException e) {
            System.out.println("使用m.getData(5, 6):" + e);
        }
        try {
            m.multiply(n);
        } catch (MatrixMultiplicationException e) {
            System.out.println("使用m.multiply(n);:" + e);
        }
    }
}
