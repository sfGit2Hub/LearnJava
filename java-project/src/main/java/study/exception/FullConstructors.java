package study.exception;

/**
 * Created by SF on 2016/5/18.
 */
public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throw MyException from f()");
        throw new MyException();
    }

    public static void g() {
        System.out.println("Throw MyException from g()");
        try {
            throw new MyException();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace();
        }

        g();
    }
}
