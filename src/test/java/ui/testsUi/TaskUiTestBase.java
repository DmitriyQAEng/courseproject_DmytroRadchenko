package ui.testsUi;

import api.models.CombinedTestDataProvider;
import com.codeborne.selenide.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ui.methods.RetryAnalyzer;

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
            dataProvider = "projectData", dataProviderClass = CombinedTestDataProvider.class)
    public void createTaskTest(String taskName) {
        logger.info("Starting createTaskTest with task name: {}", taskName);

        // Add your test logic here
        // For example:
        // loginAsAdmin();
        // createTask(taskName);
        // assertTaskCreatedSuccessfully();

        // Simulating test logic completion
        logger.info("createTaskTest completed for task: {}", taskName);
    }

    @Test(groups = "UiTasksTests", priority = 2, retryAnalyzer = RetryAnalyzer.class,
            dataProvider = "projectData", dataProviderClass = CombinedTestDataProvider.class)
    public void closeTaskTest(String taskName) {
        logger.info("Starting closeTaskTest with task name: {}", taskName);

        // Add your test logic here
        // For example:
        // loginAsAdmin();
        // closeTask(taskName);
        // assertTaskClosedSuccessfully();

        // Simulating test logic completion
        logger.info("closeTaskTest completed for task: {}", taskName);
    }

    @Test(groups = "UiTasksTests", priority = 3, retryAnalyzer = RetryAnalyzer.class,
            dataProvider = "projectData", dataProviderClass = CombinedTestDataProvider.class)
    public void addTaskTest(String newcommenttexttest) {
        logger.info("Starting addcommentTaskTest with comment text: {}", newcommenttexttest);

        // Add your test logic here
        // For example:
        // loginAsAdmin();
        // addTask(taskName);
        // assertTaskAddedSuccessfully();

        // Simulating test logic completion
        logger.info("addTaskTest completed for task: {}", newcommenttexttest);
    }
}
