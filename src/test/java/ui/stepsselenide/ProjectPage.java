package ui.stepsselenide;

import utils.Random;

import static ui.elements.ProjectComponents.*;
import static ui.elements.ProjectComponents.removeProjectField;
import static ui.elements.TaskComponents.confirmButton;
import static ui.stepsselenide.LoginPage.loginAsAdmin;

public class ProjectPage {
    public static void createProject(String projectName){
        loginAsAdmin();
        newProjectField().click();
        formNameProjectField().setValue(projectName);
        identifierProjectField().setValue("MYPROJECTS" + Random.genString(5));
        columnTaskProjectField().click();
        formTaskLimitField().setValue("4");
        saveField().click();
    }
    public static void removeProject(String projectName){
        myProjects(projectName).click();
        dropdownProjectField().click();
        configureProject().click();
        removeProjectField().click();
        confirmButton().click();
    }
}
