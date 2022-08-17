package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseProductsPage extends HomePage {
    private final String productsListContainer =
            "//div[@class = 'inventory_item_name' and text()='%s']" +
                    "/ancestor::div[@class = 'inventory_item' or @class = 'cart_item']";
    protected final By productItemName = By.cssSelector(".inventory_item_name");
    protected final By productItemDescription = By.cssSelector(".inventory_item_desc");
    protected final By productItemPrice = By.cssSelector(".inventory_item_price");

    public BaseProductsPage(WebDriver driver) {
        super(driver);
    }
    protected WebElement getProductsContainerByName(String productName) {
        return driver.findElement(
                By.xpath(String.format(productsListContainer, productName)));
    }
    public String getProductDescription(String productName) {
        return getProductsContainerByName(productName)
                .findElement(productItemDescription).getText();
    }
    public String getProductPrice(String productName) {
        return getProductsContainerByName(productName).findElement(productItemPrice).getText();
    }

    public List<WebElement> getProductItems() {
        return driver.findElements(productItemName);
    }
    public List<String> getProductItemsNames() {
        List<String> productNames;
        productNames = getProductItems().stream()
                .map(p -> p.getText()).toList();
        return productNames;
    }

    public List<Double> getProductItemsPrices() {
        List<Double> productPrices;
        productPrices = driver.findElements(productItemPrice).stream()
                .map(p -> Double.parseDouble(
                        (p.getText().replace('$', '\0'))))
                .toList();
        return productPrices;
    }

}
