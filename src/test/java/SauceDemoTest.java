import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SauceDemoTest extends BaseTest {

    private String getUserName() {
        final int INDEX_OF_STANDARD_USER_NAME = 1;
        String userNameSectionText = driver.findElement(By.cssSelector("#login_credentials"))
                .getAttribute("innerText");

        return userNameSectionText.split("\n")[INDEX_OF_STANDARD_USER_NAME];
    }

    private String getPassword() {
        final int INDEX_OF_PASSWORD = 1;
        String userNameSectionText = driver.findElement(
                By.cssSelector("#login_credentials+div.login_password"))
                .getAttribute("innerText");
        return userNameSectionText.split("\n")[INDEX_OF_PASSWORD];
    }

    public void login() {
        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.sendKeys(getUserName());
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(getPassword());
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    private void openItem(String name) {
        String xpath = String.format(
                "//div[text()='%s']/ancestor::a", name);
        WebElement productLink = driver.findElement(By.xpath(xpath));
        Actions actions = new Actions(driver);
        actions.moveToElement(productLink).perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(driver -> driver.findElement(By.xpath(xpath)).isDisplayed());
        productLink.click();
    }

    private void  addItemToCart() {
        WebElement addToCartButton = driver.findElement(
                By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
        addToCartButton.click();
    }

    private void openShoppingCart() {
        WebElement shoppingCartLink = driver.findElement(
                By.cssSelector(".shopping_cart_link"));
        shoppingCartLink.click();
    }

    @BeforeClass
    public void navigate() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void sourceDemoTest() {
        final String PRODUCT_NAME = "Sauce Labs Onesie";
        final String PRODUCT_PRICE = "$7.99";
        login();
        openItem(PRODUCT_NAME);
        addItemToCart();
        openShoppingCart();
        String actualProductName = driver.findElement(
                By.cssSelector(".cart_item_label div.inventory_item_name")).getText();
        Assert.assertEquals(actualProductName, PRODUCT_NAME,
                "Product name in the Shopping Cart is incorrect");

        String actualProductPrice = driver.findElement(
                By.cssSelector(".cart_item_label div.inventory_item_price"))
                .getText();
        Assert.assertEquals(actualProductPrice, PRODUCT_PRICE,
                "Product price in the Shopping Cart is incorrect");
    }
}

