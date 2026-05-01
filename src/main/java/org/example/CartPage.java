package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    //Locatori
    private By cartRows = By.cssSelector("#tbodyid tr");

    //Constructor
    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isProductInCart(String productName) {
        waitForVisible(cartRows);
        for (var row : driver.findElements(cartRows)) {
            if (row.getText().toLowerCase().contains(productName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
