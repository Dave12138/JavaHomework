package Test5;

public class MatrixMultiplicationException extends RuntimeException {
    MatrixMultiplicationException(){
        super("乘以无法相乘的矩阵");
    }
    MatrixMultiplicationException(String s){
        super(s);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
