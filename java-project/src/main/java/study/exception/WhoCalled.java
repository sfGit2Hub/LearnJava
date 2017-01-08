package study.exception;

/**
 * Created by SF on 2016/5/18.
 * 展示printStackTrance()提供的信息可以通过getStackTrance()方法来直接访问
 * 返回一个由栈轨迹中的元素所构成的数组
 */
public class WhoCalled {
    static void f(){
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println("方法名："+ste.getMethodName() + "\t行数：" + ste.getLineNumber());
            }
        }
    }

    static void g(){
        f();
    }

    static void h(){
        g();
    }

    public static void main(String[] args){
        f();
        System.out.println("---------------------------------");
        g();
        System.out.println("---------------------------------");
        h();
    }
}
