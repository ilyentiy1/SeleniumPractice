package ui.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.core.BaseTest;
import ui.pages.LoginPage;
import ui.utils.CsvDataProviders;
import ui.utils.TestListener;


@Listeners(TestListener.class)
public class CreateIssueTest extends BaseTest {

    @Test(testName = "Создание задачи, проверка данных и удаление",
            dataProvider = "issueData", dataProviderClass = CsvDataProviders.class)
    public void createIssueTest(String summary, String description) {
        new LoginPage()
                .openIssues()
                .createNewIssue(summary, description)
                .checkIssueData(summary, description)
                .deleteIssue();

    }


}
