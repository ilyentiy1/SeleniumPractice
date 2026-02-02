package ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ui.core.BasePage;



public class IssuePage extends BasePage {
    //Поля для ввода заголовка и описания
    private WebElement summaryInput() {
        return find("//textarea[@placeholder='Заголовок']");
    }
    private WebElement descriptionInput() {
        return find("//div[contains(@class, 'ProseMirror')]");
    }

    //Поля для считывания заголовка и описания в созданной задаче
    private WebElement summaryText() {
        return find("//h1[contains(@class, 'summary')]");
    }
    private WebElement descriptionText() {
        return find("//div[contains(@class, 'description')]");
    }

    private WebElement newIssueButton() {
        return find("//a[@data-test='createIssueButton']");
    };

    private WebElement issueRow() {
        return find("(//table//tbody/tr)[1]");
    };

    private WebElement issueCheckBox() {
        return find("//tr[1]/td[contains(@class, 'checkbox')]");
    };

    private WebElement deleteButton() {
        return find("//button[@data-test='delete-item-button']");
    }


    public IssuePage() {
        PageFactory.initElements(threadDriver.get(), this);
    }

    public IssuePage createNewIssue(String summary, String description) {
        newIssueButton().click();
        summaryInput().sendKeys(summary);
        descriptionInput().sendKeys(description);
        summaryInput().sendKeys(Keys.ENTER);
        return this;
    }

    public IssuePage checkIssueData(String summary, String description) {
        actions.doubleClick(issueRow()).perform();
        Assert.assertEquals(summaryText().getText(), summary);
        Assert.assertEquals(descriptionText().getText(), description);
        threadDriver.get().navigate().back();
        return this;
    }

    public void deleteIssue() {
        issueCheckBox().click();
        deleteButton().click();
        actions.sendKeys(Keys.ENTER).perform();

    }


}