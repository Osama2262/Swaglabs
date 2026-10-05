package pages.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.basePage.BasePage;

public class LoginPage extends BasePage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//h3");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private Logger log = LogManager.getLogger(LoginPage.class);

    public WebElement getUsername() {
        log.info("getting username");
        return findElement(username);
    }
    public WebElement getPassword() {
        log.info("getting password");
        return findElement(password);
    }
    public WebElement getLoginButton() {
        log.info("getting login button");
        return findElement(loginButton);
    }
    public WebElement getErrorMessage() {
        return findElement(errorMessage);
    }
    public void clickLoginButton() {
        getLoginButton().click();
        log.info("clicking login button");
    }
    public void enterUsername(String username) {
        getUsername().sendKeys(username);
        log.debug("Enter Username: {}", username);
    }
    public void enterPassword(String password) {
        getPassword().sendKeys(password);
        log.debug("Enter Password: {}", password);
    }
    public String getErrorText()
    { log.info("getting Text for error message");
        return getErrorMessage().getText();
    }
}
