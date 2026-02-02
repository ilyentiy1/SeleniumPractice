package ui.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

    private WebElement issueRow(String issueName) {
        return find("//tr[contains(.,'" + issueName +"')]");
    };

    private WebElement dropDownMenuButton() {
        return find("//div[@data-test ='ring-dropdown']/button[@aria-label='Показать больше']");
    };

    private WebElement deleteButton() {
        return find("//button[contains(@class, 'delete')]");
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
        actions.click(issueRow(summary)).perform();
        Assert.assertEquals(summaryText().getText(), summary);
        Assert.assertEquals(descriptionText().getText(), description);
        return this;
    }

    public void deleteIssue() {
        dropDownMenuButton().click();
        deleteButton().click();
        actions.sendKeys(Keys.ENTER).perform();
    }


}