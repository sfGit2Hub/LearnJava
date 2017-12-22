package aop;

import common.use.Person;

/**
 * Created by SF on 2017/3/28.
 */
public class Simple {
    static {
        System.out.println("[src] static init");
    }

    public Simple() {
        System.out.println("[src] construct");
    }

    @ParameterChange(parameterClass = String.class)
    public String welcome(String name) {
        System.out.println("[src]===========start===========");
        System.out.println("[src] welcome method execute");
        System.out.println("[src] welcome method execute");
        System.out.println("[src]===========end===========");
        // throw new RuntimeException("runtime exception");
        return "welcome " + name;
    }

    public static void main(String[] args) throws Exception {
//        Simple simple = new Simple();
//        String greeting = simple.welcome("Jack");
//        System.out.println(greeting);
        UserMgr mgr = new UserMgrImp();

        //为用户管理添加事务处理
        InvocationHandle h = new TransactionHandle(mgr);
        UserMgr u = (UserMgr)Proxy.newProxyInstance(UserMgr.class, h);

        //为用户管理添加显示方法执行时间的功能
        TimeHandle h2 = new TimeHandle(u);
        u = (UserMgr)Proxy.newProxyInstance(UserMgr.class, h2);

        u.addUser(new Person().setAge(20).setID("ID:123").setName("abel").setMarried(true));
        System.out.println("\r\n===========================\r\n");
        u.delUser();
    }
}
