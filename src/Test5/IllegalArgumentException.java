package Test5;

public class IllegalArgumentException extends RuntimeException {
    IllegalArgumentException(){
        super("矩阵行列数不合法或矩阵不存在");
    }
    IllegalArgumentException(String s){
        super(s);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
