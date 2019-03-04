package testSuite;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
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
		System.out.println("=========== Executing DashboardPageTests =========");
		driver = super.getDriver(); // access private variable of super class
		System.out.println("\n 1 --driver object:" + driver);

		if (driver == null) {
			super.selectBrowser();// Explicitly Create driver object
			driver = super.getDriver();
			System.out.println("\n 2 --driver object:" + driver);
		}
		// System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("about:blank")) {
			System.out.println("\n 3 --true -- its blank page \n");
			super.navigateToDashboardPage();
		}

		dashboardpage = new DashboardPage(driver);
		Assert.assertEquals(dashboardpage.getCurrentPageTitle(),
				"AdminLTE 2 | Dashboard");
	}

	@AfterClass
	public void browsercleanup() {
//		dashboardpage.browsercleanup();
	}

	@Test
	public void dashboardPageTitle1() {
		System.out.println("Test Case 1");
		System.out.println(driver.getTitle());
		System.out.println(dashboardpage.getCurrentPageTitle());
	}

	@Test
	public void dashboardPageTitle2() {
		System.out.println("Test Case 2");
		System.out.println(dashboardpage.getCurrentPageTitle());
	}

	@Test
	public void logOut() {
		dashboardpage.getSidebarLogoutLink().click();
		Assert.assertEquals(dashboardpage.getCurrentPageTitle(),
				"AdminLTE 2 | Log in");
	}

}
