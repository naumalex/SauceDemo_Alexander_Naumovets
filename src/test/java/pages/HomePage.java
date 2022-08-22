package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HomePage extends BasePage {

    //header controls
    private final By shoppingCartLink = By.cssSelector(".shopping_cart_link");
    private final By shoppingCartBadgeLocator = By.cssSelector(".shopping_cart_badge");
    private final By pageHeader = By.cssSelector("#header_container .title");


    //footer controls
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @Step
    public void openShoppingCart() {
        driver.findElement(shoppingCartLink).click();
    }

    public String getPageHeader() {
        return driver.findElement(pageHeader).getText();
    }
    public int getNumberOfItemsInShoppingCart() {
        WebElement shoppingCartBadge;
        try {
            shoppingCartBadge = driver.findElement(shoppingCartBadgeLocator);
        }
        catch(NoSuchElementException exception) {
            return 0;
        }
        return Integer.parseInt(shoppingCartBadge.getText());
    }
}

