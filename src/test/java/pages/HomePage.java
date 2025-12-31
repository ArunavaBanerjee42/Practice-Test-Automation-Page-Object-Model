package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private By form = By.xpath("//*[@id=\"mp_form_below_posts7\"]/form");
	private By formNameInput = By.xpath("//*[@id=\"form_first_name_7\"]");
	private By formEmailInput = By.xpath("//*[@id=\"form_email_7\"]");
	private By xpathCheatSheetButton = By.xpath("//*[@id=\"mp_form_below_posts7\"]/form/div[3]/input");
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public void scrollToTheForm() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript(
	        "arguments[0].scrollIntoView(true)",
	        driver.findElement(form)
	    );
	}
	
	public void enterName(String name) {
		driver.findElement(formNameInput).sendKeys(name);
	}
	public void enterEmail(String email) {
		driver.findElement(formEmailInput).sendKeys(email);
	}
	public void clickButton() {
		driver.findElement(xpathCheatSheetButton).click();
	}
	public String checkTitle() {
	    By heading = By.xpath("//*[@id='loop-container']//h1");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(heading));

	    return driver.findElement(heading).getText();
	}

	
}
