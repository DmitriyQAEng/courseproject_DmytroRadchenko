package api.models.dynamic;

import org.testng.annotations.DataProvider;

public class DynamicProjectTests {
    @DataProvider(name = "projectData")
    public static Object[][] projectData() {
        return new Object[][]{
                {"TestProjectDmitro"},

        };
    }
}
