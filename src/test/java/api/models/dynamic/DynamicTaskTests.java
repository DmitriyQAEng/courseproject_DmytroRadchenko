package api.models.dynamic;

import org.testng.annotations.DataProvider;

public class DynamicTaskTests {
    @DataProvider(name = "taskData")
    public Object[][] projectData() {
        return new Object[][]{
                {"TestTaskDmitro"},

        };
    }
}
