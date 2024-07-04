package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import stellaburgers.config.DriverConfig;
import stellaburgers.model.User;
import stellaburgers.pages.LoginPage;
import stellaburgers.pages.MainPage;
import stellaburgers.steps.UserSteps;
import static org.hamcrest.CoreMatchers.is;


public class MainPageTest extends AbstractTest {
    private WebDriver driver;
    private Faker faker = new Faker();
    private User user;
    private UserSteps userSteps = new UserSteps();
    private DriverConfig driverConfig;

    @Before
    public void setUp() {
        driverConfig = new DriverConfig();
        driver = DriverConfig.getDriver();
        driverConfig.navigateToUrl();;
        user = new User();
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setName(faker.name().firstName());
        userSteps
                .createUser(user)
                .statusCode(200)
                .body("success", is(true));

    }

    @Test
    @DisplayName("Проверка перехода к разделу «Булки»")
    public void bunsSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        mainPage.isChoiceSectionVisible();
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Соусы»")
    public void saucesSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        mainPage.clickSaucesBtn();
        mainPage.isChoiceSectionVisible();
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Начинки»")
    public void fillingsSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        mainPage.clickFillingsBtn();
        mainPage.isChoiceSectionVisible();
    }

    @After
    public void tearDown() {
        if (user.getAccessToken() != null) {
            String token = userSteps.login(user)
                    .extract().body().path("accessToken");
            user.setAccessToken(token);
            userSteps.
                    deleteUser(user);
        }
        driverConfig.quitDriver();
    }



}
