package tr.com.a101.pages;

import org.openqa.selenium.By;
import tr.com.a101.methods.Methods;

public class CategoryPage extends Methods {

    public static final By blackWomenSocks = By.xpath("(//ul[@class=\"product-list-general\"]/li//a[contains(@href,'corabi-siyah')])[1]");


    public void clickToSocks() {
        waitByMilliSeconds(400);
        clickToElement(blackWomenSocks);
    }


}
