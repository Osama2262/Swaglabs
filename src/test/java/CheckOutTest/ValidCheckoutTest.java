package CheckOutTest;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.checkout.CheckoutPage;
import pages.login.LoginPage;
import pages.product.ProductPage;

public class ValidCheckoutTest extends BaseTest {
    @Test
    public void checkout() {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        loginPage.enterUsername(configHandler.getValue("username"));
        loginPage.enterPassword(configHandler.getValue("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(productPage.getTextFormTitle(), "Products");
        productPage.clickBackPackItem();
        Assert.assertEquals(productPage.getTextFromCart(), "1");
        productPage.clickCartIcon();
        Assert.assertTrue(productPage.getCartList().isDisplayed());
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstName(jsonFileManager.getValue("firstname").toString());
        checkoutPage.enterLastName(jsonFileManager.getValue("lastname").toString());
        checkoutPage.enterPostalCode(jsonFileManager.getValue("postalCode").toString());
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();

        Assert.assertTrue(checkoutPage.thanksMessage());
    }


}
