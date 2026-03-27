package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.IssuesPage;
import ui.pages.LoginPage;
import ui.utils.CsvDataProviders;


public class CreateIssueTest extends BaseTest {

    @Test(testName = "Создание задачи, проверка данных и удаление",
            dataProvider = "issueData", dataProviderClass = CsvDataProviders.class,
            groups = "main"
    )
    public void createIssueTest(String summary, String description) {
        IssuesPage issuesPage = new LoginPage()
                .openIssues()
                .createNewIssue(summary, description);

        Assert.assertEquals(issuesPage.getSummary(), summary);
        Assert.assertEquals(issuesPage.getDescription(), description);

        issuesPage.deleteIssue();

    }


}
