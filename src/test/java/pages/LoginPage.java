package pages;

import Utils.AllureUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(css = "#user-name")
    WebElement userNameInput;
    @FindBy(css = "#password")
    WebElement passwordInput;
    @FindBy(css = "#login-button")
    WebElement loginButton;
    @FindBy(css = ".error-message-container")
    WebElement errorMessageContainer;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Step
    public void login(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
     //  AllureUtils.attachScreenshot(driver);
    }

    public void setUserName(String userName) {
        userNameInput.sendKeys(userName);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessageContainer.isDisplayed();
    }

    public String getErrorText() {
        return errorMessageContainer.getText();
    }
}
