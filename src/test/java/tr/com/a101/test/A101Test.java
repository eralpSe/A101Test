package tr.com.a101.test;

import org.junit.jupiter.api.Test;
import tr.com.a101.base.Base;
import tr.com.a101.pages.*;

public class A101Test extends Base {
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CategoryPage categoryPage = new CategoryPage();
    BasketPage basketPage = new BasketPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void testMethod() {

        homePage.homePageLoadSuccess();                                              /** Sayfanın açılıp yüklendiği doğrulanır.**/
        homePage.hoverToSocksMenu();                                                 /** Giyim>Kadın>Çorap>Dizaltı Çorap Kategorisine tıklanır.**/
        categoryPage.clickToSocks();                                                 /** Siyah çorap seçilir.**/
        productPage.colorControlAssertion("Siyah");                              /** Seçilen çorabın siyah olduğu kontrol edilir.**/
        productPage.addToBasketAndGoToBasket();                                      /** Ürün sepete eklendikten sonra sepete gidilir.**/
        basketPage.confirmBasket();                                                  /**Sepeti onayla butonuna tıklanır.**/
        checkoutPage.goOnWithoutMembership();                                        /** Üye olmadan devam et dedikten sonra rastgele mail oluşturulup devam edilir.**/
        checkoutPage.createAdress();                                                 /** Adres bilgileri girilir ve Kaydedilir. **/
        checkoutPage.completeAndControlOrder("Lütfen kart seçin veya kart bilgisi girin.");/** Sipariş tamamlanır ve Kredi kartı sayfası kontrol edilir**/


    }
}
