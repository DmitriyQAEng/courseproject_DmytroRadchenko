package ui.testsUi;

import api.models.dataprovider.ProjectTestDataProvider;

import org.testng.annotations.Test;
import ui.methods.RetryAnalyzer;

import static ui.elements.elements.ProjectComponents.*;
import static ui.stepsselenide.LoginPage.loginAsAdmin;
import static ui.stepsselenide.ProjectPage.removeProject;
import static ui.stepsselenide.TaskPage.createAndEditTasks;

public class ProjectsUiTestBase extends UITestBase {

    @Test(groups = "UiProjectsTests", priority = 1, retryAnalyzer = RetryAnalyzer.class,
            dataProvider = "projectData", dataProviderClass = ProjectTestDataProvider.class)
    public void createProjectTest(String projectName) {
        // Project creation
        loginAsAdmin();
        newProjectField().click();
        formNameProjectField().setValue(projectName);
        identifierProjectField().setValue("MYPROJECTS");
        columnTaskProjectField().click();
        formTaskLimitField().setValue("4");
        saveField().click();
        System.out.println("Project Name: " + projectName);
    }

    @Test(groups = "UiProjectsTests", priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void createTaskTest() {
        // Create/edit/remove the Task
        createAndEditTasks();
    }

    @Test(groups = "UiProjectsTests", priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void removeProjectsTest() {
        // Project remove
        removeProject();
    }
}
