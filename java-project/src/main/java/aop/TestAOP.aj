package aop;
/*
执行命令：mvn aspectj:compile
*/
public aspect TestAOP {
    public pointcut staticInit(): staticinitialization(aop.Simple);

    before(): staticInit() {
        System.out.println("[before static-init]" + thisJoinPointStaticPart.getSignature().getName());
    }

    after() returning(): staticInit() {
        System.out.println("[after static-returning]" + thisJoinPointStaticPart.getSignature().getName());
    }

    before(): call(public aop.*.new()) {
        System.out.println("[before new()]" + thisJoinPoint.getSignature().getName());
    }

    after(): call(public aop.*.new()) {
        System.out.println("[after new()]" + thisJoinPoint.getSignature().getName());
    }

    public pointcut welcomeMethod(String name): call(public String aop.*.welcome(String)) && args(name);

    before(String name): welcomeMethod(name){
        System.out.println("[before welcome()]" + thisJoinPoint.getTarget().getClass().getCanonicalName() + "."
                        + thisJoinPoint.getSignature().getName() + " args_name=" + name);
    }

    after(String name) returning(String retval): welcomeMethod(name) {
        System.out.println("[after welcome() returning]"
                + thisJoinPoint.getTarget().getClass().getCanonicalName() + "."
                + thisJoinPoint.getSignature().getName() + " args_name=" + name
                + " return_value =" + retval);

    }

    after(String name): welcomeMethod(name){
        System.out.println("[after welcome() over]" + thisJoinPoint.getTarget().getClass().getCanonicalName() + "."
                + thisJoinPoint.getSignature().getName() + " args_name=" + name);
    }

    after(String name) throwing(java.lang.Exception e): welcomeMethod(name){
        System.out.println("[after throwing]" + thisJoinPoint.getTarget().getClass().getCanonicalName() + "."
                + thisJoinPoint.getSignature().getName() + " throwing=" + e.getMessage());
    }

//    String around(String name) : welcomeMethod(name) {
//        System.out.println("[around]=========start========");
//        System.out.println("[around]" + thisJoinPoint.getTarget().getClass().getCanonicalName()
//                + "." + thisJoinPoint.getSignature().getName() + "args_name" + name);
//        String retval = proceed(name);
//        System.out.println("[around]" + thisJoinPoint.getTarget().getClass().getCanonicalName()
//                + "." + thisJoinPoint.getSignature().getName() + " args_name=" + name
//                + " return_value=" + retval);
//        System.out.println("[around] modify return value append '!!!' = " + (retval = retval + "!!!"));
//        System.out.println("[around]========end=========");
//        return retval;
//    }
}