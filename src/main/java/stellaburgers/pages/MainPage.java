package stellaburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private final WebDriver driver;

    private final By createOrderBtn = By.xpath("//button[text()='Оформить заказ']");
    private final By loginBtn = By.xpath("//button[text()='Войти в аккаунт']");
    private final By persAccBtn = By.xpath("//p[text()='Личный Кабинет']");
    private final By collectBurgerText = By.xpath("//h1[text()='Соберите бургер']");
    private final By choiceSectionOfIngredients = By.xpath(".//div[contains(@class,'tab_tab_type_current')]");
    private final By saucesBtn = By.xpath("//span[text()='Соусы']");
    private final By fillingsBtn = By.xpath("//span[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //получение текста кнопки "Оформить заказ"
    public String getCreateOrderButtonText() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(createOrderBtn));
        return driver.findElement(createOrderBtn).getText();
    }

    //вход по кнопке «Войти в аккаунт» на главной
    public void clickLoginButton() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
    }

    //вход через кнопку «Личный кабинет»
    public void clickPersAccBtn() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(persAccBtn));
        driver.findElement(persAccBtn).click();
    }

    public String getCollectBurgerText() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(collectBurgerText));
        return driver.findElement(collectBurgerText).getText();
    }

    public boolean isChoiceSectionVisible() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(choiceSectionOfIngredients));
        return driver.findElement(choiceSectionOfIngredients).isDisplayed();
    }

    public void clickSaucesBtn() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(saucesBtn));
        driver.findElement(saucesBtn).click();
    }

    public void clickFillingsBtn() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(fillingsBtn));
        driver.findElement(fillingsBtn).click();
    }
}
