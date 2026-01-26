package ui.tests;


import org.testng.annotations.Test;
import ui.pages.LoginPage;


public class AgilesActionsTest {

    @Test(testName = "Тестирование действий в Agile досках")
    public void agilesActionsTest() {
        new LoginPage()
                .openIssues();
    }
}
