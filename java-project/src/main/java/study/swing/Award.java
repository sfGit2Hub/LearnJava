package study.swing;

/**接口---奖励*/
public interface Award {
    public static final int DOUBLE_FIRE=0;  //火力
    public static final int LIFE=1;         //生命
    public int getType();  //获取奖励类型(0火力 1生命)
}