package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void TestValidLogin() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        homePage.openLoginModal();
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("NicusorA", "Password123");
        Assert.assertTrue(homePage.isUserLoggedIn());
    }

    @Test
    public void TestInvalidLogin() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        homePage.openLoginModal();
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("NacusorA", "Password123");
        Assert.assertTrue(loginPage.isErrorMessageCorrect("User does not exist."));
    }

    @Test
    public void TestUsernameGol() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        homePage.openLoginModal();
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("", "Password123");
        Assert.assertTrue(loginPage.isErrorMessageCorrect("Please fill out Username and Password."));
    }

    @Test
    public void TestPasswordGol() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        homePage.openLoginModal();
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("NicusorA", "");
        Assert.assertTrue(loginPage.isErrorMessageCorrect("Please fill out Username and Password."));
    }

    @Test
    public void TestLoginPasswordGol() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        homePage.openLoginModal();
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("", "");
        Assert.assertTrue(loginPage.isErrorMessageCorrect("Please fill out Username"));
    }

    @Test
    public void TestUsernameInexistent() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        homePage.openLoginModal();
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("UserInexistent", "Password123");
        Assert.assertTrue(loginPage.isErrorMessageCorrect("User does not exist."));
    }

    @Test
    public void TestInvalidPassword() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        homePage.openLoginModal();
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("NicusorA", "Carantin2");
        Assert.assertTrue(loginPage.isErrorMessageCorrect("Wrong password."));
    }

    @Test
    public void TestLogout() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        homePage.openLoginModal();
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("NicusorA", "Password123");
        Assert.assertTrue(homePage.isUserLoggedIn());
        homePage.logout();
        Assert.assertTrue(homePage.isUserLoggedOut());
    }

    @Test
    public void TestAddToChart() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        homePage.openLoginModal();
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("NicusorA", "Password123");

//Mergem la lista de produse
        ProductsPage productsPage = new ProductsPage(driver, wait);
        productsPage.openProduct("Samsung galaxy s6");

        //Suntem in pagina produsului
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver, wait);
        productDetailsPage.addToCart();
    }
@Test
public void addToCart(){
        HomePage homePage=new HomePage(driver, wait);
        homePage.open();
        homePage.openLoginModal();
        LoginPage loginPage=new LoginPage(driver, wait);
        loginPage.login("NicusorA", "Password123");
        homePage.openHome();
        ProductsPage productsPage=new ProductsPage(driver,wait);
        ProductDetailsPage productDetailsPage=productsPage.openProduct("Samsung galaxy s7");
        productDetailsPage.addProductToCart();
        homePage.openCart();
        CartPage cartPage=new CartPage(driver, wait);
        Assert.assertTrue(cartPage.isProductInCart("Samsung galaxy s7"));
}
    }