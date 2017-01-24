package study.java8.currency;

import java.util.Currency;
import java.util.Locale;

/**
 * Created by SF on 2017/1/24.
 */
public class CurrencyDemo {
    public static void main(String[] args) {
//        Currency currency = Currency.getInstance("USD");
        Currency us = Currency.getInstance(Locale.US);
        Currency french = Currency.getInstance(Locale.FRANCE);

        System.out.println(us.getSymbol());
        System.out.println(french.getSymbol());
    }
}
