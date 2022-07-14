import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseProductsPage;

public class ShoppingCartTests extends BaseTest {
    final String PAGE_HEADER = "YOUR CART";

    @Test
    public void addProductToShoppingCartFromProductsPage() {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        productsPage.clickAddToCartButton(DEFAULT_PRODUCT_NAME);
        productsPage.openShoppingCart();
        Assert.assertEquals(shoppingCartPage.getPageHeader(), PAGE_HEADER,
                "Page header is incorrect");
        Assert.assertEquals(shoppingCartPage.getProductDescription(DEFAULT_PRODUCT_NAME),
                DEFAULT_PRODUCT_DESCRIPTION,
                "Product description is different from the expected value");
        Assert.assertEquals(shoppingCartPage.getProductPrice(DEFAULT_PRODUCT_NAME),
                DEFAULT_PRODUCT_PRICE,
                "Product price is different from the expected value");
    }

    @Test
    public void addProductToShoppingCartFromItemDetailsPage() {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        productsPage.openItemByName(DEFAULT_PRODUCT_NAME);
        itemDetailsPage.clickAddToCartButton();
        itemDetailsPage.openShoppingCart();
        Assert.assertEquals(shoppingCartPage.getPageHeader(), PAGE_HEADER,
                "Page header is incorrect");
        Assert.assertEquals(shoppingCartPage.getProductDescription(DEFAULT_PRODUCT_NAME),
                DEFAULT_PRODUCT_DESCRIPTION,
                "Product description is different from the expected value");
        Assert.assertEquals(shoppingCartPage.getProductPrice(DEFAULT_PRODUCT_NAME),
                DEFAULT_PRODUCT_PRICE,
                "Product price is different from the expected value");
        checkoutOverviewPage.clickFinishButton();
    }

    @Test
    public void removeProductFromShoppingCart() {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        productsPage.clickAddToCartButton(DEFAULT_PRODUCT_NAME);
        productsPage.openShoppingCart();
        shoppingCartPage.clickRemove(DEFAULT_PRODUCT_NAME);
        Assert.assertFalse(shoppingCartPage.getProductItems().size() > 0,
                "Product item was not removed from the Shopping Cart");
    }
}
