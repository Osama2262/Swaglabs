package ProductTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.BaseTest;
import pages.login.LoginPage;
import pages.product.ProductPage;

public class AddItemOnCartTest extends BaseTest {
    @Test
    public void itemOnTheCart()
    {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        loginPage.enterUsername(configHandler.getValue("username"));
        loginPage.enterPassword(configHandler.getValue("password"));
        loginPage.clickLoginButton();
        productPage.clickBackPackItem();
        Assert.assertEquals(productPage.getTextFormTitle(), "Products");
        Assert.assertEquals(productPage.getTextFromCart(), "1");

        productPage.clickCartIcon();
        Assert.assertTrue(productPage.getCartList().isDisplayed());

    }

}
