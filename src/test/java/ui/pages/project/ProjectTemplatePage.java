package ui.pages.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

//Страница выбора шаблона проекта
public class ProjectTemplatePage extends BasePage {

    @FindBy(xpath = "//button[@type='button'][.//img[contains(@src, 'ldm')]]")
    private WebElement taskManagerTemplateButton;

    private WebElement getAcceptTemplateButton() {
        return find("//button[@data-test='accept-button']");
    }

    public ProjectTemplatePage() {
        super();
    }

    public NewProjectDataPage chooseTemplate() {
        taskManagerTemplateButton.click();

        WebElement acceptTemplateButton = getAcceptTemplateButton();
        acceptTemplateButton.click();
        return new NewProjectDataPage();
    }

}
