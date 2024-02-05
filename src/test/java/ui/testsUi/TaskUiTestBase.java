package ui.testsUi;
import api.models.CombinedTestDataProvider;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ui.methods.RetryAnalyzer;

import static ui.elements.ProjectComponents.*;
import static ui.stepsselenide.LoginPage.loginAsAdmin;
import static ui.stepsselenide.ProjectPage.removeProject;
import static ui.stepsselenide.TaskPage.createAndEditTasks;
public class TaskUiTestBase extends UITestBase {
    @BeforeClass
    @Parameters({"browserName", "headless"})
    public void setUpClass(@Optional("firefox") String browserName, @Optional("false") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
    }
    @Test(groups = "UiTasksTests", priority = 1, retryAnalyzer = RetryAnalyzer.class,
            dataProvider = "projectData", dataProviderClass = CombinedTestDataProvider.class)
    public void createTaskTest(String taskName) {
        // Task creation

    }

    @Test(groups = "UiTasksTests", priority = 2, retryAnalyzer = RetryAnalyzer.class,
            dataProvider = "projectData", dataProviderClass = CombinedTestDataProvider.class)
    public void closeTaskTest(String taskName){
            // Task closing

        }


        @Test(groups = "UiTasksTests", priority = 3, retryAnalyzer = RetryAnalyzer.class,
            dataProvider = "projectData", dataProviderClass = CombinedTestDataProvider.class)
    public void addTaskTest(String taskName){
            // Task adding
        }
}

