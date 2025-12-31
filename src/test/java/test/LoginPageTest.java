package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Setup;
import pages.LoginPage;

public class LoginPageTest extends Setup {
  LoginPage obj;
  @BeforeMethod
  public void init() {
      obj = new LoginPage(driver);
  }
  @Test 
  public void verifyLoginWithValidCredentials() {
	  obj.login("student", "Password123");
	  String expectedTitle = "Logged In Successfully | Practice Test Automation";
	  String actualTitle = obj.getCurrentPageTitle();
	  assertEquals(expectedTitle, actualTitle);
  }
  
  @Test
  public void negativeUsernameTest() {
	  obj.login("incorrectUser", "Password123");
	  assertTrue(obj.isErrorMessageDisplayed());
  }
  
  @Test
  public void negativePasswordTest() {
	  obj.login("student", "incorrectPassword");
	  assertTrue(obj.isErrorMessageDisplayed());
  }
  
}
