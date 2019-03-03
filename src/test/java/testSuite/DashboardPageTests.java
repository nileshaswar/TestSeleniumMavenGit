package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;

//import pageAction.LoginPage;
import pageAction.DashboardPage;

public class DashboardPageTests extends BaseTest {

	WebDriver driver; // Making it global
	DashboardPage dashboardpage;

	@BeforeClass
	public void initializeDashboardPage() {
		driver = super.getDriver(); // To access the private variable of the
									// super class
		super.navigateToDashboardPage();
		dashboardpage = new DashboardPage(driver);
		Assert.assertEquals(dashboardpage.getCurrentPageTitle(), "AdminLTE 2 | Dashboard");
//		System.out.println(dashboardpage.getCurrentPageTitle());
	}

	@Test
	public void navigateToDashboardPage1() {
		System.out.println("Test Case 1");
		System.out.println(driver.getTitle());
		System.out.println(dashboardpage.getCurrentPageTitle());
	}
	@Test
	public void navigateToDashboardPage2() {
		System.out.println("Test Case 2");
		System.out.println(dashboardpage.getCurrentPageTitle());
	}
	@Test
	public void logOut() {
		dashboardpage.getSidebarLogoutLink().click();
		Assert.assertEquals(dashboardpage.getCurrentPageTitle(), "AdminLTE 2 | Log in");
	}

}
