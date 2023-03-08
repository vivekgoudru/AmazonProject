package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import utils.TestBase;


public class AmazonTest extends TestBase {

    @Test(priority = 1)
    public void launch() {
        HomePage page = new HomePage(driver);
        page.verifyHomePage();

    }


}
