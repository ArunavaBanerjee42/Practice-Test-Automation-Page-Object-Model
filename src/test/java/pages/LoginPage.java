package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private By userNameInput;
    private By passwordInput;
    private By submitButton;
    private By errorMessage;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://practicetestautomation.com/practice-test-login/");

        setUserNameInput(By.id("username"));
        setPasswordInput(By.id("password"));
        setSubmitButton(By.id("submit"));
        setErrorMessage(By.id("error"));
    }

    // Getters & Setters
    public By getUserNameInput() {
        return userNameInput;
    }

    public void setUserNameInput(By userNameInput) {
        this.userNameInput = userNameInput;
    }

    public By getPasswordInput() {
        return passwordInput;
    }

    public void setPasswordInput(By passwordInput) {
        this.passwordInput = passwordInput;
    }

    public By getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(By submitButton) {
        this.submitButton = submitButton;
    }
    
	public By getErrorMessage() {
	    return errorMessage;
	}
	public void setErrorMessage(By errorMessage) {
		this.errorMessage = errorMessage;
	}


    // Actions
    public void enterUsername(String username) {
        driver.findElement(userNameInput).clear();
        driver.findElement(userNameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
    

    // Login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSubmit();
    }
    
    

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    
    public String getCurrentPageTitle() {
    	return driver.getTitle();
    }
    
    public boolean isErrorMessageDisplayed() {
    	return driver.findElement(errorMessage).isDisplayed();
    }

	
}
