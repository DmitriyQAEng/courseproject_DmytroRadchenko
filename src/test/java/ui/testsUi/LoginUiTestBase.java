package ui.testsUi;

import com.codeborne.selenide.Configuration;
import utils.EnvProperties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ui.methods.RetryAnalyzer;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static ui.elements.UserCredentialsComponents.*;
import static ui.stepsselenide.LoginPage.loginAsAdmin;

public class LoginUiTestBase extends UITestBase {

    private static final Logger logger = LogManager.getLogger(LoginUiTestBase.class);

    @BeforeClass
    @Parameters({"browserName", "headless"})
    public void setUpClass(@Optional("firefox") String browserName, @Optional("false") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
        logger.info("Setting up browser: {}, Headless: {}", browserName, headless);
    }

    @Test(groups = "UiLoginsTest", retryAnalyzer = RetryAnalyzer.class)
    @Parameters({"browserName", "headless"})
    public void positiveLoginTest(@Optional("firefox") String browserName, @Optional("false") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
        logger.info("Executing positiveLoginTest with browser: {}, Headless: {}", browserName, headless);
        loginAsAdmin();
        dropdownUserField().click();
        activationUsernameField().shouldBe(visible);
        logOutButton().click();
        logger.info("PositiveLoginTest completed successfully");
    }

    @Test(groups = "UiLoginsTest", retryAnalyzer = RetryAnalyzer.class)
    @Parameters({"browserName", "headless"})
    public void negativeLoginTestInvalidUsername(@Optional("chrome") String browserName, @Optional("true") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
        logger.info("Executing negativeLoginTestInvalidUsername with browser: {}, Headless: {}", browserName, headless);
        homePage();
        userField().setValue(EnvProperties.getInvalidUserPassword());
        passwordField().setValue(EnvProperties.getPassword());
        rememberMyField().click();
        signInButton().click();
        badUsernamePasswordField().shouldHave(text("Bad username or password"));
        logger.info("NegativeLoginTestInvalidUsername completed");
    }

    @Test(groups = "UiLoginsTest", retryAnalyzer = RetryAnalyzer.class)
    @Parameters({"browserName", "headless"})
    public void negativeLoginTestInvalidPassword(@Optional("chrome") String browserName, @Optional("false") boolean headless) {
        Configuration.browser = browserName;
        Configuration.headless = headless;
        logger.info("Executing negativeLoginTestInvalidPassword with browser: {}, Headless: {}", browserName, headless);
        homePage();
        userField().setValue(EnvProperties.getUser());
        passwordField().setValue(EnvProperties.getInvalidUserPassword());
        rememberMyField().click();
        signInButton().click();
        badUsernamePasswordField().shouldHave(text("Bad username or password"));
        logger.info("NegativeLoginTestInvalidPassword completed");
    }
}
