package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new Utilities(this.driver);
    }

    Utilities utils;
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;
    @FindBy(xpath = "//span[contains(text(),'Hello, sign in')]")
    WebElement helloSignIn;
    @FindBy(id = "nav-flyout-ya-signin")
    WebElement signIn;
    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "continue")
    WebElement continueBtn;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement loginBtn;
    @FindBy(xpath = "//span[@class='title']")
    WebElement product;

    public void verifyHomePage() {
        username.sendKeys("error_user");
        password.sendKeys("secret_sauce");
        loginBtn.click();
        utils.waitForElement(product);
        // Assertion assertion = new Assertion();
        //test.assignDevice("Chrome").assignAuthor("Vivek").assignCategory("Regression").info("User is Results Page");

    }
}
