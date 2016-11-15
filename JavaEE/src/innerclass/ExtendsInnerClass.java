package innerclass;

/**
 * Created by SF on 2016/5/4.
 * 继承内部类的方式
 */
public class ExtendsInnerClass extends WithinClass.InnerClass{
    public ExtendsInnerClass(WithinClass withinClass){
        /**
         * 在实现对内部类继承，语法要求要有一个外部类的引用来初始化此内部类
         * 所以在初始化此继承类的时候一定要先初始化 内部类，即此语法格式固定
         */
        withinClass.super();//此处相当于调用了 InnerClass 的构造器方法初始化
//        withinClass.super("有参数的构造器");
    }
}
