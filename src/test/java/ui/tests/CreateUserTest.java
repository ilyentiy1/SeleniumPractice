package ui.tests;

import org.testng.annotations.Test;
import ui.core.BaseSeleniumTest;
import ui.utils.CsvDataProviders;

public class CreateUserTest extends BaseSeleniumTest {

    @Test(dataProvider = "issueData", dataProviderClass = CsvDataProviders.class)
    public void createUserTest() {

    }
}
