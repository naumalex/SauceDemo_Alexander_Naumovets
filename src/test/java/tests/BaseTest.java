 package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
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
    protected ShoppingCartProductsPage shoppingCartPage;
    protected CheckoutProductsPage checkoutPage;
    protected CheckoutOverviewProductsPage checkoutOverviewPage;


    @Parameters({"browser"})
    @BeforeClass (alwaysRun = true)
    public void setUp(@Optional("chrome") String browserName,
                      ITestContext testContext) throws Exception {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else {
            throw new Exception("Undefined Browser Type");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        itemDetailsPage = new ItemDetailsPage(driver);
        shoppingCartPage = new ShoppingCartProductsPage(driver);
        checkoutPage = new CheckoutProductsPage(driver);
        checkoutOverviewPage = new CheckoutOverviewProductsPage(driver);
        testContext.setAttribute("driver", driver);
    }


    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void ClearCookies() {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.clear();"));
        ((JavascriptExecutor) driver).executeScript(String.format("window.sessionStorage.clear();"));
    }
    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
    }
}
