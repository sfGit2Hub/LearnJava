package string;

import java.util.Formatter;

/**
 * Created by SF on 2016/5/19.
 *
 * 应用格式修饰符来打印一个购物收据
 */
public class Receipt {
    private double total = 0;
    private Formatter formatter = new Formatter(System.out);//将格式化输出到系统输出
    public void printTitle() {
        formatter.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        formatter.format("%-15s %5s %10s\n", "----", "---", "-----");
    }

    public void print(String item, int qty, double price) {
        if (item.length()<15) {
            formatter.format("%-15s %5d %10.2f\n", item, qty, price);
            total += price;
            return;
        }
        formatter.format("%-15s %5d %10.2f\n", item.substring(0,14), qty, price);
        int row = item.length()/15;
        for (int i=1; i<row+1; i++) {
            int startIndex = 15*i-1;
            int endIndex = 15*(i+1)<item.length() ? 15*(i+1)-1 : item.length();
            formatter.format("%-15.15s %5s %10s\n", item.substring(startIndex, endIndex), "", "");
        }
        total += price;
    }

    public void printTotal() {
        formatter.format("%-15s %5s %10.2f\n", "Tax", "", total*0.06);
        formatter.format("%-15s %5s %10s\n", "", "", "----");
        formatter.format("%-15s %5s %10.2f\n", "Total", "", total*1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 3, 30);
        receipt.print("Princess peas", 2, 10.5);
        receipt.print("The Beans", 1, 23);
        receipt.printTotal();
    }

}
