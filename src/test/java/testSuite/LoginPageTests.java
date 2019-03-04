package testSuite;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;

import pageAction.DashboardPage;
import pageAction.LoginPage;
//import pageAction.DashboardPage;








import org.testng.asserts.SoftAssert;

public class LoginPageTests extends BaseTest {

	WebDriver driver; // Making it global
	LoginPage loginpage;

	@BeforeClass
	public void initializeLoginPage() {
		System.out.println("=========== Executing LoginPageTests =========");
		driver = super.getDriver(); // access private variable of super class
//		System.out.println("\n 1 --driver object:" + driver);
		if (driver == null) {
			super.selectBrowser();// Explicitly Create driver object
			driver = super.getDriver();
//			System.out.println("\n 2 --driver object:" + driver);
		}
		
		loginpage = new LoginPage(driver);
		
		driver.get("file:///F:/JBK_Software/Selenium%20Software/Offline%20Website/index.html");
		Assert.assertEquals(loginpage.getCurrentPageTitle(), "AdminLTE 2 | Log in");
	}

	@Test
	public void loginWithInvalidCredentials() throws InterruptedException {
		// try to login with invalid credentials-wrong email & password
		loginpage.setInValidEmail();
		loginpage.setInValidPassword();
		loginpage.signin();
	}

	@Test(dependsOnMethods = "loginWithInvalidCredentials")
	public void verifyLoginPageLabels() {
		// check correctness of all the labels in login page
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(loginpage.getLoginBoxMessageLabel()
				.getText(), "Sign in to start your session");
		softAssertion.assertEquals(loginpage.getEmailLabel().getText(),
				"Please enter email as kiran@gmail.com");
		softAssertion.assertEquals(loginpage.getPasswordLabel().getText(),
				"Please enter password 123456");
		softAssertion.assertAll();
	}

	@Test(dependsOnMethods = "verifyLoginPageLabels")
	public void loginWithValidCredentials() {
		// try to login with invalid credentials-wrong email & password
		loginpage.setValidCredientials(loginpage.getValidEmail(),
				loginpage.getValidPassword());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		loginpage.signin();
		Assert.assertEquals(loginpage.getCurrentPageTitle(), "AdminLTE 2 | Dashboard");
		
	}
	@AfterClass
	public void navigateToNextPage(){
//		loginpage.loginWithValidCredentials();
//		new DashboardPage(this.driver);
//		new BaseTest(this.driver);
		
//		loginpage.browsercleanup();
	}

	
	
	
	
/*	@Test
	public void navigateToDashboardPage() {
		driver.get("file:///F:/JBK_Software/Selenium%20Software/Offline%20Website/index.html");
		loginpage.navigateToDashboardPage();
		Assert.assertEquals(loginpage.getCurrentPageTitle(), "AdminLTE 2 | Dashboard");
		System.out.println(driver.getTitle());
		dashboardpage = new DashboardPage(driver);
	}*/
	/*
	 * @Test public void softAssert_demo() {
	 * 
	 * Soft Assert – Soft Assert collects errors during @Test. Soft Assert does
	 * not throw an exception when an assert fails and would continue with the
	 * next step after the assert statement. If there is any exception and you
	 * want to throw it then you need to use assertAll() method as a last
	 * statement in the @Test and test suite again continue with next @Test as
	 * it is. We need to create an object to use Soft Assert which is not needed
	 * in Hard Assert.
	 * 
	 * SoftAssert softAssertion = new SoftAssert();
	 * System.out.println("softAssert Method Was Started");
	 * softAssertion.assertTrue(false);
	 * System.out.println("softAssert Method Was Executed");
	 * softAssertion.assertAll(); // Note: If you forget to call assertAll() at
	 * the end of your test, the // test will pass even if any assert objects
	 * threw exceptions as shown // in the above example. So don’t forget to add
	 * assertAll() }
	 * 
	 * @Test public void hardAssert_demo() {
	 * 
	 * Hard Assert – Hard Assert throws an AssertException immediately when an
	 * assert statement fails and test suite continues with next @Test The
	 * disadvantage of Hard Assert – It marks method as fail if assert condition
	 * gets failed and the remaining statements inside the method will be
	 * aborted.
	 * 
	 * System.out.println("hardAssert Method Was Started");
	 * Assert.assertTrue(false);
	 * System.out.println("hardAssert Method Was Executed"); }
	 */

}
