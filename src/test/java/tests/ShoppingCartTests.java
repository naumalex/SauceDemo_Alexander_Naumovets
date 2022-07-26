package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTests extends BaseTest {
    final String PAGE_HEADER = "YOUR CART";

    @Test(groups = {"regression"}, description = "Add an item to the shopping cart "
    + "from the Products page. Verify that description and price are correct.")
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

    @Test(groups = {"regression"}, description = "Add an item to the shopping cart "
            + "from the Products page and remove it. Verify that no items were left in the shopping "
    + "cart.")
    public void removeProductFromShoppingCartFromProductsPage() {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        productsPage.clickAddToCartButton(DEFAULT_PRODUCT_NAME);
        Assert.assertEquals(productsPage.getNumberOfItemsInShoppingCart(),
                1,"Shopping cart should contain 1 item");
        productsPage.clickRemoveButton(DEFAULT_PRODUCT_NAME);
        Assert.assertEquals(productsPage.getNumberOfItemsInShoppingCart(),
                0,"Shopping cart should be empty");
    }
    @Test(groups = {"regression"}, description = "Add an item to the shopping cart "
            + "from the Item Details page. Verify that description and price are correct.")
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
    }

    @Test(groups = {"regression"}, description = "Add an item to the shopping cart "
            + "from the Products page. Open Shopping Cart and Remove it. verify that the "
    + "the shopping cart is empty.")
    public void removeProductFromShoppingCart() {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        productsPage.clickAddToCartButton(DEFAULT_PRODUCT_NAME);
        productsPage.openShoppingCart();
        shoppingCartPage.clickRemove(DEFAULT_PRODUCT_NAME);
        Assert.assertFalse(shoppingCartPage.getProductItems().size() > 0,
                "Product item was not removed from the Shopping Cart");
    }
}
