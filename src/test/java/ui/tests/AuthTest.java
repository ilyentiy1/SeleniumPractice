package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pages.LoginPage;
import ui.utils.CsvDataProviders;
import ui.utils.TestListener;

@Listeners(TestListener.class)
public class AuthTest extends BaseTest {

    @Test(testName = "Проверка авторизации и валидации данных для авторизации",
            dataProvider = "authData", dataProviderClass = CsvDataProviders.class)
    public void authTest(String login, String password, String isPositive) {

        LoginPage loginPage = new LoginPage();
        loginPage.performUserLoginAndCheck(login, password);

        /*
        Позитивная проверка: проверка перехода на основную страницу
        Негативная проверка: проверка наличия красных сообщений о неверных данных
         */
        if (Boolean.parseBoolean(isPositive)) {
            Assert.assertTrue(loginPage
                    .positiveCheck()
                    .isUserRedirected()
            );
        } else {
            Assert.assertTrue(loginPage
                    .isErrorMessageDisplayed()
            );
        }
    }
}
