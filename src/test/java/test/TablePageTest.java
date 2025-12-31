package test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Setup;
import pages.TablePage;

public class TablePageTest extends Setup{
  
  TablePage obj;
  @BeforeMethod
  public void init() {
	  obj = new TablePage(driver);
  }
  
  @Test (priority = 1)
  public void verifyLanguageFilter() throws InterruptedException {
	  obj.selectJavaLanguage();
	  Thread.sleep(4000);
	  assertTrue(obj.areAllCoursesJava(), "Non Java courses found");
  }
  
  @Test (priority = 2)
  public void verifyBeginnerLevelOnly() throws InterruptedException {
	  obj.uncheckIntermediate();
      obj.uncheckAdvanced();
      Thread.sleep(4000);
      assertTrue(obj.areAllCoursesBeginner(), "Non beginner course is visible");
  }
  
  @Test (priority = 3)
  public void verifyMinEnrollments() throws InterruptedException {
	  obj.selectMinEnrollments10k();
	  Thread.sleep(4000);
	  assertTrue(obj.areAllEnrollmentsAtLeast(10000), "Courses <10000 enrollments visible");
  }
  
  @Test (priority = 4)
  public void verifyNoResultsState() {
	  obj.uncheckAdvanced();
	  obj.uncheckBeginner();
	  obj.uncheckIntermediate();
	  assertTrue(obj.isNoMatchingCoursesVisible());
  }
  
  
}
