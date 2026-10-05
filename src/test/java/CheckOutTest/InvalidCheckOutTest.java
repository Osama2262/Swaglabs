package CheckOutTest;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.checkout.CheckoutPage;
import pages.login.LoginPage;
import pages.product.ProductPage;

public class InvalidCheckOutTest extends BaseTest {
    @Test
    public void invalidCheckOutTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.enterUsername(configHandler.getValue("username"));
        loginPage.enterPassword(configHandler.getValue("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(productPage.getTextFormTitle(), "Products");
        productPage.clickCartIcon();
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstName(jsonFileManager.getValue("firstname").toString());
        checkoutPage.enterLastName(jsonFileManager.getValue("lastname").toString());
        checkoutPage.enterPostalCode(jsonFileManager.getValue("postalCode").toString());
        checkoutPage.clickContinueButton();
        Assert.assertEquals(productPage.getTextFormTitle(), "Checkout: Overview");
    }

}
