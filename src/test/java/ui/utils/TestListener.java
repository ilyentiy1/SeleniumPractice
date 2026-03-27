package ui.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ui.tests.BaseTest;

import java.io.File;
import java.io.IOException;

public class TestListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = BaseTest.getDriver();

        if (driver != null) {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile, new File("src/test/resources/screenshots/"
                        + "screenshot_" + System.currentTimeMillis() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Screenshot skip: WebDriver is null");
        }
    }
}
