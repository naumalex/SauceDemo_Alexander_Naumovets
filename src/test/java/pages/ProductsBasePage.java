package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsBasePage extends HomePage {
    private final String productsListContainer =
            "//div[@class = 'inventory_item_name' and text()='%s']" +
                    "/ancestor::div[@class = 'inventory_item' or @class = 'cart_item']";
    private final By cartItemDescription = By.cssSelector(".inventory_item_desc");
    private final By cartItemPrice = By.cssSelector(".inventory_item_price");

    public ProductsBasePage(WebDriver driver) {
        super(driver);
    }
    protected WebElement getProductsContainerByName(String productName) {
        return driver.findElement(
                By.xpath(String.format(productsListContainer, productName)));
    }
    public String getProductDescription(String productName) {
        return getProductsContainerByName(productName)
                .findElement(cartItemDescription).getText();
    }
    public String getProductPrice(String productName) {
        return getProductsContainerByName(productName).findElement(cartItemPrice).getText();
    }
}
