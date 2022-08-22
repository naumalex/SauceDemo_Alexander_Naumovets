package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class CheckoutTests extends BaseTest {
    final String FIRST_NAME = "Alexander";
    final String LAST_NAME = "Smith";
    final String POSTAL_CODE = "12345";
    final String PAGE_HEADER = "CHECKOUT: YOUR INFORMATION";


    @Test(groups = {"smoke", "regression"},description = "Add a product to the shopping cart "
            + " and checkout it. Verify that Enter Your Information page is opened. "
            + "Fill you information and continue checkout. Verify that the item description"
            + " and price are correct")

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

    @Test(groups = {"negative"}, description = "Leave empty Your Information"
    + " details while checking out. Verify that system does not allow to continue "
    + "without completing all the mandatory fields")
    public void payForProductWithNoYourInfoProvided() {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        productsPage.openItemByName(DEFAULT_PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.openShoppingCart();
        shoppingCartPage.clickCheckoutButton();
        checkoutPage.checkoutProduct("", "", "");
        Assert.assertEquals(checkoutPage.getPageHeader(),PAGE_HEADER,
                "Checkout: your information page is still should be opened");
    }

    @Test(groups = {"negative"}, description = "Click Cancel while checking out. "
    + "Verify that user was returned back to the Shopping Cart page")

    public void cancelCheckout() {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        productsPage.openItemByName(DEFAULT_PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.openShoppingCart();
        shoppingCartPage.clickCheckoutButton();
        checkoutPage.clickCancelButton();
        Assert.assertEquals(shoppingCartPage.getPageHeader(),"YOUR CART1",
                "Shopping Cart Page should be opened");
    }
}
