package innerclass;

/**
 * Created by SF on 2016/5/3.
 */
public interface InterfaceInClass {
    void innerClass();
    class InnerInterface implements InterfaceInClass{
        @Override
        public void innerClass() {
            System.out.println("接口内部类的测试！");
        }

        public static void main(String[] args){
            InnerInterface inClass = new InnerInterface();
            inClass.innerClass();
        }
    }

}
