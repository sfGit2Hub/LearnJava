package design.pattern.decorator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Administrator on 2019/6/24.
 */
public class DecoratorMain {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + "; cost:" + beverage.cost());

        Beverage beverage1 = new Espresso();
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription() + "; cost:" + beverage1.cost());

        int c;
        try {
            File f = new File(DecoratorMain.class.getClass().getResource("/").getPath() + "/lowerCase.txt");
            FileInputStream fileInputStream = new FileInputStream(f);
            LowerCaseInputStream lowerCaseInputStream = new LowerCaseInputStream(fileInputStream);
            while ((c = lowerCaseInputStream.read()) >= 0){
                System.out.print((char) c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
