package test;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Setup;
import pages.HomePage;

public class HomePageTest extends Setup {
  HomePage obj;
  @BeforeMethod
  public void init() {
	obj = new HomePage(driver);
  }
  @Test
  public void checkHomePageButton() throws InterruptedException {
	  obj.scrollToTheForm();
	  obj.enterName("Arunava");
	  obj.enterEmail("arunavabanerjee2018@gmail.com");
	  obj.clickButton();
	  String expectedTitle = "Confirm you’re not a robot";
	  Thread.sleep(4000);
	  String actualTitle = obj.checkTitle();
	  assertEquals(expectedTitle, actualTitle);
  }
  
}
