package tests;


import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import stellaburgers.config.DriverConfig;
import stellaburgers.pages.MainPage;


public class MainPageTest extends AbstractTest {
    private WebDriver driver;
    private DriverConfig driverConfig;

    @Before
    public void setUp() {
        driverConfig = new DriverConfig();
        driver = DriverConfig.getDriver();
        driverConfig.navigateToUrl();
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Булки»")
    public void bunsSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.isChoiceSectionVisible();
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Соусы»")
    public void saucesSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesBtn();
        mainPage.isChoiceSectionVisible();
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Начинки»")
    public void fillingsSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingsBtn();
        mainPage.isChoiceSectionVisible();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driverConfig.quitDriver();
        }
    }
}
