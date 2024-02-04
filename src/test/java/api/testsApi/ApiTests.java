package api.testsApi;

import api.models.args.result.Result;
import api.models.args.projects.ProjectDescription;
import api.models.args.tasks.TaskDescription;
import api.models.args.users.UserDescription;
import static api.enums.UserRole.MANAGER;
import static api.apimethods.ProjectMethods.CREATE_PROJECT;
import static api.apimethods.ProjectMethods.REMOVE_PROJECT;
import static api.apimethods.TaskMethods.CREATE_TASK;
import static api.apimethods.TaskMethods.REMOVE_TASK;
import static api.apimethods.UserMethods.CREATE_USER;
import static api.apimethods.UserMethods.DELETE_USER;
import static api.steps.BaseApiSteps.performAuthorizedRequest;
import java.util.logging.Logger;
import api.models.dataprovider.*;
import utils.EnvProperties;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ApiTests {
    private static final Logger logger = Logger.getLogger(ApiTests.class.getName());
    private int userResult;
    private int projectResult;
    private int taskResult;

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = EnvProperties.getBaseUrl();
    }

    @Test(groups = "ApiProjectsTests", priority = 1, dataProvider = "userData", dataProviderClass = UserTestDataProvider.class)
    public void createUserAsAdminTest(String userName) {
        UserDescription.CreateUserRequest createUser = UserDescription.CreateUserRequest.builder()
                .jsonrpc("2.0")
                .method(CREATE_USER)
                .id(EnvProperties.getUserId())
                .params(UserDescription.CreateUserRequest.ParamsCreate.builder()
                        .username(EnvProperties.getUserApi()).password(EnvProperties.getPasswordApi())
                        .name(userName).role(MANAGER.getRole()).email("djdmonqa@gmail.com").build())
                .build();
        Result result = performAuthorizedRequest(createUser);
        userResult = result.User_id();
        logger.info("Creating new User: " + userName);
        logger.info("User created with Result: " + userResult);
    }

    @Test(groups = "ApiProjectsTests", priority = 2, dataProvider = "projectData", dataProviderClass = ProjectTestDataProvider.class)
    public void createProjectTest(String projectName) {
        ProjectDescription.CreateProjectRequest createProject = ProjectDescription.CreateProjectRequest.builder()
                .jsonrpc("2.0")
                .method(CREATE_PROJECT)
                .id(EnvProperties.getUserId())
                .params(ProjectDescription.CreateProjectRequest.ParamsCreate.builder().name(projectName).description("Coursework")
                        .start_date("2024-01-01").end_date("2024-02-05").build())
                .build();
        Result result = performAuthorizedRequest(createProject);
        projectResult = result.Project_id();
        logger.info("Creating new Project: " + projectName);
        logger.info("Project created with Result: " + projectResult);
    }

    @Test(groups = "ApiProjectsTests", priority = 3, dataProvider = "taskData", dataProviderClass = TaskTestDataProvider.class)
    public void createTaskTest(String taskName) {
        TaskDescription.CreateTaskRequest createTask = TaskDescription.CreateTaskRequest.builder()
                .jsonrpc("2.0")
                .method(CREATE_TASK)
                .id(EnvProperties.getTaskId())
                .params(TaskDescription.CreateTaskRequest.ParamsCreate.builder().project_id(projectResult).title(taskName)
                        .description("Testing API").color_id("green").date_started("2024-01-18").build())
                .build();
        Result result = performAuthorizedRequest(createTask);
        taskResult = result.Task_id();
        logger.info("Creating new Task: " + taskName);
        logger.info("Task created with Result: " + taskResult);
    }

    @Test(groups = "ApiProjectsTests", priority = 4)
    public void removeTaskTest() {
        TaskDescription.RemoveTaskRequest removeTask = TaskDescription.RemoveTaskRequest.builder()
                .jsonrpc("2.0")
                .method(REMOVE_TASK)
                .id(EnvProperties.getTaskId())
                .params(TaskDescription.RemoveTaskRequest.ParamsRemote.builder().task_id(taskResult).build())
                .build();
        Result result = performAuthorizedRequest(removeTask);
        int resultWithId = result.Task_id();
        boolean taskRemovedResult = (boolean) result.getResult();
        logger.info("Task removed with Result: " + resultWithId);
        logger.info("Task removed result: " + taskRemovedResult);
    }

    @Test(groups = "ApiProjectsTests", priority = 5)
    public void removeProjectTest() {
        ProjectDescription.RemoveProjectRequest removeProject = ProjectDescription.RemoveProjectRequest.builder()
                .jsonrpc("2.0")
                .method(REMOVE_PROJECT)
                .id(EnvProperties.getProjectId())
                .params(ProjectDescription.RemoveProjectRequest.ParamsRemote.builder().project_id(projectResult).build())
                .build();
        Result result = performAuthorizedRequest(removeProject);
        int resultWithId = result.Project_id();
        boolean projectRemovedResult = (boolean) result.getResult();
        logger.info("Project removed with Result: " + resultWithId);
        logger.info("Project removed result: " + projectRemovedResult);
    }

    @Test(groups = "ApiProjectsTests", priority = 6)
    public void removeUserAsAdminTest() {
        UserDescription.RemoveUserRequest removeUser = UserDescription.RemoveUserRequest.builder()
                .jsonrpc("2.0")
                .method(DELETE_USER)
                .id(EnvProperties.getUserId())
                .params(UserDescription.RemoveUserRequest.ParamsRemote.builder().user_id(userResult).build())
                .build();
        Result result = performAuthorizedRequest(removeUser);
        int resultWithId = result.User_id();
        boolean userRemovedResult = (boolean) result.getResult();
        logger.info("User removed with Result: " + resultWithId);
        logger.info("User removed result: " + userRemovedResult);
    }
}
