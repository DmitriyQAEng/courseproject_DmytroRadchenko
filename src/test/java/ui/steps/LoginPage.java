package ui.steps;

import config.ConfigProperties;

import static com.codeborne.selenide.Selenide.open;
import static elements.UserCredentialsComponents.*;


public class LoginPage{
    public static void loginAsAdmin() {
        open(ConfigProperties.getHomePage());
        userField().setValue(ConfigProperties.getUser());
        passwordField().setValue(ConfigProperties.getPassword());
        rememberMyField();
        signInButton().click();
    }
}


