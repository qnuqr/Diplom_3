package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;

    private By registrationHeader = By.xpath("//h2[text()='Регистрация']");
    private By inputName = By.xpath("(//input[@class='text input__textfield text_type_main-default'])[1]");
    private By inputEmail = By.xpath("(//input[@class='text input__textfield text_type_main-default'])[2]");
    private By inputPassword = By.xpath("(//input[@class='text input__textfield text_type_main-default'])[3]");
    private By signUpBtn = By.xpath("//button[text()='Зарегистрироваться']");
    private By createOrderBtn = By.xpath("//button[text()='Оформить заказ']");


    public void waitForRegHeader() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(registrationHeader));
    }

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickSignUpBtn() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(signUpBtn));
        driver.findElement(signUpBtn).click();
    }
    public void checkCreateOrderButton() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(createOrderBtn));
    }

    public void signUpUser(String name, String email, String password) {
        waitForRegHeader();
        setName(name);
        setEmail(email);
        setPassword(password);
        clickSignUpBtn();
    }
}
