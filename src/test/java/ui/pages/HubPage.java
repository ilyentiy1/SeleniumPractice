package ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ui.core.BaseSeleniumPage;

import java.time.Duration;

import static ui.utils.ConfigProvider.*;

public class HubPage extends BaseSeleniumPage {

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

    private WebElement loginText() {
        return find("//input[contains(@class, 'login')]");
    }

    private WebElement emailText() {
        return find("//input[contains(@class, 'email')]");
    }

    private WebElement deleteButton() {
        return find("//button[@data-test='delete-button']");
    }

    private WebElement userSelector() {
        return find("//button[@aria-label='Выберите пользователя']");
    }

    private WebElement userToChangeInput() {
        return find("//input[contains(@id, 'input')]");
    }

    private WebElement confirmDeleteButton() {
        return find("//button[@class='button_bac4 button_bac4 heightS_fdc0 primary_d690 buttonWithoutIcon_b3e8 footerItem_e058']");
    }

    public HubPage() {
        driver.get(URL + PAGE_HUB);
        PageFactory.initElements(driver, this);
    }

    public HubPage createNewUser(String login, String email, String password)  {
        newUserButton.click();
        manualInputButton().click();
        loginField().sendKeys(login);
        emailField().sendKeys(email);
        passwordField().sendKeys(password);
        confirmPasswordField().sendKeys(password);
        changePasswordCheckBox().click();
        defocusAndSubmit();
        return this;
    }

    public HubPage checkUserData(String login, String email) {
        Assert.assertEquals(loginText().getAttribute("value"), login);
        Assert.assertEquals(emailText().getAttribute("value"), email);
        return this;
    }


    public void deleteUser() {
        deleteButton().click();
        userSelector().click();
        userToChangeInput().click();
        userToChangeInput().sendKeys("ilyentiy_");
        userToChangeInput().sendKeys(Keys.ENTER);
        confirmDeleteButton().click();
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
