package ui.stepsselenide;

import static ui.elements.ProjectComponents.*;
import static ui.elements.TaskComponents.*;
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

    public static void addNewTask(String taskName){
        dropdownProjectField().click();
        addNewTaskField().click();
        nameTaskField().setValue(taskName);
        saveField().click();
    }

    public static boolean isTaskDisplayed(String taskName){
        return taskNameTableElement(taskName).isDisplayed();
    }

    public static void editTaskParameters(String taskName, String comment, String color, String role, int priority){
        dropdownTaskField(taskName).click();
        editTask().click();
        newCommentTask().setValue(comment);
        dropdownColorTask().click();
        colorTask(color).click();
        dropdownAssigneeTask().click();
        assigneeTask(role).click();
        dropdownPriorityTask().click();
        priorityTask(Integer.toString(priority)).click();
        saveField().click();
    }

    public static void closeCreatedTask(String taskName){
        dropdownTaskField(taskName).click();
        closeTask().click();
        confirmButton().click();
    }
}
