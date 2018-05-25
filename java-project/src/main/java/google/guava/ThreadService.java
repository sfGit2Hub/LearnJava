package google.guava;

public class ThreadService {
    private static int var;

    public Integer getCount() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return var++;
    }
}
