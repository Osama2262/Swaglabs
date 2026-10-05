package LoginTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.BaseTest;
import pages.login.LoginPage;
import pages.product.ProductPage;

public class ValidLoginTest extends BaseTest {
    @Test
    public void validLoginTest()  {

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        loginPage.enterUsername(configHandler.getValue("username"));
        loginPage.enterPassword(configHandler.getValue("password"));
        loginPage.clickLoginButton();

        Assert.assertEquals(productPage.getTextFormTitle(), "Products");
    }

}
