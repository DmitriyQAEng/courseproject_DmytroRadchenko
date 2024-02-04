package ui.testsUi;

import com.codeborne.selenide.Configuration;

import utils.EnvProperties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class UITestBase {
    @BeforeClass
    public void setUpClass() {
        String browserType = EnvProperties.getBrowserType().toLowerCase();
        switch (browserType) {
            case "firefox":
                Configuration.browser = "firefox";
                break;
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "chromeheadless":
                Configuration.browser = "chrome";
                Configuration.headless = true;
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }

        Configuration.baseUrl = EnvProperties.getBaseUrl();
        Configuration.browserSize = EnvProperties.getBrowserSize();
        Configuration.fastSetValue = true;
    }

    public static void homePage() {
        open(EnvProperties.getHomePage());
    }

    @AfterClass(alwaysRun = true)
    public static void cleanUp() {
        closeWebDriver();
    }
}
