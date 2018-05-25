package google.guava;

import com.google.common.util.concurrent.FutureCallback;

public class FutureCallbackImp implements FutureCallback<Integer> {
    private Integer tempResult;

    @Override
    public void onSuccess(Integer result) {
        System.out.println("callback success: " + result);
        tempResult = result;
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
    }

    public Integer getResult(){
        return tempResult;
    }
}
