package tr.com.a101.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    private static final Logger logger = LogManager.getLogger(Base.class);

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeAll
    public static void beforeAll() {

        logger.info("****** Before All ******");

    }

    @BeforeEach
    public void beforeMethod() {

        logger.info("========= Before =========");
        logger.info("  -------       Test is starting...       --------    ");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("disable-plugins");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("ignore-certificate-errors");
        chromeOptions.addArguments("disable-translate");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        chromeOptions.merge(desiredCapabilities);
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        logger.info("               driver executed...                   ");
        driver.get("https://www.a101.com.tr/");


    }


    @AfterEach
    public void afterEach() {

        if (driver != null) {
            driver.quit();
        }


        logger.info("  -----       Test ended.        -------     ");
        logger.info("========= After =========");


    }

    @AfterAll
    public static void afterAll() {

        logger.info("****** After All ******");
    }


}
