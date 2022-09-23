package tr.com.a101.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import tr.com.a101.methods.Methods;

public class ProductPage extends Methods {
    private static final Logger logger = LogManager.getLogger(ProductPage.class);

    public static final By colorControlFromName = By.xpath("//*[@class=\"product-name js-name\"]");
    public static final By wiewBasketButton = By.xpath("(//a[@title=\"Sepeti Görüntüle\"])[2]");
    public static final By addToBasket = By.xpath("//button[@class='add-to-basket button green block with-icon js-add-basket']");

    public void colorControlAssertion(String text) {
        assertionTextControl(colorControlFromName, text);
        logger.info(" Siyah renk ürün olduğu doğrulandı. ");

    }

    public void addToBasketAndGoToBasket() {
        clickToElement(addToBasket);
        clickToElement(wiewBasketButton);
        logger.info(" ------- Ürün Sepetine Gidiliyor. --------- ");

    }
}
