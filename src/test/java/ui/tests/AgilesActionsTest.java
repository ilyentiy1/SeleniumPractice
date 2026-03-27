package ui.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.AgilesPage;
import ui.pages.LoginPage;

public class AgilesActionsTest extends BaseTest {

    @Test(testName = "Тестирование действий в Agile досках",
            groups = "main"
    )
    public void agilesActionsTest() {
        AgilesPage agilesPage = new LoginPage()
                .openAgiles()
                .moveIssueToAnotherBoard();

        //Проверка переноса задачи в другую доску
        Assert.assertTrue(agilesPage.isCardInCorrectBoard());
    }
}
