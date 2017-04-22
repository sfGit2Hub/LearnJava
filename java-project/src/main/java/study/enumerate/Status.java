package study.enumerate;

/**
 * Created by SF on 2017/4/10.
 */
public enum Status {
    SUCCEED("", 0),
    FAILED("", 1);

    private String value;
    private int code;

    Status(String value, int code) {
        this.value = value;
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public Status setValue(String value) {
        this.value = value;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Status setCode(int code) {
        this.code = code;
        return this;
    }

    public static void main(String []args) {
        Status.SUCCEED.setValue("succeed!");
        System.out.println(Status.SUCCEED.getValue());
    }
}
