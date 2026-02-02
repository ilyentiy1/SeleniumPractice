package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ui.core.BasePage;

import static ui.utils.ConfigProvider.*;

public class LoginPage extends BasePage {
//    @FindBy(xpath = "//input[@ng-model='username']")
//    private WebElement loginField;
//
//    @FindBy(xpath = "//input[@ng-model='password']")
//    private WebElement passwordField;

    private WebElement loginField() {
        return find("//input[@ng-model='username']");
    }

    private WebElement passwordField() {
        return find("//input[@ng-model='password']");
    }

    private WebElement errorMessage() {
        return find("//div[@data-test='error-message']");
    }

    public LoginPage() {
        threadDriver.get().get(URL + PAGE_ISSUES);
        PageFactory.initElements(threadDriver.get(), this);
    }

    private void performAdminLogin() {
        loginField().sendKeys(LOGIN);
        passwordField().sendKeys(PASSWORD);
        passwordField().submit();
    }

    public IssuePage openIssues() {
        performAdminLogin();
        return new IssuePage();
    }

    public ProjectsPage openProjects() {
        performAdminLogin();
        return new ProjectsPage();
    }

    public HubPage openHub() {
        performAdminLogin();
        return new HubPage();
    }

    public AgilesPage openAgiles() {
        performAdminLogin();
        return new AgilesPage();
    }

    public void performUserLoginAndCheck(String login, String password, String isPositive) {
        loginField().sendKeys(login);
        passwordField().sendKeys(password);
        passwordField().submit();
        if(!Boolean.parseBoolean(isPositive)) {
            Assert.assertTrue(errorMessage().isDisplayed());
        } else {
            wait.until(ExpectedConditions.urlContains("/search"));
            String currentUrl = threadDriver.get().getCurrentUrl();
            assert currentUrl != null;
            Assert.assertTrue(currentUrl.contains("/search"), "Переход не произведен");
        }
    }

}
