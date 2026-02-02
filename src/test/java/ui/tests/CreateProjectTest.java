package ui.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.core.BaseTest;
import ui.pages.LoginPage;
import ui.utils.CsvDataProviders;
import ui.utils.TestListener;

@Listeners(TestListener.class)
public class CreateProjectTest extends BaseTest {

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
