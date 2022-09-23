package tr.com.a101.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import tr.com.a101.base.Base;

import java.util.Random;

public class Methods extends Base {


    JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

    private static final Logger logger = LogManager.getLogger(Methods.class);


    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        logger.info(by.toString() + " Element bulundu.");
        return driver.findElement(by);
    }

    public int randomPick(int size) {
        Random rand = new Random();
        int minimum = 1;
        int pick = rand.nextInt(size - minimum) + minimum;
        logger.info(minimum + " değeri ile " + size + " değeri arasında rastgele seçilen sayı : " + pick);
        return pick;
    }

    public void randomEmailGenerator(By by) {
        int number = randomPick(30000);
        sendKey(by, number + "@denemeMail.com");
        logger.info(by.toString() + " 'a " + number + "@denemeMail.com  mail adresi üretilip gönderildi.");

    }

    public void hoverElement(By by) {

        WebElement webElement = findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
        logger.info(by.toString() + " elementine hover işlemi yapıldı");
    }

    public void pageControl(By by) {
        Assertions.assertTrue(findElement(by).isDisplayed(), "Sayfa bulunamadı.");
        logger.info(by.toString() + " sayfa yüklendiği kontrol edildi.");
    }

    public void assertionTextControl(By by, String text) {

        Assertions.assertTrue(findElement(by).getText().contains(text), "Textlerin birbirini içermediği görüldü.");

        logger.info(by.toString() + " elementindeki yazı ile " + text + " yazısı karşılaştırıldı.");
    }

    public void clickToElement(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
        logger.info(by.toString() + " elementine tıklandı.");


    }

    public void sendKey(By by, String key) {
        findElement(by).sendKeys(key);
        logger.info(by.toString() + " elementine " + key + " texti yazıldı.");
    }

    public Select getSelect(By by) {

        return new Select(findElement(by));
    }

    public void selectByValue(By by, String value) {

        getSelect(by).selectByValue(value);
    }

    public void waitBySeconds(long seconds) {

        waitByMilliSeconds(1000 * seconds);
        logger.info(seconds + " saniye beklendi");
    }

    public void waitByMilliSeconds(long milliSeconds) {

        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (milliSeconds % 1000 != 0)
            logger.info(milliSeconds + " milisaniye beklendi");
    }

}
