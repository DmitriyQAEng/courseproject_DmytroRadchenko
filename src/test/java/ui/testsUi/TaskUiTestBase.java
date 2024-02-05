package ui.testsUi;

import api.models.CombinedTestDataProvider;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.elements.ProjectComponents;
import ui.methods.RetryAnalyzer;
import ui.stepsselenide.LoginPage;
import ui.stepsselenide.TaskPage;

public class TaskUiTestBase extends UITestBase {

    private static final Logger logger = LogManager.getLogger(TaskUiTestBase.class);

    @BeforeClass
    @Parameters({"browserName", "headless"})
    public void setUpClass(@Optional("firefox") String browserName, @Optional("false") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
        logger.info("Setting up browser: {}, Headless: {}", browserName, headless);
    }

    @Test(groups = "UiTasksTests", priority = 1, retryAnalyzer = RetryAnalyzer.class,
            dataProvider = "taskData", dataProviderClass = CombinedTestDataProvider.class)
    public void createTaskTest(String taskName) throws InterruptedException {
        logger.info("Starting createTaskTest with task name: {}", taskName);

        LoginPage.loginAsAdmin();
        ProjectComponents.myProjects("TestProjectDmitro").click();
        TaskPage.addNewTask(taskName);
        Selenide.sleep(300);
        Assert.assertTrue(TaskPage.isTaskDisplayed(taskName));

        logger.info("createTaskTest completed for task: {}", taskName);
    }

    @Test(groups = "UiTasksTests", priority = 1, retryAnalyzer = RetryAnalyzer.class,
            dataProvider = "taskData", dataProviderClass = CombinedTestDataProvider.class)
    public void editTaskTest(String taskName) throws InterruptedException {
        logger.info("Starting editTaskTest with task name: {}", taskName);

        LoginPage.loginAsAdmin();
        ProjectComponents.myProjects("TestProjectDmitro").click();
        TaskPage.editTaskParameters(taskName,
                "Close this task!",
                "Purple",
                "admin",
                1);

        logger.info("editTaskTest completed for task: {}", taskName);
    }


    @Test(groups = "UiTasksTests", priority = 2, retryAnalyzer = RetryAnalyzer.class,
            dataProvider = "taskData", dataProviderClass = CombinedTestDataProvider.class)
    public void closeTaskTest(String taskName) {
        logger.info("Starting closeTaskTest with task name: {}", taskName);

        LoginPage.loginAsAdmin();
        ProjectComponents.myProjects("TestProjectDmitro").click();
        TaskPage.closeCreatedTask(taskName);
        Selenide.sleep(300);
        Assert.assertFalse(TaskPage.isTaskDisplayed(taskName));

        logger.info("closeTaskTest completed for task: {}", taskName);
    }
}
