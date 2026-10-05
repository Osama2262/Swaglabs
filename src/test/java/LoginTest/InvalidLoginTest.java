package LoginTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.BaseTest;
import pages.login.LoginPage;
import utils.DataProviderTest;


public class InvalidLoginTest extends BaseTest {
    @Test(dataProvider = "inValidCredentials",dataProviderClass = DataProviderTest.class)
    public void invalidLogin(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorText().contains("not match"));
    }

}
