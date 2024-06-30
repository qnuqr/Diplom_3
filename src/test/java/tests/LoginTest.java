package tests;

import com.github.javafaker.Faker;
import driver_config.DriverConfig;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginTest {
    private WebDriver driver;
    private Faker faker = new Faker();

    @Before
    public void setUp() {
        DriverConfig driverConfig = new DriverConfig();
        driver = driverConfig.getDriver("chrome");
        driverConfig.navigateToUrl(driver);

    }

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());
    }
}
