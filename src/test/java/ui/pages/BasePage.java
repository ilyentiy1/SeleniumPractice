package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.tests.BaseTest;

import java.time.Duration;

abstract public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected BasePage() {
        this.driver = BaseTest.getDriver();

        if (this.driver != null) {
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            this.actions = new Actions(driver);
            PageFactory.initElements(driver, this);
        }
    }

    protected WebElement find(String xpathExpression) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
    }
}
