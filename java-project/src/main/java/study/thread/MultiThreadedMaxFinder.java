package study.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/1/19.
 */
public class MultiThreadedMaxFinder {
    public static int max(int[] data) throws ExecutionException, InterruptedException {
        if (data.length == 0) {
            return Integer.MIN_VALUE;
        }

        if (data.length == 1) {
            return data[0];
        }

        ExecutorService service = Executors.newFixedThreadPool(2);

        FindMaxTask task_1 = new FindMaxTask(data, 0, data.length / 2);
        FindMaxTask task_2 = new FindMaxTask(data, data.length / 2, data.length);

        Future<Integer> future_1 = service.submit(task_1);
        Future<Integer> future_2 = service.submit(task_2);

        return Math.max(future_1.get(), future_2.get());
    }
}
