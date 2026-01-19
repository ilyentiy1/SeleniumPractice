package ui.tests;

import org.testng.annotations.Test;
import ui.core.BaseSeleniumTest;
import ui.utils.CsvDataProviders;

public class UpdateUserTest extends BaseSeleniumTest {

    @Test(dataProvider = "issueData", dataProviderClass = CsvDataProviders.class)
    public void updateUserTest() {

    }
}
