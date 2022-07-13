import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    final String DEFAULT_USER_NAME = "standard_user";
    final String DEFAULT_PASSWORD = "secret_sauce";
    final String DEFAULT_PRODUCT_NAME = "Sauce Labs Fleece Jacket";
    final String DEFAULT_PRODUCT_DESCRIPTION = "It's not every day that you come across a midweight " +
            "quarter-zip fleece jacket capable of handling everything from a relaxing day" +
            " outdoors to a busy day at the office.";
    final String DEFAULT_PRODUCT_PRICE = "$49.99";

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ItemDetailsPage itemDetailsPage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverviewPage checkoutOverviewPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }


    @BeforeMethod
    public void navigate() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
}
