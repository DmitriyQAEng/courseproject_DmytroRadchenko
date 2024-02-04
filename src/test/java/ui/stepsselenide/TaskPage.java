package ui.stepsselenide;

import static elements.ProjectComponents.*;
import static elements.ProjectComponents.saveField;
import static elements.TaskComponents.*;
import static elements.TaskComponents.confirmButton;
import static ui.stepsselenide.LoginPage.loginAsAdmin;

public class TaskPage {
    public static void createAndEditTasks(){
        loginAsAdmin();
        myProjects().click();
        dropdownProjectField().click();
        addNewTaskField().click();
        nameTaskField().setValue("DmytroRadchenko1");
        saveField().click();
        // Edit
        dropdownTaskField().click();
        editTask().click();
        newCommentTask().setValue("Close this Task");
        dropdownColorTask().click();
        colorTaskPurple().click();
        dropdownAssigneeTask().click();
        assigneeAdminTask().click();
        dropdownPriorityTask().click();
        priorityLowTask().click();
        saveField().click();
        // Close
        dropdownTaskField().click();
        closeTask().click();
        confirmButton().click();
    }
}
