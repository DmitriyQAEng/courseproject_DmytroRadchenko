package ui.stepsselenide;

import utils.EnvProperties;

import static com.codeborne.selenide.Selenide.open;
import static ui.elements.UserCredentialsComponents.*;


public class LoginPage{
    public static void loginAsAdmin() {
        open(EnvProperties.getHomePage());
        if(!dashboardLogo().isDisplayed()) {
            userField().setValue(EnvProperties.getUser());
            passwordField().setValue(EnvProperties.getPassword());
            rememberMyField();
            signInButton().click();
        }
    }
}


