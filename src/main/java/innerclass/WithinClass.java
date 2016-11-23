package innerclass;

/**
 * Created by SF on 2016/5/4.
 */
public class WithinClass {
    protected void test(){
        System.out.println("WithinClass.test()");
    }

    public class InnerClass{
        public InnerClass(){}
        public InnerClass(String a){
            System.out.println(a);
        }
        public void test(){
            System.out.println("WithinClass.InnerClass.test()");
        }

        protected void testExtendsInner(){
            System.out.println("WithinClass.InnerClass.testExtendsInner()");
        }
    }


}
