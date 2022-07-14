import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ProductsTests extends BaseTest {

    @Test
    public void testSorting() {
        loginPage.login(DEFAULT_USER_NAME, DEFAULT_PASSWORD);

        List<String> productsList = productsPage.getProductItemsNames();
        productsPage.sortProductItems("Name (A to Z)");
        List<String> expectedList = productsList.stream().sorted().toList();
        List<String> actualList = productsPage.getProductItemsNames();
        Assert.assertEquals(actualList, expectedList,
                "Sorting by name ascending is incorrect");

        productsList = productsPage.getProductItemsNames();
        productsPage.sortProductItems("Name (Z to A)");
        expectedList = productsList.stream().sorted(Comparator.reverseOrder()).toList();
        actualList = productsPage.getProductItemsNames();
        Assert.assertEquals(actualList, expectedList,
                "Sorting by name ascending is incorrect");

        List<Double> productsPricesList = productsPage.getProductItemsPrices();
        productsPage.sortProductItems("Price (low to high)");
        List<Double> expectedPricesList = productsPricesList.stream().sorted().toList();
        List<Double> actualPricesList = productsPage.getProductItemsPrices();
        Assert.assertEquals(expectedPricesList, actualPricesList,
                "Sorting by price ascending is incorrect");

        productsPricesList = productsPage.getProductItemsPrices();
        productsPage.sortProductItems("Price (high to low)");
        expectedPricesList = productsPricesList.stream()
                .sorted(Comparator.reverseOrder()).toList();
        actualPricesList = productsPage.getProductItemsPrices();
        Assert.assertEquals(expectedPricesList, actualPricesList,
                "Sorting by price ascending is incorrect");
    }
}