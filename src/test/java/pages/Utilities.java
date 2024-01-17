package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Utilities {

    WebDriver driver;

    public Utilities(WebDriver driver) {
        this.driver = driver;
       
    }
    

    /**
     * Waits for expected condition to be ture within the given time
     */
    public WebElement waitForElement(WebElement ele) {
        Wait<WebDriver> wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(ele));
        return ele;
    }

    /**
     * MoveToElement using Actions class
     */
    public void moveToElement(WebElement ele) {
        Actions action = new Actions(driver);
        action.moveToElement(ele).build().perform();
    }

    public void dragAndDrop(WebElement source, WebElement target){
        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).build().perform();
    }
}
