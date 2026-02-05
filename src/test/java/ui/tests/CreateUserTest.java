package ui.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pages.LoginPage;
import ui.utils.CsvDataProviders;
import ui.utils.TestListener;


@Listeners(TestListener.class)
public class CreateUserTest extends BaseTest {

    @Test(testName = "Создание пользователя, проверка данных и удаление",
            dataProvider = "userData", dataProviderClass = CsvDataProviders.class)
    public void createUserTest(String login, String email, String password) {
        new LoginPage()
                .openHub()
                .createNewUser(login, email, password)
                .checkUserData(login, email)
                .deleteUser();
    }
}
