package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ui.core.BasePage;

import static ui.utils.ConfigProvider.*;

public class ProjectsPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, 'create')]")
    private WebElement createProjectButton;

    private WebElement taskManagerTemplateButton() {
        return find("//button[@type='button'][.//img[contains(@src, 'ldm')]]");
    }

    private WebElement acceptTemplateButton() {
        return find("//button[@data-test='accept-button']");
    }

    private WebElement projectNameField() {
        return find("//input[@aria-label='Имя']");
    }

    private WebElement closeDialogButton() {
        return find("//button[@aria-label='close dialog']");
    }

    private WebElement projectHeader() {
        return find("//h1[@data-test='project-heading']");
    }

    private WebElement dropDownMenuButton() {
        return find("//div[contains(@data-test, 'three-dots')]/button");
    }

    private WebElement deleteButton() {
        return find("//button[contains(@class, 'danger')]");
    }

    private WebElement projectToDeleteInput() {
        return find("//input[contains(@id, 'input')]");
    }

    private WebElement confirmDeletionButton() {
        return find("//div[contains(@class, 'ring-ui-panel')]/button[contains(@class,'primary')]");
    }

    public ProjectsPage() {
        threadDriver.get().get(URL + PAGE_PROJECT);
        PageFactory.initElements(threadDriver.get(), this);
    }

    public ProjectsPage createProject(String projectName) {
        createProjectButton.click();
        taskManagerTemplateButton().click();
        acceptTemplateButton().click();
        projectNameField().sendKeys(projectName);
        projectNameField().submit();
        closeDialogButton().click();
        return this;
    }

    public ProjectsPage checkData(String projectName) {
        Assert.assertEquals(projectHeader().getText(), projectName);
        return this;
    }

    public void deleteProject(String projectName) {
        actions
                .moveToElement(dropDownMenuButton())
                        .click()
                                .perform();
        deleteButton().click();
        projectToDeleteInput().sendKeys(projectName);
        confirmDeletionButton().click();
    }
}
