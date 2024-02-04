package ui.steps;

import static elements.ProjectComponents.*;
import static elements.ProjectComponents.removeProjectField;
import static elements.TaskComponents.confirmButton;
import static ui.steps.LoginPage.loginAsAdmin;

public class ProjectPage {
    public static void removeProject(){
        loginAsAdmin();
        myProjects().click();
        dropdownProjectField().click();
        configureProject().click();
        removeProjectField().click();
        confirmButton().click();
    }
}
