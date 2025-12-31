package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Setup {
  protected WebDriver driver;
  @Parameters("browser")
  @BeforeMethod
  public void setup(String browser) {

      if (browser.equalsIgnoreCase("firefox")) {
          driver = new FirefoxDriver();
      } else if (browser.equalsIgnoreCase("edge")) {
          driver = new EdgeDriver();
      }

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
