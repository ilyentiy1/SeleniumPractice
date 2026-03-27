package ui.pages.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;


//Страница ввода данных создаваемого проекта
public class NewProjectDataPage extends BasePage {

    @FindBy(xpath = "//input[@aria-label='Имя']")
    private WebElement projectNameField;

    public NewProjectDataPage() {
        super();
    }

    public CurrentProjectPage inputProjectName(String name) {
        projectNameField.sendKeys(name);
        projectNameField.submit();
        return new CurrentProjectPage();
    }
}
