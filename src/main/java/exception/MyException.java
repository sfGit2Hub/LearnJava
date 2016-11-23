package exception;

/**
 * Created by SF on 2016/5/18.
 */
public class MyException extends Exception {
    public MyException(){}
    public MyException(String msg) {
        super(msg);
    }

    public void ArrayIndexOutOfBoundsException(){
        throw new ArrayIndexOutOfBoundsException("数组越界！");
    }
}
