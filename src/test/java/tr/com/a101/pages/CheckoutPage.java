package tr.com.a101.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import tr.com.a101.base.Base;
import tr.com.a101.methods.Methods;

public class CheckoutPage extends Methods {
    private static final Logger logger = LogManager.getLogger(CheckoutPage.class);
    public static final By withoutMembership = By.xpath("//*[contains(text(),'ÜYE OLMADAN DEVAM ET')]");
    public static final By enteredEmail = By.cssSelector("input[name='user_email']");
    public static final By confirmEmail = By.xpath("//button[contains(text(),'DEVAM ET')]");
    public static final By createAdressButton = By.xpath("(//*[@title='Yeni adres oluştur'])[1]");
    public static final By addressTitle = By.cssSelector("input[name='title']");
    public static final By addressFirstName = By.cssSelector("input[name='first_name']");
    public static final By addressLastName = By.cssSelector("input[name='last_name']");
    public static final By addressPhoneNumber = By.cssSelector("input[name='phone_number']");
    public static final By addressCity = By.cssSelector("select[name='city']");
    public static final By addressTownship = By.cssSelector("select[name='township']");
    public static final By addressDistrict = By.xpath("//select[@name='district']");
    public static final By addressAdressDetails = By.className("js-address-textarea");
    public static final By addressSaveButton = By.xpath("//button[contains(text(),'KAYDET')]");
    public static final By addressSaveButtonTwo = By.xpath("//button[contains(text(),'Kaydet ve Devam Et')]");
    public static final By completeOrderButton = By.xpath("//span[contains(text(),'Siparişi Tamamla')][@class='order-complete']");
    public static final By paymentPageControl = By.xpath("//div[@class=\"installment-area\"]//span[@class='error']");


    public void goOnWithoutMembership() {

        clickToElement(withoutMembership);
        randomEmailGenerator(enteredEmail);
        clickToElement(confirmEmail);
    }

    public void createAdress() {
        clickToElement(createAdressButton);
        sendKey(addressTitle, "Evim");
        sendKey(addressFirstName, "Eralp");
        sendKey(addressLastName, "Sergin");
        sendKey(addressPhoneNumber, "5545545545");
        selectByValue(addressCity, "41"); // İzmir 41
        waitByMilliSeconds(250);
        selectByValue(addressTownship, "494"); // Buca 494
        waitByMilliSeconds(750);
        selectByValue(addressDistrict, "36703"); // Adatepe 36703
        sendKey(addressAdressDetails, "A101 Selenium Training...");
        clickToElement(addressSaveButton);
        waitBySeconds(3);
        clickToElement(addressSaveButtonTwo);
        logger.info("*****  Adres başarılı bir şekilde kayıt edildi.  *****");


    }

    public void completeAndControlOrder(String text) {
        clickToElement(completeOrderButton);
        assertionTextControl(paymentPageControl, text);


    }


}
