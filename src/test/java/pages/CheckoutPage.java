package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends ProductsBasePage {

    private final By firstNameInput = By.cssSelector("#first-name");
    private final By lastNameInput = By.cssSelector("#last-name");
    private final By postalCodeInput = By.cssSelector("#postal-code");
    private final By continueButton = By.cssSelector("#continue");

    public CheckoutPage(WebDriver driver) {
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

    public void checkoutProduct(String firstName, String lastName,
                                String postalCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setPostalCode(postalCode);
        clickContinueButton();
    }

}
