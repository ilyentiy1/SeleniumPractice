package ui.tests;

import org.testng.annotations.Test;
import ui.core.BaseSeleniumTest;
import ui.pages.LoginPage;
import ui.utils.CsvDataProviders;

public class CreateUserTest extends BaseSeleniumTest {

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
