package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

    //Locatorii pentru lista de produse
    private By productLink = By.cssSelector(".hrefch");

    //Constructor
    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public ProductDetailsPage openProduct(String productName) {
        waitForVisible(productLink);

        for (int i = 0; i < 3; i++) {
            try {
                for (var product : driver.findElements(productLink)) {
                    if (product.getText().trim().equalsIgnoreCase(productName.trim())) {
                        product.click();
                        return new ProductDetailsPage(driver, wait);
                    }
                }
            } catch (StaleElementReferenceException e) {
                // reîncarcă lista și încearcă din nou
                waitForVisible(productLink);
            }
        }

        throw new RuntimeException("Product not found: " + productName);
    }
}