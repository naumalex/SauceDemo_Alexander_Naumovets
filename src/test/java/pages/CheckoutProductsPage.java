package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutProductsPage extends BaseProductsPage {

    private final By firstNameInput = By.cssSelector("#first-name");
    private final By lastNameInput = By.cssSelector("#last-name");
    private final By postalCodeInput = By.cssSelector("#postal-code");
    private final By continueButton = By.cssSelector("#continue");
    private final By cancelButton = By.cssSelector("#cancel");

    public CheckoutProductsPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void setPostalCode(String postalCode) {
        driver.findElement(postalCodeInput).sendKeys(postalCode);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void clickCancelButton() {
        driver.findElement(cancelButton).click();
    }
    @Step
    public void checkoutProduct(String firstName, String lastName,
                                String postalCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setPostalCode(postalCode);
        clickContinueButton();
    }

}
