package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ItemDetailsPage;

public class ItemDetailsTest extends BaseTest {

    final String PRODUCT_NAME = "Sauce Labs Fleece Jacket";
    final String PRODUCT_DESCRIPTION = "It's not every day that you come across a midweight " +
            "quarter-zip fleece jacket capable of handling everything from a relaxing day" +
            " outdoors to a busy day at the office.";
    final String PRODUCT_PRICE = "$49.99";

    ItemDetailsPage itemDetailsPage;

    @BeforeClass(alwaysRun = true)
    public void initialize() {
        itemDetailsPage = new ItemDetailsPage(driver);
    }

    @Test(groups = {"regression"}, dataProvider = "productItemData",
            description = "Dta Driven Test. Open Item details page for different "
                    + "products. Verify that their description and price are correct")
    public void verifyItemNameAndPriceOnDetailsPage(
            String productName, String productDescription, String productPrice) {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        productsPage.openItemByName(productName);
        Assert.assertEquals(itemDetailsPage.getItemDescription(), productDescription,
                "Product description is different from the expected value");
        Assert.assertEquals(itemDetailsPage.getProductPrice(), productPrice,
                "Product price is different from the expected value");
    }

    @DataProvider(name = "productItemData")
    public Object[][] getProductItemDataFromDataProvider(){
        return new Object[][]
                {
                        { DEFAULT_PRODUCT_NAME, DEFAULT_PRODUCT_DESCRIPTION, DEFAULT_PRODUCT_PRICE},
                        { "Sauce Labs Backpack", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds"
                                + " uncompromising style with unequaled laptop and tablet protection.",
                                "$29.99" },
                        { "Test.allTheThings() T-Shirt (Red)", "This classic Sauce Labs t-shirt is perfect to wear"
                                + " when cozying up to your keyboard to automate a few tests. Super-soft and comfy"
                                + " ringspun combed cotton.",
                                "$15.99"},
                };
    }
}
