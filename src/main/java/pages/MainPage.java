package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;

    private By createOrderBtn = By.xpath("//button[text()='Оформить заказ']");

    public void checkCreateOrderButton() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(createOrderBtn));
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
}
