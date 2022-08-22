package tests;

import Utils.AllureUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("Test " + result.getName() + " started");
    }

    @Override
   // @Step
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
       // Allure.addAttachment("Result", "text/plain", "link");
        WebDriver driver  = (WebDriver) result.getTestContext().getAttribute("driver");
       // AllureUtils.attachScreenshot(driver);
     //   File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println("Test " + result.getName() + " successfully  finished");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("Test " + result.getName() + " failed");
        WebDriver driver  = (WebDriver) result.getTestContext().getAttribute("driver");
       // Allure.addAttachment("Result", "text/plain", "link");
       AllureUtils.attachScreenshot(driver);
       // File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      //  System.out.println(file.getAbsolutePath());
    }
}
