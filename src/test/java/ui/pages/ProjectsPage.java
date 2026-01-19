package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

public class ProjectsPage extends BaseSeleniumPage {

    @FindBy(xpath = "//a[contains(@href, 'create')]")
    private WebElement createProjectButton;

    @FindBy(xpath = "//button[@type='button'][.//img[contains(@src, 'ldm')]]")
    private WebElement taskManagerTemplateButton;

    @FindBy(xpath = "//button[@data-test='accept-button']")
    private WebElement acceptTemplateButton;

    @FindBy(xpath = "//input[@aria-label='Имя']")
    private WebElement projectNameField;

//    @FindBy(xpath = "//button[@type='submit']")
//    private WebElement submitButton;


    public ProjectsPage() {
        driver.get("http://localhost:8080/projects");
        PageFactory.initElements(driver, this);
    }

    public ProjectsPage createProject(String projectName) {
        createProjectButton.click();
        taskManagerTemplateButton.click();
        acceptTemplateButton.click();
        projectNameField.sendKeys(projectName);
        projectNameField.submit();

        return this;
    }
}
