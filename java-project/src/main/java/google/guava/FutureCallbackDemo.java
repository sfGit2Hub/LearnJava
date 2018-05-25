package google.guava;

import com.google.common.util.concurrent.*;

import java.util.concurrent.*;

public class FutureCallbackDemo {
    private static ThreadService service = new ThreadService();
    private static ExecutorService executor = Executors.newCachedThreadPool();


    public static void jdkFutureDemo() {
        Future<Integer> future = executor.submit(new Callable<Integer>(){
            @Override
            public Integer call() throws Exception{
                return service.getCount();
            } });
//Retrieve the value of computation
        try {
            Integer count = future.get();
            System.out.println("jdkFutureDemo: " + count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void guavaListenabelFuture() {
        //创建一个ListeningExecutorService实例
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(executor);
        //提交一个可监听的线程
        ListenableFuture<Integer> futureTask = executorService.submit
                (new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        System.out.println("call() is execute");
                        return service.getCount();
                    }
                });
        FutureCallbackImp callback = new FutureCallbackImp();
        //线程结果处理回调函数
        Futures.addCallback(futureTask, callback);
        System.out.println("after futures callback:" + callback.getResult());
        //如果callback中执行的是比较费时的操作，Guava建议使用以下方法。
//        Futures.addCallback(futureTask,callback,executorService);
    }

    public static void main(String[] args) {
//        jdkFutureDemo();
        guavaListenabelFuture();
    }
}
