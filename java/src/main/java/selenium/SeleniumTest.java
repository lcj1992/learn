package selenium;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by lcj on 15-4-29.
 */
public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
//        设置10秒
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String url = "http://www.baidu.com";
        driver.get("file:///home/lcj/b.htm");

        List<WebElement> errorMsg = driver.findElements(By.xpath("//*[@class=\"ui-field-error-message\"]"));

        for (WebElement webElement : errorMsg) {
        System.out.println(webElement.isDisplayed() + webElement.getText());
        System.out.println(Strings.isNullOrEmpty(webElement.getText()));
        }

        driver.get(url);

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ESCAPE);// 模拟按下并释放空格键

        WebElement input = driver.findElement(By.id("kw"));
        input.clear();
        input.sendKeys("baidu");
        driver.findElement(By.id("su")).click();
        driver.navigate().back();
        input = driver.findElement(By.id("kw"));
        input.sendKeys("baidu");
        driver.findElement(By.id("su")).click();


        Set<String> tabTitle = driver.getWindowHandles();
        for (String s : tabTitle) {
        driver.switchTo().window(s);
        System.out.println(driver.getTitle());
        if (driver.getTitle().contains("词语概念")) {
        System.out.println(driver.getTitle());
        break;
        }
        }
        Thread.sleep(10000L);
        System.out.println(driver.getCurrentUrl());

        Wait<WebDriver> wait1 = new WebDriverWait(driver, 10);

        driver.get("www.airchina.com.cn");

        long start = System.currentTimeMillis();
        waitForPageLoaded(driver,10);


        System.out.println(System.currentTimeMillis() - start);
    }

    public static void waitForPageLoaded(WebDriver driver, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(new Predicate<WebDriver>() {

            public boolean apply(WebDriver input) {
                return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
            }
        });
    }

}
