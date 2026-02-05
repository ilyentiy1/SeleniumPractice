package ui.pages.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.pages.BasePage;


//Страница ввода данных создаваемого проекта
public class NewProjectDataPage extends BasePage {

    @FindBy(xpath = "//input[@aria-label='Имя']")
    private WebElement projectNameField;

    public NewProjectDataPage() {
        PageFactory.initElements(threadDriver.get(), this);
    }

    public CurrentProjectPage inputProjectName(String name) {
        projectNameField.sendKeys(name);
        projectNameField.submit();
        return new CurrentProjectPage();
    }
}
