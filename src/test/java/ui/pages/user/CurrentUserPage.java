package ui.pages.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ui.pages.BasePage;

public class CurrentUserPage extends BasePage {

    @FindBy(xpath = "//input[contains(@class, 'login')]")
    private WebElement loginText;

    @FindBy(xpath = "//input[contains(@class, 'email')]")
    private WebElement emailText;

    @FindBy(xpath = "//button[@data-test='delete-button']")
    private WebElement deleteButton;

    private WebElement userSelector() {
        return find("//button[@aria-label='Выберите пользователя']");
    }

    private WebElement userToChangeInput() {
        return find("//input[contains(@id, 'input')]");
    }

    private WebElement confirmDeleteButton() {
        return find("//div[contains(@class, 'a5e1')]/button[contains(@class, 'primary')]");
    }

    public CurrentUserPage() {
        PageFactory.initElements(threadDriver.get(), this);
    }

    public CurrentUserPage checkUserData(String login, String email) {
        Assert.assertEquals(loginText.getAttribute("value"), login);
        Assert.assertEquals(emailText.getAttribute("value"), email);
        return this;
    }


    public void deleteUser() {
        deleteButton.click();
        userSelector().click();
        userToChangeInput().click();
        userToChangeInput().sendKeys("ilyentiy_");
        userToChangeInput().sendKeys(Keys.ENTER);
        confirmDeleteButton().click();
    }
}
