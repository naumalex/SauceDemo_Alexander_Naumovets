import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ItemDetailsPage;

public class ItemDetailsTest extends BaseTest {

    final String PRODUCT_NAME = "Sauce Labs Fleece Jacket";
    final String PRODUCT_DESCRIPTION = "It's not every day that you come across a midweight " +
            "quarter-zip fleece jacket capable of handling everything from a relaxing day" +
            " outdoors to a busy day at the office.";
    final String PRODUCT_PRICE = "$49.99";

    ItemDetailsPage itemDetailsPage;

    @BeforeClass
    public void initialize() {
        itemDetailsPage = new ItemDetailsPage(driver);
    }

    @Test
    public void verifyItemNameAndPriceOnDetailsPage() {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);
        productsPage.openItemByName(PRODUCT_NAME);
        Assert.assertEquals(itemDetailsPage.getItemDescription(), PRODUCT_DESCRIPTION,
                "Product description is different from the expected value");
        Assert.assertEquals(itemDetailsPage.getProductPrice(), PRODUCT_PRICE,
                "Product price is different from the expected value");
    }
}
