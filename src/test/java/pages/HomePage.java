package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    //header controls
    private final By shoppingCartLink = By.cssSelector(".shopping_cart_link");
    private final By pageHeader = By.cssSelector("#header_container .title");

    //footer controls
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openShoppingCart() {
        driver.findElement(shoppingCartLink).click();
    }

    public String getPageHeader() {
        return driver.findElement(pageHeader).getText();
    }
}
