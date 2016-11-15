package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by SF on 2016/8/2.
 */
public class FirstWebDriver {
    public static void main(String []args) {
//        System.setProperty("webdriver.firefox.driver", "D:\\program files (x86)\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver = webDriverFactory(DriverType.Chrome);
        driver.get("http://www.baidu.com/");
        driver.manage().window().maximize();
        WebElement txtInput = driver.findElement(By.name("wd"));
        txtInput.sendKeys("段杰东");
        WebElement btnSearch = driver.findElement(By.id("su"));
        btnSearch.click();

    }

    private static WebDriver webDriverFactory(DriverType type) {
        switch (type) {
            case Firefox:
                return new FirefoxDriver();
            case Chrome:
                return new ChromeDriver();
            case Edge:
                return new EdgeDriver();
            default:
                return new FirefoxDriver();
        }
    }

    private enum DriverType {
        Firefox,
        Chrome,
        Edge;

        DriverType() {
        }
    }
}
