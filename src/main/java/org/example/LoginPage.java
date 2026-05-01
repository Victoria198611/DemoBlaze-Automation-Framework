package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    //Locatorii
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By submitButton = By.xpath("//button[text()='Log in']");

    //Constructor
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Deschidem pagina
    public void open() {
        driver.get("https://www.demoblaze.com/");
    }

    //Introducem username
    public void enterUsername(String username) {
        type(usernameField, username);
    }

    //Introducem password
    public void enterPassword(String password) {
        type(passwordField, password);
    }

    //Click login
    public void clickLogin() {
        click(submitButton);
    }

    //Metoda completa de login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    //Verifica daca exista un mesaj de eroare dupa login
    //Asteapta aparitia alertului si returneaza tru daca acesta apare
    //Daca alertul nu apare(arunca exceprie) returneaza false.
    public boolean isErrorAlertDisplayed() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Verifica daca mesajul din alert este egal cu mesajul asteptat
    //Foloseste getAlert() din BAsePage pentru a citi textul alertului
    //Returneaza true daca mesajele coincid, altfel false
    public boolean isErrorMessageCorrect(String expectedMessage) {
        try {
            String text = getAlert();
            return text.contains(expectedMessage);
        } catch (Exception e) {
            return false;
        }
    }
}



