package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ui.pages.project.ProjectsPage;
import ui.pages.user.UsersPage;

import static ui.utils.ConfigProvider.*;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@ng-model='username']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@ng-model='password']")
    private WebElement passwordField;

    private WebElement getErrorMessage() {
        return find("//div[@data-test='error-message']");
    }

    public LoginPage() {
        threadDriver.get().get(URL + PAGE_ISSUES);
        PageFactory.initElements(threadDriver.get(), this);
    }

    private void performAdminLogin() {
        loginField.sendKeys(LOGIN);
        passwordField.sendKeys(PASSWORD);
        passwordField.submit();
    }

    public IssuesPage openIssues() {
        performAdminLogin();
        return new IssuesPage();
    }

    public ProjectsPage openProjects() {
        performAdminLogin();
        return new ProjectsPage();
    }

    public UsersPage openHub() {
        performAdminLogin();
        return new UsersPage();
    }

    public AgilesPage openAgiles() {
        performAdminLogin();
        return new AgilesPage();
    }

    public void performUserLoginAndCheck(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        passwordField.submit();
    }

    public IssuesPage positiveCheck() {
        return new IssuesPage();
    }

    public void negativeCheck() {
        WebElement errorMessage = getErrorMessage();
        Assert.assertTrue(errorMessage.isDisplayed());
    }



}
