package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Setup {
  protected WebDriver driver;
  @BeforeMethod
  public void setup() {
	  driver = new EdgeDriver();
	  driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      driver.get("https://practicetestautomation.com/");
  }
  
  @AfterMethod
  public void tearDown() throws InterruptedException {
	  Thread.sleep(4000);
	  driver.quit();
  }
  
  
}
