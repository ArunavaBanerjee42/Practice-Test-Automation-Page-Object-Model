package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticePage {

    private By testLoginLink;
    private By testExceptionsLink;
    private By testTableLink;

    WebDriver driver;

    public PracticePage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://practicetestautomation.com/practice/");
        setTestLoginLink(By.linkText("Test Login Page"));
        setTestExceptionsLink(By.linkText("Test Exceptions"));
        setTestTableLink(By.linkText("Test Table"));
    }

    // Getters & Setters 

    public By getTestLoginLink() {
        return testLoginLink;
    }

    public void setTestLoginLink(By testLoginLink) {
        this.testLoginLink = testLoginLink;
    }

    public By getTestExceptionsLink() {
        return testExceptionsLink;
    }

    public void setTestExceptionsLink(By testExceptionsLink) {
        this.testExceptionsLink = testExceptionsLink;
    }

    public By getTestTableLink() {
        return testTableLink;
    }

    public void setTestTableLink(By testTableLink) {
        this.testTableLink = testTableLink;
    }

    // Actions

    // Test Login Page
    public void clickLogin() {
        driver.findElement(testLoginLink).click();
    }

    public String getLoginPageUrl() {
        return driver.getCurrentUrl();
    }

    // Test Exceptions Page
    public void clickTestExceptions() {
        driver.findElement(testExceptionsLink).click();
    }

    public String getTestExceptionsPageUrl() {
        return driver.getCurrentUrl();
    }

    // Test Table Page
    public void clickTestTable() {
        driver.findElement(testTableLink).click();
    }

    public String getTestTablePageUrl() {
        return driver.getCurrentUrl();
    }

    // navigate back
    public void back() {
        driver.navigate().back();
    }
}
