package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends ProductsBasePage {

    private final By finishButton = By.cssSelector("#finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
}
