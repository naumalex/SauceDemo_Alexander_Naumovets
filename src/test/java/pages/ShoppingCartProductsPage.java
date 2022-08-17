package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartProductsPage extends BaseProductsPage {

    private final By checkoutButton = By.cssSelector("#checkout");
    private final By removeButton = By.cssSelector("[id^='remove']");
    public ShoppingCartProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void clickRemove(String productItemName) {
        getProductsContainerByName(productItemName).findElement(removeButton).click();
    }
}
