package ui.tests;

import org.testng.annotations.Test;
import ui.core.BaseSeleniumTest;
import ui.pages.AgilesPage;
import ui.utils.CsvDataProviders;


public class CreateIssueTest extends BaseSeleniumTest {

    @Test(dataProvider = "issueData", dataProviderClass = CsvDataProviders.class)
    public void createIssueTest(String summary, String description) {
        AgilesPage agilesPage = new AgilesPage().createNewIssue(summary, description);

    }


}
