package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.core.BaseSeleniumPage;

import static ui.utils.ConfigProvider.*;

public class LoginPage extends BaseSeleniumPage {
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;

    public LoginPage() {
        driver.get(URL + PAGE_ISSUES);
        PageFactory.initElements(driver, this);
    }

    private void performLogin() {
        loginField.sendKeys(LOGIN);
        passwordField.sendKeys(PASSWORD);
        passwordField.submit();
    }

    public IssuePage openIssues() {
        performLogin();
        return new IssuePage();
    }

    public ProjectsPage openProjects() {
        performLogin();
        return new ProjectsPage();
    }

    public HubPage openHub() {
        performLogin();
        return new HubPage();
    }


}
