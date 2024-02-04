package ui.testsUi;

import com.codeborne.selenide.Configuration;
import config.ConfigProperties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ui.methods.RetryAnalyzer;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static elements.UserCredentialsComponents.*;
import static ui.steps.LoginPage.loginAsAdmin;

public class LoginsUiTestBase extends UITestBase {

    @BeforeClass
    @Parameters({"browserName", "headless"})
    public void setUpClass(@Optional("firefox") String browserName, @Optional("false") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
    }

    @Test(groups = "UiLoginsTest", retryAnalyzer = RetryAnalyzer.class)
    @Parameters({"browserName", "headless"})
    public void positiveLoginTest(@Optional("firefox") String browserName, @Optional("false") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
        loginAsAdmin();
        dropdownUserField().click();
        activationUsernameField().shouldBe(visible);
        logOutButton().click();
    }

    @Test(groups = "UiLoginsTest", retryAnalyzer = RetryAnalyzer.class)
    @Parameters({"browserName", "headless"})
    public void negativeLoginTestInvalidUsername(@Optional("chrome") String browserName, @Optional("true") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
        homePage();
        userField().setValue(ConfigProperties.getInvalidUserPassword());
        passwordField().setValue(ConfigProperties.getPassword());
        rememberMyField().click();
        signInButton().click();
        badUsernamePasswordField().shouldHave(text("Bad username or password"));
    }

    @Test(groups = "UiLoginsTest", retryAnalyzer = RetryAnalyzer.class)
    @Parameters({"browserName", "headless"})
    public void negativeLoginTestInvalidPassword(@Optional("chrome") String browserName, @Optional("false") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
        homePage();
        userField().setValue(ConfigProperties.getUser());
        passwordField().setValue(ConfigProperties.getInvalidUserPassword());
        rememberMyField().click();
        signInButton().click();
        badUsernamePasswordField().shouldHave(text("Bad username or password"));
    }
}

