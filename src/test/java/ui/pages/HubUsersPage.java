package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

public class HubUsersPage extends BaseSeleniumPage {

    @FindBy(xpath = "//button[@mode='primary']")
    private WebElement newUserButton;

    @FindBy(xpath = "//button[contains(@ng-click, 'true')]")
    private WebElement manualUserCreateButton;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='confirm']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@id='rg-checkbox-0']")
    private WebElement changePasswordCheckBox;

    public HubUsersPage() {
        driver.get("http://localhost:8080/admin/hub/users");
        PageFactory.initElements(driver, this);
    }

    public HubUsersPage createNewUser(String name, String email, String password)  {
        newUserButton.click();
        manualUserCreateButton.click();
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        changePasswordCheckBox.click();
        return this;
    }


}
