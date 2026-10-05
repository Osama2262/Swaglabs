package pages.checkout;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.basePage.BasePage;

import java.util.List;

public class CheckoutPage extends BasePage {
    private Logger log = LogManager.getLogger(CheckoutPage.class);
    double Total_price_form_PLP = 0;
    private final By checkoutButton = By.id("checkout");
    private final By firstname = By.id("first-name");
    private final By lastname = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By thankMessage = By.className("complete-header");
    private final By cartCounter = By.xpath("//div[@class= 'shopping_cart_container']//span");
    private final By cartIcon = By.id("shopping_cart_container");
    private final By backPackItem = By.xpath("//div[@class='inventory_item_name' and contains(.,'Sauce Labs Backpack')]");
    private final By bikeLightItem = By.xpath("//div[@class='inventory_item_name' and contains(.,'Sauce Labs Bike Light')]");
    private final By boltItem = By.xpath("//div[@class='inventory_item_name' and contains(.,'Sauce Labs Bolt T-Shirt')]");
    private final By Total_CheckOutPage =By.className("summary_subtotal_label");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }


    public WebElement getCheckoutButton() {
        log.info("clicking CheckOut button");
        return findElement(checkoutButton);
    }
    public WebElement getFirstName() {
        log.info("Getting first name");
        return findElement(firstname);
    }
    public WebElement getLastName() {
        log.info("Getting last name");
        return findElement(lastname);
    }
    public WebElement getPostalCode() {
        log.info("Getting postal code");
        return findElement(postalCode);
    }
    public WebElement getContinueButton() {
        log.info("Getting continue button");
        return findElement(continueButton);
    }
    public WebElement getFinishButton() {
        log.info("Getting finish button");
        return findElement(finishButton);
    }
    public void enterFirstName(String firstName) {
        getFirstName().sendKeys(firstName);
        log.debug("Entering first name : {}", firstName);
    }
    public void enterLastName(String lastName) {
        getLastName().sendKeys(lastName);
        log.debug("Entering last name : {}", lastName);
    }
    public void enterPostalCode(String postalCode) {
        getPostalCode().sendKeys(postalCode);
        log.debug("Entering postal code : {}", postalCode);
    }
    public void clickCheckoutButton() {
        getCheckoutButton().click();
        log.info("Clicking checkout button");
    }
    public void clickContinueButton() {
        getContinueButton().click();
        log.info("Clicking continue button");
    }
    public void clickFinishButton() {
        getFinishButton().click();
        log.info("Clicking finish button");
    }
    public void clickOnCart() {
        findElement(cartIcon).click();
        log.info("Clicking cart button");
    }
    public String getCartCounter() {
        log.info("Getting count of cart counter");
        return findElement(cartCounter).getText();
    }
    public String getTextForBackPackItem() {
        log.info("Getting text for back pack item: {}",findElement(backPackItem).getText());
        return findElement(backPackItem).getText();
    }
    public String getTextForBikeLightItem() {
        log.info("Getting text for bike light item: {}",findElement(bikeLightItem).getText());
        return findElement(bikeLightItem).getText();
    }
    public String getTextForBoltItem() {
        log.info("Getting text for bolt item: {}",findElement(boltItem).getText());
        return findElement(boltItem).getText();
    }

    public double getTotal_CheckOutPage() {
        String temp =findElement(Total_CheckOutPage).getText().split("\\$")[1];
        log.debug("Getting total check out page {}",temp);
        return Double.parseDouble(temp);
    }

    public Boolean thanksMessage() {
        log.debug("Checking thanks message is Displayed or not: {}",findElement(thankMessage).isDisplayed());
        return findElement(thankMessage).isDisplayed();
    }


    public void add3ItemsToCart(List<String> listProducts) {
        log.info("Adding 3 items to cart with products");
        int counter =listProducts.size()-1;
        log.debug("Getting count of items to cart with products: {}",counter);
        while(counter>=0)
        {
            log.info("Loop into Product List");
            log.info("find item : '{}'",listProducts.get(counter));
            WebElement products = findElement(By.xpath("//div[@class='inventory_item' and contains(.,'"
                    + listProducts.get(counter) +
                    "')]//button"));
            log.debug("Add item {} to cart",listProducts.get(counter));
            log.info("Click on Add to cart button for this product");
            products.click();


            String totalPriceForItems = findElement(By.xpath("//div[@class='inventory_item' and contains(.,'"
                    + listProducts.get(counter) +
                    "')]//div[@class='inventory_item_price']")).getText().split("\\$")[1];
            Total_price_form_PLP += Double.parseDouble(totalPriceForItems);
            counter--;
        }
    }
    public double getTotal_price_form_PLP()
    {
        return Total_price_form_PLP;
    }
}
