package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ui.core.BasePage;

import java.time.Duration;

import static ui.utils.ConfigProvider.PAGE_AGILES;
import static ui.utils.ConfigProvider.URL;

public class AgilesPage extends BasePage {

    @FindBy(xpath = "//yt-agile-card")
    private WebElement agileCard;

    @FindBy(xpath = "//td[contains(@data-cell-id, '193-4')]")
    private WebElement anotherBoardArea;

    private WebElement issueStateContainer() {
        return find("//div[@aria-label='Состояние']");
    }

    private WebElement issuePriorityContainer() {
        return find("//div[@aria-label='Приоритет']");
    }

    private WebElement issueExecutorContainer() {
        return find("//div[@aria-label='Исполнитель']");
    }

    private WebElement datePickerContainer() {
        return find("//div[@aria-label='Срок']");
    }

    //"//div[@aria-label="Состояние"]//span[contains(text(), "В обработке")]"

    public AgilesPage() {
        threadDriver.get().get(URL + PAGE_AGILES);
        PageFactory.initElements(threadDriver.get(), this);
    }

    public AgilesPage checkDragDrop() {
        actions
                .clickAndHold(agileCard)
                .pause(Duration.ofMillis(500)) // Даем время на активацию режима переноса
                .moveToElement(anotherBoardArea)
                .pause(Duration.ofMillis(500)) // Замираем над целью, чтобы столбец "подсветился"
                .release()
                .build()
                .perform();

        Assert.assertTrue(isCardInCorrectColumn());
        return this;
    }

    public AgilesPage changeIssueProperties() {
        issueStateContainer().click();

        issuePriorityContainer().click();

        issueExecutorContainer().click();

        datePickerContainer().click();
        return this;
    }

    private boolean isCardInCorrectColumn() {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//td[contains(@data-cell-id, '193-4')]//yt-agile-card")
            )).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
