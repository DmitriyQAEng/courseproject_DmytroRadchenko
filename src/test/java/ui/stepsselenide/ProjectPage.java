package ui.stepsselenide;

import static ui.elements.ProjectComponents.*;
import static ui.elements.ProjectComponents.removeProjectField;
import static ui.elements.TaskComponents.confirmButton;
import static ui.stepsselenide.LoginPage.loginAsAdmin;

public class ProjectPage {
    public static void removeProject(String projectName){
        myProjects(projectName).click();
        dropdownProjectField().click();
        configureProject().click();
        removeProjectField().click();
        confirmButton().click();
    }
}
