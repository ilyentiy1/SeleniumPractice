package ui.tests;

import org.testng.annotations.Test;
import ui.core.BaseSeleniumTest;
import ui.pages.LoginPage;
import ui.utils.CsvDataProviders;


public class CreateIssueTest extends BaseSeleniumTest {

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
