package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (id = "username")
    private WebElement userNameInput;
	
	@FindBy (id = "password")
    private WebElement passwordInput;
	
	@FindBy (id = "submit")
    private WebElement submitButton;
	
	@FindBy (id = "error")
    private WebElement errorMessage;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://practicetestautomation.com/practice-test-login/");
        PageFactory.initElements(driver, this);
        
    }

    // Actions
    public void enterUsername(String username) {
        userNameInput.clear();
        userNameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickSubmit() {
        submitButton.click();
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
    	return errorMessage.isDisplayed();
    }

	
}
