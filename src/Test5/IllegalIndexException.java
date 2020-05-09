package Test5;

public class IllegalIndexException extends RuntimeException {
    IllegalIndexException(){
        super("下标越界");
    }
    IllegalIndexException(String s){
        super(s);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
