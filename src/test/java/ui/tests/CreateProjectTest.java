package ui.tests;

import org.testng.annotations.Test;
import ui.core.BaseSeleniumTest;
import ui.pages.LoginPage;
import ui.utils.CsvDataProviders;

public class CreateProjectTest extends BaseSeleniumTest {

    @Test(testName = "Создание проекта, проверка данных и удаление",
            dataProvider = "projectData", dataProviderClass = CsvDataProviders.class)
    public void createProjectTest(String projectName) {
        new LoginPage()
                .openProjects()
                .createProject(projectName)
                .checkData(projectName)
                .deleteProject(projectName);
    }
}
