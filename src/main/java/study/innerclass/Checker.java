package study.innerclass;

/**
 * Created by SF on 2016/5/3.
 */
public class Checker implements Game {
    private int move = 0;
    private Checker(){}
    private static final int MOVES = 3;

    @Override
    public boolean move() {
        System.out.println("Checker move:" + move);
        return ++move == MOVES;
    }

    public static GameFactory factory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Checker();
        }
    };

    public static void main(String[] args){
        /**
         * 工厂模式在此处返回的对象不同，每调用一次返回一个新的Game对象
         */
        Game gameOne = Checker.factory.getGame();
        Game gameTwo = Checker.factory.getGame();
        System.out.println(gameOne.equals(gameTwo));    // false
    }
}
