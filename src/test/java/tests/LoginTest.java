package tests;

import Utils.AllureUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression", "test"}, description = "Log in with correct credentials. "
    + "Verify that login is successful.")
    @Issue("0001")
    @TmsLink("tc0001")
    public void positiveLoginTest() {
       loginPage.login("standard_user", "secret_sauce");
        /* loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();*/
        /*Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed(),
                "Login is not successful");*/
        //Allure.addAttachment("Result", "text/plain", "link");
        checkLoginSuccessful();
    }

    @Test(groups = {"negative"}, dataProvider = "login",
    description = "Data Driven Test. Log in with not valid credentials. Verify "
    + "that appropriate error message is shown.")
    public void negativeLoginTest(String userName, String password,
                                  String expectedMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Login is successful");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: "
                + expectedMessage);
    }

    @DataProvider(name="login")
    public Object[][] getLoginDataFromDataProvider(){
        return new Object[][]
                {
                        { "", DEFAULT_PASSWORD, "Username is required"},
                        { DEFAULT_USER_NAME, "incorrectPassword",
                                "Username and password do not match any user in this service" },
                        { "incorrectUserName", DEFAULT_PASSWORD,
                                "Username and password do not match any user in this service"},
                        {"locked_out_user", DEFAULT_PASSWORD, "Sorry, this user has been locked out."}
                };
    }

    @Step
    private void checkLoginSuccessful() {
        Assert.assertTrue(!productsPage.isProductsPageHeaderDisplayed(),
                "Login is not successful");
    }
}
