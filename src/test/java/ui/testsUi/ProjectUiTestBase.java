package ui.testsUi;

import api.models.CombinedTestDataProvider;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ui.methods.RetryAnalyzer;

public class ProjectUiTestBase extends UITestBase {

    private static final Logger logger = LogManager.getLogger(ProjectUiTestBase.class);

    @BeforeClass
    @Parameters({"browserName", "headless"})
    public void setUpClass(@Optional("firefox") String browserName, @Optional("false") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
        logger.info("Setting up browser: {}, Headless: {}", browserName, headless);
    }

    @Test(groups = "UiProjectsTests", priority = 1, retryAnalyzer = RetryAnalyzer.class,
            dataProvider = "projectData", dataProviderClass = CombinedTestDataProvider.class)
    public void createProjectTest(String projectName) {
        logger.info("Starting createProjectTest with project name: {}", projectName);

        // Add your test logic here
        // For example:
        // loginAsAdmin();
        // newProjectField().click();
        // formNameProjectField().setValue(projectName);
        // identifierProjectField().setValue("MYPROJECTS");
        // columnTaskProjectField().click();
        // formTaskLimitField().setValue("4");
        // saveField().click();
        // System.out.println("Project Name: " + projectName);

        // Simulating test logic completion
        logger.info("Project creation completed for project: {}", projectName);
    }
}
