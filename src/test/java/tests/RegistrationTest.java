package tests;

import com.github.javafaker.Faker;
import driver_config.DriverConfig;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import steps.UserSteps;

public class RegistrationTest {
    private WebDriver driver;
    private Faker faker = new Faker();
    private UserSteps userSteps = new UserSteps();
    private User user;
    String name = "Eee";
    String email = "qwe17@bk.ru";
    String password = "Aa123456!";

    @Before
    public void setUp() {
        DriverConfig driverConfig = new DriverConfig();
        driver = driverConfig.getDriver("chrome");
        driverConfig.navigateToUrl(driver);
    }

    @Test
    public void signUpTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignUpBtn();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.signUpUser(name, email, password);
        //LoginPage loginPage1 = new LoginPage(driver);
        loginPage.login(email, password);
        MainPage mainPage = new MainPage(driver);
        mainPage.checkCreateOrderButton();
    }

}
