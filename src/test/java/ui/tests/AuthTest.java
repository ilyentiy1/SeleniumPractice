package ui.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.core.BaseTest;
import ui.pages.LoginPage;
import ui.utils.CsvDataProviders;
import ui.utils.TestListener;

@Listeners(TestListener.class)
public class AuthTest extends BaseTest {

    @Test(testName = "Проверка авторизации и валидации данных для авторизации",
            dataProvider = "authData", dataProviderClass = CsvDataProviders.class)
    public void authTest(String login, String password,
                         String isPositive) {
        new LoginPage()
                .performUserLoginAndCheck(login, password, isPositive);
    }
}
