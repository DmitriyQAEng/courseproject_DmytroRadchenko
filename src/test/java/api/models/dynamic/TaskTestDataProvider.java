package api.models.dynamic;

import org.testng.annotations.DataProvider;

public class TaskTestDataProvider {
    @DataProvider(name = "taskData")
    public Object[][] projectData() {
        return new Object[][]{
                {"TestTaskDmitro"},
                {"TestTaskDmitro2"},
                {"TestTaskDmitro3"},
                {"TestTaskDmitro4"},
                /// массив даних
        };
    }
}
