package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends ProductsBasePage {

    private final By checkoutButton = By.cssSelector("#checkout");
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
/*
    private WebElement getCheckoutSummaryContainerByName(String productName) {
        return driver.findElement(
                By.xpath(String.format(checkoutSummaryContainerLocator, productName)));
    }

    public String getProductDescription(String productName) {
        return getCheckoutSummaryContainerByName(productName)
                .findElement(cartItemDescription).getText();
    }

    public String getProductPrice(String productName) {
        return getCheckoutSummaryContainerByName(productName)
                .findElement(cartItemPrice).getText();
    }
*/
}
