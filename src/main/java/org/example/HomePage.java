package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    //Locatorii
    private By loginButton = By.id("login2");
    private By messageWelcome = By.id("nameofuser");
    private By logoutButton = By.id("logout2");
    private By cartButton = By.id("cartur");
    private By homeButton = By.xpath("//a[contains(text(),'Home')]");

    //Constructor
    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Deschidem pagina
    public void open() {
        driver.get("https://www.demoblaze.com/");
    }

    public void openLoginModal() {
        click(loginButton);
    }

    public boolean isUserLoggedIn() {
        return waitForVisible(messageWelcome).isDisplayed();
    }

    public boolean isUserLoggedOut() {
        return waitForVisible(loginButton).isDisplayed();
    }

    public void logout() {
        click(logoutButton);
    }

    public CartPage openCart() {
        driver.findElement(cartButton).click();
        return new CartPage(driver, wait);
    }

    public void openHome() {
        waitForVisible(messageWelcome);
        for (int i = 0; i < 3; i++) {
            try {
                driver.findElement(homeButton).click();
                return; //daca merge iesim
            } catch (StaleElementReferenceException e) {
                //DOM-ul s-a reincarcat-reincercam
                waitForVisible(homeButton);
            }
        }
        //Daca dupa 3 incercari tot e stale, aruncam eroarea
        throw new RuntimeException("Home button is still stale after retries");
    }
}