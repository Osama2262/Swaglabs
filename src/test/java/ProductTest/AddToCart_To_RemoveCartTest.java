package ProductTest;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.checkout.CheckoutPage;
import pages.login.LoginPage;
import pages.product.ProductPage;

import java.util.ArrayList;
import java.util.List;

public class AddToCart_To_RemoveCartTest extends BaseTest {
    @Test
    public void checkThatAddToCartChangedToRemove() {
        List<String> productsname = new ArrayList<>(List.of(
                excelFileManager.getCellValue(1,0),
                excelFileManager.getCellValue(2,0),
                excelFileManager.getCellValue(3,0)
        ));
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.enterUsername(configHandler.getValue("username"));
        loginPage.enterPassword(configHandler.getValue("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(productPage.getTextFormTitle(), "Products");
        checkoutPage.add3ItemsToCart(productsname);
        productPage.addProductsAndCheckOnRemoveButton();
    }
}
