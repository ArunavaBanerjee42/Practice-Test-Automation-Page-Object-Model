package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Setup;
import pages.PracticePage;

public class PracticePageTest extends Setup {

    PracticePage obj;

    @BeforeMethod
    public void init() {
        obj = new PracticePage(driver);
    }

    @Test
    public void verifyTestLoginLink() throws InterruptedException {
        obj.clickLogin();
        String expectedUrl = "https://practicetestautomation.com/practice-test-login/";
        String actualUrl = obj.getTestExceptionsPageUrl();
        assertEquals(expectedUrl, actualUrl);
        Thread.sleep(4000);
        obj.back();
    }

    @Test
    public void verifyTestExceptionsLink() throws InterruptedException {
        obj.clickTestExceptions();
        String expectedUrl = "https://practicetestautomation.com/practice-test-exceptions/";
        String actualUrl = obj.getTestExceptionsPageUrl();
        assertEquals(expectedUrl, actualUrl);
        Thread.sleep(4000);
        obj.back();
    }

    @Test
    public void verifyTestTableLink() throws InterruptedException {
        obj.clickTestTable();
        String expectedUrl = "https://practicetestautomation.com/practice-test-table/";
        String actualUrl = obj.getTestExceptionsPageUrl();
        assertEquals(expectedUrl, actualUrl);
        Thread.sleep(4000);
        obj.back();
    }
}
