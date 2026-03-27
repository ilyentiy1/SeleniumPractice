package ui.pages.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

import java.time.Duration;

import static ui.utils.ConfigProvider.*;

public class UsersPage extends BasePage {

    @FindBy(xpath = "//button[@data-test='create-button']")
    private WebElement newUserButton;

    private WebElement manualInputButton() {
        return find("//button[contains(@ng-click, 'true')]");
    }

    private WebElement loginField() {
        return find("//input[@name='name']");
    }

    private WebElement emailField() {
        return find("//input[@type='email']");
    }

    private WebElement passwordField() {
        return find("//input[@name='password']");
    }

    private WebElement confirmPasswordField() {
        return find("//input[@name='confirm']");
    }

    private WebElement changePasswordCheckBox() {
        return find("//label[contains(@for, 'checkbox')]");
    }

    public UsersPage() {
        super();
        driver.get(URL + PAGE_HUB);
    }

    public CurrentUserPage createNewUser(String login, String email, String password)  {
        newUserButton.click();
        manualInputButton().click();
        loginField().sendKeys(login);
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        confirmPasswordField().sendKeys(password);
        changePasswordCheckBox().click();
        defocusAndSubmit();
        return new CurrentUserPage();
    }

    //метод для дефокусировки последнего использованного элемента и последующее submit-действие(enter)
    private void defocusAndSubmit() {
        actions
                .moveByOffset(driver.manage().window().getSize().getWidth() / 2,
                        driver.manage().window().getSize().getHeight() / 2)
                .click()
                .pause(Duration.ofMillis(500))
                .sendKeys(Keys.ENTER)
                .perform();
    }


}
