package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BasePage {

    //Locatori
    private By addToCartButton= By.xpath("//a[contains(text(),'Add to cart')]");

    //Constructor
    public ProductDetailsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
public void addToCart(){
    click(addToCartButton);
}
public void addProductToCart(){
        addToCart();
        acceptAlert();
}
}
