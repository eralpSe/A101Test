package tr.com.a101.pages;

import org.openqa.selenium.By;
import tr.com.a101.methods.Methods;

public class BasketPage extends Methods {

    public static final By confirmBasket = By.xpath("//*[@href=\"/orders/checkout/\"][@title='Sepeti Onayla']");


    public void confirmBasket() {
        clickToElement(confirmBasket);
    }


}