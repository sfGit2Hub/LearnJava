package study.thread;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/1/19.
 */
public class FindMaxTask implements Callable<Integer> {
    private int[] data;
    private int start;
    private int end;

    public FindMaxTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (data[start] > max)
                max= data[start];
        }
        return max;
    }
}
