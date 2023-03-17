package pages;

import com.aventstack.extentreports.ExtentTest;
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
    @FindBy(id = "ap_email")
    WebElement email;
    @FindBy(id = "continue")
    WebElement continueBtn;
    @FindBy(id = "ap_password")
    WebElement password;
    @FindBy(id = "signInSubmit")
    WebElement submit;
    @FindBy(xpath = "//*[@class='s-no-outline']")
    WebElement results;

    public void verifyHomePage() {
        utils.waitForElement(searchBox);
        utils.moveToElement(helloSignIn);
        signIn.click();
        utils.waitForElement(email).sendKeys("");
        continueBtn.click();
        utils.waitForElement(password).sendKeys("");
        submit.click();
        utils.waitForElement(searchBox).sendKeys("Alexa", Keys.ENTER);
        utils.waitForElement(results);
        Assertion assertion = new Assertion();
        assertion.assertEquals("RESULTS", results.getText());

        //test.assignDevice("Chrome").assignAuthor("Vivek").assignCategory("Regression").info("User is Results Page");

    }
}
