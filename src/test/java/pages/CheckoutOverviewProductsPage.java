package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewProductsPage extends BaseProductsPage {

    private final By finishButton = By.cssSelector("#finish");

    public CheckoutOverviewProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickFinishButton() {
       driver.findElement(finishButton).click();
    }
}
