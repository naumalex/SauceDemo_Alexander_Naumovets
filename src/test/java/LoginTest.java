import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {


    @Test
    public void positiveLoginTest() {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(productsPage.isProductsPageHeaderDisplayed(),
                "Login is not successful");

    }

    @Test
    public void negativeLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "Login is successful");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required");
    }
}
