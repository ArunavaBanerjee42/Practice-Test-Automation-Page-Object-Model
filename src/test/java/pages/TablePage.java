package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TablePage {

    WebDriver driver;

   
    private By javaRadio;
    private By beginnerCheckbox;
    private By intermediateCheckbox;
    private By advancedCheckbox;
    private By enrollDropdown;
    private By enroll10kOption;
    private By tableRows;
    private By noMatchingCourses;

    public TablePage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://practicetestautomation.com/practice-test-table/");
        setJavaRadio(By.xpath("//input[@name='lang' and @value='Java']"));
        setBeginnerCheckbox(By.xpath("//input[@name='level' and @value='Beginner']"));
        setIntermediateCheckbox(By.xpath("//input[@name='level' and @value='Intermediate']"));
        setAdvancedCheckbox(By.xpath("//input[@name='level' and @value='Advanced']"));
        setEnrollDropdown(By.id("enrollDropdown"));
        setEnroll10kOption(By.xpath("//li[@data-value='10000']"));
        setTableRows(By.xpath("//table[@id='courses_table']/tbody/tr"));
        setNoMatchingCourses(By.xpath("//*[@id=\"noData\"]"));
        
//        WebElement table =
//        	    new WebDriverWait(driver, Duration.ofSeconds(10))
//        	        .until(ExpectedConditions.visibilityOfElementLocated(tableRows));
//
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("window.scrollBy(0, 100)");
    }

    // Getters & Setters

    public By getJavaRadio() {
        return javaRadio;
    }

    public void setJavaRadio(By javaRadio) {
        this.javaRadio = javaRadio;
    }

    public By getBeginnerCheckbox() {
        return beginnerCheckbox;
    }

    public void setBeginnerCheckbox(By beginnerCheckbox) {
        this.beginnerCheckbox = beginnerCheckbox;
    }

    public By getIntermediateCheckbox() {
        return intermediateCheckbox;
    }

    public void setIntermediateCheckbox(By intermediateCheckbox) {
        this.intermediateCheckbox = intermediateCheckbox;
    }

    public By getAdvancedCheckbox() {
        return advancedCheckbox;
    }

    public void setAdvancedCheckbox(By advancedCheckbox) {
        this.advancedCheckbox = advancedCheckbox;
    }

    public By getEnrollDropdown() {
        return enrollDropdown;
    }

    public void setEnrollDropdown(By enrollDropdown) {
        this.enrollDropdown = enrollDropdown;
    }

    public By getEnroll10kOption() {
        return enroll10kOption;
    }

    public void setEnroll10kOption(By enroll10kOption) {
        this.enroll10kOption = enroll10kOption;
    }

    public By getTableRows() {
        return tableRows;
    }

    public void setTableRows(By tableRows) {
        this.tableRows = tableRows;
    }
    
    public By getNoMatchingCourses() {
		return noMatchingCourses;
	}

	public void setNoMatchingCourses(By noMatchingCourses) {
		this.noMatchingCourses = noMatchingCourses;
	}

    // ---------- Actions ----------

    public void selectJavaLanguage() {
        driver.findElement(javaRadio).click();
    }
    
    public void uncheckIntermediate() {
        WebElement cb = driver.findElement(intermediateCheckbox);
        if (cb.isSelected()) {
            cb.click();
        }
    }

    public void uncheckAdvanced() {
        WebElement cb = driver.findElement(advancedCheckbox);
        if (cb.isSelected()) {
            cb.click();
        }
    }
    
    public void uncheckBeginner() {
    	WebElement cb = driver.findElement(beginnerCheckbox);
    	if (cb.isSelected()) {
            cb.click();
        }
    }

    public void selectMinEnrollments10k() {
        driver.findElement(enrollDropdown).click();
        driver.findElement(enroll10kOption).click();
    }
    
    public void scrollToTheTable() {
    	WebElement table =
        	    new WebDriverWait(driver, Duration.ofSeconds(10))
        	        .until(ExpectedConditions.visibilityOfElementLocated(tableRows));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);",table);
    }
    
    public void scrollToTheElement() {
    	WebElement element =
        	    new WebDriverWait(driver, Duration.ofSeconds(10))
        	        .until(ExpectedConditions.visibilityOfElementLocated(noMatchingCourses));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    // Verifications

    public boolean areAllCoursesJava() {
    	scrollToTheTable();
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
        	 if (!row.isDisplayed()) {
                 continue;
             }
            String lang =
                row.findElement(By.xpath("./td[@data-col='language']")).getText();
            if (!lang.equals("Java")) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllCoursesBeginner() {
    	scrollToTheTable();
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
        	 if (!row.isDisplayed()) {
                 continue;
             }
            String level =
                row.findElement(By.xpath("./td[@data-col='level']")).getText();
            if (!level.equals("Beginner")) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllEnrollmentsAtLeast(int min) {
    	scrollToTheTable();
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
            String text =
                row.findElement(By.xpath("./td[@data-col='enrollments']")).getText();
            int enrollments = Integer.parseInt(text.replace(",", ""));
            if (enrollments < min) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isNoMatchingCoursesVisible() {
    	scrollToTheElement();
    	return driver.findElement(noMatchingCourses).isDisplayed();
    }

	
}
