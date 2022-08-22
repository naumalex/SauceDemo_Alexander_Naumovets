package tests;

import Utils.AllureUtils;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class TestExecutionListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.afterInvocation(method, testResult);
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("New listener run");
            AllureUtils.attachScreenshot((WebDriver)testResult
                    .getTestContext().getAttribute("driver"));
        }
    }
}
