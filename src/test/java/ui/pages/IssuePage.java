package ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ui.core.BaseSeleniumPage;



public class IssuePage extends BaseSeleniumPage {
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

    @FindBy(xpath = "//a[@data-test='createIssueButton']")
    private WebElement newIssueButton;

    @FindBy(xpath = "(//table//tbody/tr)[1]")
    private WebElement issueRow;

    @FindBy(xpath = "//table//tbody/tr[1]//input[@type='checkbox']")
    private WebElement issueCheckBox;

    private WebElement deleteButton() {
        return find("//button[@data-test='delete-item-button']");
    }


    public IssuePage() {
        PageFactory.initElements(driver, this);
    }

    public IssuePage createNewIssue(String summary, String description) {
        newIssueButton.click();
        summaryInput().sendKeys(summary);
        descriptionInput().sendKeys(description);
        actions.sendKeys(Keys.ENTER).perform();
        return this;
    }

    public IssuePage checkIssueData(String summary, String description) {
        actions.doubleClick(issueRow).perform();
        Assert.assertEquals(summaryText().getText(), summary);
        Assert.assertEquals(descriptionText().getText(), description);
        driver.navigate().back();
        return this;
    }

    public void deleteIssue() {
        issueCheckBox.click();
        deleteButton().click();
        actions.sendKeys(Keys.ENTER).perform();

    }


}