package api.models.dataprovider;

import org.testng.annotations.DataProvider;

public class CombinedTestDataProvider {
    @DataProvider(name = "projectData")
    public Object[][] projectData() {
        return new Object[][]{
                {"TestProjectDmitro"},
                {"TestProjectDmitro2"},
                {"TestProjectDmitro3"},
                {"TestProjectDmitro4"},
                /// массив даних
        };
    }

    @DataProvider(name = "taskData")
    public Object[][] taskData() {
        return new Object[][]{
                {"TestTaskDmitro"},
                {"TestTaskDmitro2"},
                {"TestTaskDmitro3"},
                {"TestTaskDmitro4"},
                /// массив даних
        };
    }

    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][]{
                {"TestTestuserDmitro"},
                {"TestTestuserDmitro2"},
                {"TestTestuserDmitro3"},
                {"TestTestuserDmitro4"},
                /// массив даних
        };
    }
}
