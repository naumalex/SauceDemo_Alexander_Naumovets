package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BaseProductsPage {
    private final By addToCartButton = By.cssSelector("[id^='add-to-cart']");
    private final By removeButton = By.cssSelector("[id^='remove']");
    private final By productLink = By.cssSelector("[id$='_link']");
    private final By sortSelect = By.cssSelector(
            "#header_container .product_sort_container");
    By productsPageHeader = By.id("header_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageHeaderDisplayed() {
        return driver.findElement(productsPageHeader).isDisplayed();
    }

    @Step
    public void clickAddToCartButton(String name) {
        WebElement productContainer = getProductsContainerByName(name);
        productContainer.findElement(addToCartButton).click();
    }

    @Step
    public void clickRemoveButton(String name) {
        WebElement productContainer = getProductsContainerByName(name);
        productContainer.findElement(removeButton).click();
    }
    @Step
    public void openItemByName(String productName) {
        WebElement productContainer = getProductsContainerByName(productName);
        productContainer.findElement(productLink).click();

    }
    @Step
    public void sortProductItems(String sortOption) {
        Select sortSelectElement = new Select(driver.findElement(sortSelect));
        sortSelectElement.selectByVisibleText(sortOption);
    }
}
