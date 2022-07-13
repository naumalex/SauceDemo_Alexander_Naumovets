package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends ProductsBasePage {
    private final By addToCartButton = By.cssSelector("[id^='add-to-cart']");
    private final By productLink = By.cssSelector("[id$='_link']");
    /*private final String productContainerLocator =
            "//div[@class = 'inventory_item_name' and text()='%s']" +
                    "/ancestor::div[@class = 'inventory_item']";*/
    By productsPageHeader = By.id("header_container");
    By productItems = By.cssSelector(".inventory_item");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageHeaderDisplayed() {
        return driver.findElement(productsPageHeader).isDisplayed();
    }

    public void clickAddToCartButton(String name) {
        WebElement productContainer = getProductsContainerByName(name);
        productContainer.findElement(addToCartButton).click();
    }

    public void openItemByName(String productName) {
        WebElement productContainer = getProductsContainerByName(productName);
        productContainer.findElement(productLink).click();

    }
    public List<WebElement> getProductItems() {
        return driver.findElements(productItems);
    }

    public void sortProductItems() {

    }
    /*
    private WebElement getProductContainerByName(String productName) {
        return driver.findElement(
                By.xpath(String.format(productContainerLocator, productName)));
    }*/
}
