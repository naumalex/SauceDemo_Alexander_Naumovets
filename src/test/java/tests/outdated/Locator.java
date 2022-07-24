package tests.outdated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

public class Locator extends BaseTest {

    public void testLocators() {
        WebElement locatorByID = driver.findElement(By.id("user-name"));
        WebElement locatorByName = driver.findElement(By.name("password"));
        WebElement locatorByClass = driver.findElement(By.className("input_error"));
        WebElement locatorByTagName = driver.findElement(By.tagName("div"));
        WebElement locatorByLinkText =
                driver.findElement(By.linkText("Sauce Labs Backpack"));
        WebElement locatorByPartialLinkText =
                driver.findElement(By.partialLinkText("Sauce Labs Backpack"));
        WebElement locatorXpathByAttribute = driver.findElement(
                By.xpath("//button[@name='remove-sauce-labs-backpack']"));
        WebElement locatorXpathByText = driver.findElement(
                By.xpath("//button[text()='Remove']"));
        WebElement locatorXpathByPartialAttributeValueMatch = driver.findElement(
                By.xpath("//div[contains(@id, 'container')]"));
        WebElement locatorXpathByPartialTextMatch = driver.findElement(
                By.xpath("//div[contains(text(), 'standard_user')]"));
        WebElement locatorXpathUsingAncestor = driver.findElement(
                By.xpath("//div[@id = 'login_credentials']/" +
                        "ancestor::div[@class = 'login_credentials_wrap']"));
        WebElement locatorXpathUsingDescendant = driver.findElement(
                By.xpath("//div[@id = 'login_credentials']/descendant::h4"));
        WebElement locatorXpathUsingFollowingSibling = driver.findElement(
                By.xpath("//div[@class = 'inventory_item']/following-sibling::div"));
        WebElement locatorXpathUsingParent = driver.findElement(
                By.xpath("//div[@class = 'inventory_item']/parent::div"));
        WebElement locatorXpathUsingPrecedingSibling = driver.findElement(
                By.xpath("//div[@class = \"inventory_item\"][2]/preceding-sibling::div"));
        WebElement locatorXpathUsingAnd = driver.findElement(
                By.xpath("//div[@id = 'inventory_container' and @class = 'inventory_container']"));
        WebElement locatorCssByClass = driver.findElement(
                By.cssSelector(".pricebar"));
        WebElement locatorCssByTwoClasses = driver.findElement(
                By.cssSelector(".btn.btn_primary"));
        WebElement locatorCssByParentClassAndDescendingClass = driver.findElement(
                By.cssSelector(".pricebar .btn"));
        WebElement locatorCssById = driver.findElement(
                By.cssSelector("#inventory_container"));
        WebElement locatorCssByTagName = driver.findElement(
                By.cssSelector("div"));
        WebElement locatorCssByTagNameAndClass = driver.findElement(
                By.cssSelector("div.inventory_list"));
        WebElement locatorCssByAttributeValue = driver.findElement(
                By.cssSelector("[data-test = 'product_sort_container']"));
        WebElement locatorCssByContainWordAttributeValue = driver.findElement(
                By.cssSelector("[class~='login']"));
        WebElement locatorCssByEqualOrStartWithAttributeValue = driver.findElement(
                By.cssSelector("[class|='submit']"));
        WebElement locatorCssByStartWithAttributeValue = driver.findElement(
                By.cssSelector("[class^='login_w']"));
        WebElement locatorCssByEndWithAttributeValue = driver.findElement(
                By.cssSelector("[class$='logo']']"));
        WebElement locatorCssByContainsAttributeValue = driver.findElement(
                By.cssSelector("[class*='logo']']"));
    }
}
