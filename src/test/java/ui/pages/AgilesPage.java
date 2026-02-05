package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static ui.utils.ConfigProvider.PAGE_AGILES;
import static ui.utils.ConfigProvider.URL;

public class AgilesPage extends BasePage {

    @FindBy(xpath = "//yt-agile-card")
    private WebElement agileCard;

    @FindBy(xpath = "//td[contains(@data-cell-id, '193-4')]")
    private WebElement anotherBoardArea;

    public AgilesPage() {
        threadDriver.get().get(URL + PAGE_AGILES);
        PageFactory.initElements(threadDriver.get(), this);
    }

    public AgilesPage moveIssueToAnotherBoard() {
        actions
                .clickAndHold(agileCard)
                .pause(Duration.ofMillis(500))
                .moveToElement(anotherBoardArea)
                .pause(Duration.ofMillis(500))
                .release()
                .build()
                .perform();
        return this;
    }

    public boolean isCardInCorrectBoard() {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//td[contains(@data-cell-id, '193-4')]//yt-agile-card")
            )).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
