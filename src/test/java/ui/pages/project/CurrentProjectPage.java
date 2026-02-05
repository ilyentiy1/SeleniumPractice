package ui.pages.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.pages.BasePage;


//Страница с данными о конкретном проекта
public class CurrentProjectPage extends BasePage {

    @FindBy(xpath = "//button[@aria-label='close dialog']")
    private WebElement closeDialogButton;

    @FindBy(xpath = "//h1[@data-test='project-heading']")
    private WebElement projectHeader;

    @FindBy(xpath = "//div[contains(@data-test, 'three-dots')]/button")
    private WebElement dropDownMenuButton;

    private WebElement getDeleteButton() {
        return find("//button[contains(@class, 'danger')]");
    }

    private WebElement getProjectToDeleteInput() {
        return find("//input[contains(@id, 'input')]");
    }

    private WebElement getConfirmDeletionButton() {
        return find("//div[contains(@class, 'ring-ui-panel')]/button[contains(@class,'primary')]");
    }

    public CurrentProjectPage() {
        PageFactory.initElements(threadDriver.get(), this);
    }

    public CurrentProjectPage closeDialog() {
        closeDialogButton.click();
        return this;
    }

    public String getProjectName() {
        return projectHeader.getText();
    }

    public void deleteProject(String projectName) {
        actions
                .moveToElement(dropDownMenuButton)
                        .click()
                                .perform();

        WebElement deleteButton = getDeleteButton();
        deleteButton.click();

        WebElement projectToDeleteInput = getProjectToDeleteInput();
        projectToDeleteInput.sendKeys(projectName);

        WebElement confirmDeletionButton = getConfirmDeletionButton();
        confirmDeletionButton.click();
    }
}
