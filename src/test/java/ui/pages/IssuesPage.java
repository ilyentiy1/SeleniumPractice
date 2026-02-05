package ui.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class IssuesPage extends BasePage {

    @FindBy(xpath = "//a[@data-test='createIssueButton']")
    private WebElement newIssueButton;

    //Поля для ввода заголовка и описания
    private WebElement getSummaryInput() {
        return find("//textarea[@placeholder='Заголовок']");
    }
    private WebElement getDescriptionInput() {
        return find("//div[contains(@class, 'ProseMirror')]");
    }

    //Поля для считывания заголовка и описания в созданной задаче
    private WebElement getSummaryText() {
        return find("//h1[contains(@class, 'summary')]");
    }
    private WebElement getDescriptionText() {
        return find("//div[contains(@class, 'description')]");
    }

    private WebElement getDropDownMenuButton() {
        return find("//div[@data-test ='ring-dropdown']/button[@aria-label='Показать больше']");
    };

    private WebElement getDeleteButton() {
        return find("//button[contains(@class, 'delete')]");
    }


    public IssuesPage() {
        PageFactory.initElements(threadDriver.get(), this);
    }

    public IssuesPage createNewIssue(String summary, String description) {
        newIssueButton.click();
        WebElement summaryInput = getSummaryInput();
        WebElement descriptionInput = getDescriptionInput();
        summaryInput.sendKeys(summary);
        descriptionInput.sendKeys(description);
        summaryInput.sendKeys(Keys.ENTER);
        return this;
    }

    public String getSummary() {
        return getSummaryText().getText();
    }

    public String getDescription() {
        return getDescriptionText().getText();
    }

    public void deleteIssue() {
        WebElement dropDownMenuButton = getDropDownMenuButton();
        dropDownMenuButton.click();
        WebElement deleteButton = getDeleteButton();
        deleteButton.click();
        actions.sendKeys(Keys.ENTER).perform();
    }

    public boolean isUserRedirected() {
        wait.until(ExpectedConditions.urlContains("/search"));
        String currentUrl = threadDriver.get().getCurrentUrl();
        assert currentUrl != null;
        return currentUrl.contains("/search");
    }


}