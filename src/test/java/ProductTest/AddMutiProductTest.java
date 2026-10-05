package ProductTest;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.checkout.CheckoutPage;
import pages.login.LoginPage;
import pages.product.ProductPage;

import java.util.ArrayList;
import java.util.List;

public class AddMutiProductTest extends BaseTest {
    @Test
    public void addMutiProduct()  {
         List<String> productsname = new ArrayList<>(List.of(
                jsonFileManager.getValue("product1").toString(),
                jsonFileManager.getValue("product2").toString(),
                jsonFileManager.getValue("product3").toString()
        ));
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        SoftAssert softAssert = new SoftAssert();

        loginPage.enterUsername(configHandler.getValue("username"));
        loginPage.enterPassword(configHandler.getValue("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(productPage.getTextFormTitle(), "Products");

        checkoutPage.add3ItemsToCart(productsname);
        Assert.assertEquals(checkoutPage.getCartCounter(), "3");
        checkoutPage.clickOnCart();

        softAssert.assertTrue(checkoutPage.getTextForBackPackItem().contains("Backpack"));
        softAssert.assertTrue(checkoutPage.getTextForBikeLightItem().contains("Light"));
        softAssert.assertTrue(checkoutPage.getTextForBoltItem().contains("Bolt"));
        softAssert.assertAll();

        checkoutPage.clickCheckoutButton();
        checkoutPage.enterFirstName(jsonFileManager.getValue("firstname").toString());
        checkoutPage.enterLastName(jsonFileManager.getValue("lastname").toString());
        checkoutPage.enterPostalCode(jsonFileManager.getValue("postalCode").toString());
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();
        Assert.assertTrue(checkoutPage.thanksMessage());

    }
}
