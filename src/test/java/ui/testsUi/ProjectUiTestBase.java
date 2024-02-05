package ui.testsUi;

import api.models.CombinedTestDataProvider;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ui.methods.RetryAnalyzer;

public class ProjectUiTestBase extends UITestBase {
    @BeforeClass
    @Parameters({"browserName", "headless"})
    public void setUpClass(@Optional("firefox") String browserName, @Optional("false") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
    }
    @Test(groups = "UiProjectsTests", priority = 1, retryAnalyzer = RetryAnalyzer.class,
            dataProvider = "projectData", dataProviderClass = CombinedTestDataProvider.class)
    public void createProjectTest(String projectName) {
//        // Project creation
//        loginAsAdmin();
//        newProjectField().click();
//        formNameProjectField().setValue(projectName);
//        identifierProjectField().setValue("MYPROJECTS");
//        columnTaskProjectField().click();
//        formTaskLimitField().setValue("4");
//        saveField().click();
//        System.out.println("Project Name: " + projectName);

    }
    }

