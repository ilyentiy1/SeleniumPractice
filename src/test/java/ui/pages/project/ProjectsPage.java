package ui.pages.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.pages.BasePage;

import static ui.utils.ConfigProvider.*;

//Страница со списком проектов
public class ProjectsPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, 'create')]")
    private WebElement createProjectButton;

    public ProjectsPage() {
        threadDriver.get().get(URL + PAGE_PROJECT);
        PageFactory.initElements(threadDriver.get(), this);
    }

    public ProjectTemplatePage createProject() {
        createProjectButton.click();
        return new ProjectTemplatePage();
    }
}
