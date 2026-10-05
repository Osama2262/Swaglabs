package utils;

import org.testng.annotations.DataProvider;

public class DataProviderTest {

    @DataProvider(name = "inValidCredentials")
    public Object[][] inValidData()
    {
        return new Object[][] {{"osama","pass123"}};
    }
    @DataProvider(name = "checkoutData")
    public Object[][]checkoutData() {
        return new Object[][]{
                {"standard_user","secret_sauce","Osama","Kandel","123 Main St"}
        };
    }
    @DataProvider(name = "validCredentials")
    public Object[][]validData()
    {
        return new Object[][] {{"standard_user","secret_sauce"}};
    }

    @DataProvider(name = "testJSON")
    public Object[][]testJSON() {
        return new Object[][]{
                {"standard_user","secret_sauce","Osama","Kandel","123 Main St"}
        };
    }
}
