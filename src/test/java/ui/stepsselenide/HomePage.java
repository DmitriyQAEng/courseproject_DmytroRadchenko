package ui.stepsselenide;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static ui.elements.UserCredentialsComponents.dashboardLogo;
import static ui.elements.UserCredentialsComponents.dashboardPageTitle;

public class HomePage { public static void goToDashboard() {
    dashboardLogo().should(visible, Duration.ofSeconds(10));
    dashboardLogo().click();
    dashboardPageTitle().should(visible, Duration.ofSeconds(10));
}
}
