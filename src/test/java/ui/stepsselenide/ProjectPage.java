package ui.stepsselenide;

import static ui.elements.elements.ProjectComponents.*;
import static ui.elements.elements.ProjectComponents.removeProjectField;
import static ui.elements.elements.TaskComponents.confirmButton;
import static ui.stepsselenide.LoginPage.loginAsAdmin;

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
