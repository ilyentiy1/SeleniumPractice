package ui.pages;

import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage {
    @Setter
    protected static ThreadLocal<RemoteWebDriver> threadDriver;

    protected WebDriverWait wait = new WebDriverWait(threadDriver.get(), Duration.ofSeconds(5));

    protected Actions actions = new Actions(threadDriver.get());

    protected WebElement find(String xpathExpression) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
    }
}
