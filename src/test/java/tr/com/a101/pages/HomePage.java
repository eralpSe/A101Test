package tr.com.a101.pages;

import org.openqa.selenium.By;
import tr.com.a101.methods.Methods;

public class HomePage extends Methods {

    public static final By mainLogo = By.cssSelector("a[class='logo']");
    public static final By acceptCookies = By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"][text()='Kabul Et']");
    public static final By wearAndAccessory = By.xpath("//div[@class='navigation-bar hide-on-app']//*[@href='/giyim-aksesuar/']");
    public static final By womenUnderKneeSocks = By.xpath("//*[@title=\"Dizaltı Çorap\"]");


    public void homePageLoadSuccess() {
        clickToElement(acceptCookies);
        pageControl(mainLogo);
    }

    public void hoverToSocksMenu() {
        hoverElement(wearAndAccessory);
        waitByMilliSeconds(1250);
        hoverElement(womenUnderKneeSocks);
        waitByMilliSeconds(300);
        clickToElement(womenUnderKneeSocks);
    }


}
