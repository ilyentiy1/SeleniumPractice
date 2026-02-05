package ui.tests;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.pages.AgilesPage;
import ui.pages.LoginPage;
import ui.utils.TestListener;

@Listeners(TestListener.class)
public class AgilesActionsTest extends BaseTest {

    @Test(testName = "Тестирование действий в Agile досках")
    public void agilesActionsTest() {
        AgilesPage agilesPage = new LoginPage()
                .openAgiles()
                .moveIssueToAnotherBoard();

        //Проверка переноса задачи в другую доску
        Assert.assertTrue(agilesPage.isCardInCorrectBoard());
    }
}
