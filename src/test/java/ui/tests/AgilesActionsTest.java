package ui.tests;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.core.BaseTest;
import ui.pages.LoginPage;
import ui.utils.TestListener;

@Listeners(TestListener.class)
public class AgilesActionsTest extends BaseTest {

    @Test(testName = "Тестирование действий в Agile досках")
    public void agilesActionsTest() {
        new LoginPage()
                .openAgiles()
                .checkDragDrop();
    }
}
