package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewProductsPage extends BaseProductsPage {

    private final By finishButton = By.cssSelector("#finish");

    public CheckoutOverviewProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void clickFinishButton() {
       driver.findElement(finishButton).click();
    }
}
