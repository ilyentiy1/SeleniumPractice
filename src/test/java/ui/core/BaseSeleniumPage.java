package ui.core;

import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BaseSeleniumPage {
    @Setter
    protected static WebDriver driver;

    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    protected Actions actions = new Actions(driver);

    protected WebElement find(String xpath) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
}
