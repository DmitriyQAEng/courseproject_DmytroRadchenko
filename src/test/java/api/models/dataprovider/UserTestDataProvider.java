package api.models.dataprovider;

import org.testng.annotations.DataProvider;

public class UserTestDataProvider {
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
