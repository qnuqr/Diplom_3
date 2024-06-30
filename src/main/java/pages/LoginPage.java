package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    private By signUpBtn = By.xpath("//a[text()='Зарегистрироваться']");
    private By inputEmail = By.xpath("//input[@class = 'text input__textfield text_type_main-default' and@type = 'text']");
    private By inputPassword = By.xpath("//input[@class = 'text input__textfield text_type_main-default' and@type = 'password']");
    private By loginBtn = By.xpath("//button[text()='Войти']");


    // конструктор класса
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Ожидание полной загрузки страницы
        waitForPageLoad();
    }

    // Метод ожидания полной загрузки страницы
    private void waitForPageLoad() {
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    //клик кнопки "Зарегистрироваться"
    public void clickSignUpBtn() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(signUpBtn));
        driver.findElement(signUpBtn).click();
    }

    //заполнение "email"
    public void setEmail(String email) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys(email);
    }

    //заполнение "пароля"
    public void setPassword(String password) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);
    }

    //клик кнопки "Войти"
    public void clickLoginBtn() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
    }



    //метод для авторизации
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginBtn();
    }


}
