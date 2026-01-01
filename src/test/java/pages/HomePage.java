package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	@FindBy(xpath = "//*[@id='mp_form_below_posts7']/form")
	private WebElement form;

	@FindBy(xpath = "//*[@id='form_first_name_7']")
	private WebElement formNameInput;

	@FindBy(xpath = "//*[@id='form_email_7']")
	private WebElement formEmailInput;

	@FindBy(xpath = "//*[@id='mp_form_below_posts7']/form/div[3]/input")
	private WebElement xpathCheatSheetButton;

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void scrollToTheForm() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript(
	        "arguments[0].scrollIntoView(true)",
	        form
	    );
	}
	public void enterName(String name) {
		formNameInput.sendKeys(name);
	}
	public void enterEmail(String email) {
		formEmailInput.sendKeys(email);
	}
	public void clickButton() {
		xpathCheatSheetButton.click();
	}
	public String checkTitle() {
	    By heading = By.xpath("//*[@id='loop-container']//h1");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(heading));

	    return driver.findElement(heading).getText();
	}

	
}
