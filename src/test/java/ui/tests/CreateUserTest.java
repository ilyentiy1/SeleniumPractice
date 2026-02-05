package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pages.LoginPage;
import ui.pages.user.CurrentUserPage;
import ui.pages.user.UsersPage;
import ui.utils.CsvDataProviders;
import ui.utils.TestListener;


@Listeners(TestListener.class)
public class CreateUserTest extends BaseTest {

    @Test(testName = "Создание пользователя, проверка данных и удаление",
            dataProvider = "userData", dataProviderClass = CsvDataProviders.class)
    public void createUserTest(String login, String email, String password) {
        CurrentUserPage userPage = new LoginPage()
                .openHub()
                .createNewUser(login, email, password);

        Assert.assertEquals(userPage.getLogin(), login);
        Assert.assertEquals(userPage.getEmail(), email);

        userPage.deleteUser();
    }
}
