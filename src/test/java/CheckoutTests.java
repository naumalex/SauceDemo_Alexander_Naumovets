import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {
    final String FIRST_NAME = "Alexander";
    final String LAST_NAME = "Smith";
    final String POSTAL_CODE = "12345";
    final String PAGE_HEADER = "CHECKOUT: YOUR INFORMATION";


    @Test
    public void payForProduct() {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        productsPage.openItemByName(DEFAULT_PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.openShoppingCart();
        shoppingCartPage.clickCheckoutButton();
        Assert.assertEquals(checkoutPage.getPageHeader(),PAGE_HEADER,
                "Page header is incorrect");
        checkoutPage.checkoutProduct(FIRST_NAME, LAST_NAME, POSTAL_CODE);

        Assert.assertEquals(checkoutOverviewPage.getProductDescription(DEFAULT_PRODUCT_NAME),
                DEFAULT_PRODUCT_DESCRIPTION,
                "Product description is different from the expected value");
        Assert.assertEquals(checkoutOverviewPage.getProductPrice(DEFAULT_PRODUCT_NAME),
                DEFAULT_PRODUCT_PRICE,
                "Product price is different from the expected value");
        checkoutOverviewPage.clickFinishButton();
    }
}
