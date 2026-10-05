package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.basePage.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage {
    List<String> productsname = new ArrayList<>(List.of(
            "Backpack",
            "Bike Light",
            "T-Shirt"
    ));
    int counter =productsname.size()-1;

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    private final By title = By.className("title");
    private final By backPackItem = By.xpath("//div[@class='inventory_item' and contains(.,'Sauce Labs Backpack')]//button");
    private final By cartIcon = By.xpath("//a[@class=\"shopping_cart_link\"]");
    private final By cartList = By.xpath("//div[@class='cart_item']");
    private final By cartCounter = By.className("shopping_cart_badge");
    private final By removeButton = By.id("remove");
    private final By backToProductsButton = By.id("back-to-products");
    private final By AllProducts = By.xpath("//div[@class='inventory_item_name ']");

    public WebElement getTitle()
    {
        return findElement(title);
    }
    public WebElement getBackPackItem()
    {
        return findElement(backPackItem);
    }
    public WebElement getCartIcon()
    {
        return findElement(cartIcon);
    }
    public WebElement getCartList()
    {
        return findElement(cartList);
    }
    public WebElement getCartCounter()
    {
        return findElement(cartCounter);
    }


    public String getTextFormTitle()
    {
        return getTitle().getText();
    }
    public void clickBackPackItem()
    {
        getBackPackItem().click();
    }
    public void clickCartIcon()
    {
        getCartIcon().click();
    }
    public String getTextFromCart()
    {
        return getCartCounter().getText();
    }
    //still working on it

    public void addProductsAndCheckOnRemoveButton()
    {
        while (counter>=0)
        {
            WebElement products = findElement(By.xpath("//div[@class='inventory_item_name ' and contains(.,'"
                    + productsname.get(counter) +
                    "')]"));
            products.click();
            if(findElement(removeButton).isDisplayed())
            {
                findElement(backToProductsButton).click();
            }
            counter--;
        }
    }



}
