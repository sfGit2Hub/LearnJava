package string;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * Created by SF on 2016/5/19.
 *
 * Formatter 类的简单使用
 */
public class Turtle {
    private String name;
    private Formatter formatter;
    public Turtle(String name, Formatter formatter) {
        this.name = name;
        this.formatter = formatter;
    }

    public void move(int x, int y) {
        formatter.format("%s The Turtle is at (%d,%d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        Turtle tommy = new Turtle("Tommy", new Formatter(System.out));
        Turtle terry = new Turtle("Terry", new Formatter(outAlias));
        tommy.move(0,0);
        tommy.move(1,0);
        tommy.move(2,2);
        tommy.move(0,3);
        terry.move(3,2);
        terry.move(1,0);
        terry.move(0,4);
        terry.move(2,2);
    }
}
