package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    By userNameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessageContainer = By.cssSelector(".error-message-container");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
    }

    public void setUserName(String userName) {
        driver.findElement(userNameInput).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessageContainer).isDisplayed();
    }

    public String getErrorText() {
        return driver.findElement(errorMessageContainer).getText();
    }
}
