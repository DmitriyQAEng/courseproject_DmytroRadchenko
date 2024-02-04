package api.models.dataprovider;

import org.testng.annotations.DataProvider;

public class ProjectTestDataProvider {
    @DataProvider(name = "projectData")
    public static Object[][] projectData() {
        return new Object[][]{
                {"TestProjectDmitro"},
                {"TestProjectDmitro2"},
                {"TestProjectDmitro3"},
                {"TestProjectDmitro4"},
                /// массив даних
        };
    }
}
