package testSuite;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeSuite;

import pageAction.LoginPage;

import org.testng.asserts.SoftAssert;

//import pageActions.LoginPage;
//extends LoginPage
public class LoginPageTests extends BaseTest {

	// WebDriver driver;
	WebDriver driver; // To access the private varible of the super class
	LoginPage loginpage;

	/*
	 * Moved to BaseTest.java
	 * 
	 * @BeforeSuite public void initializeDriver() { FirefoxOptions options =
	 * new FirefoxOptions(); options.setHeadless(false);
	 * options.setLogLevel(FirefoxDriverLogLevel.TRACE);
	 * System.setProperty("webdriver.gecko.driver",
	 * "C:\\PORTABLES\\geckodriver_v0.23.0_win64\\geckodriver.exe"); driver =
	 * new FirefoxDriver(options); }
	 */

	@BeforeClass
	public void openLoginPage() {
		driver= super.getDriver();
		loginpage = new LoginPage(driver);
		driver.get("file:///F:/JBK_Software/Selenium%20Software/Offline%20Website/index.html");

	}

	@Test
	public void mytest1() throws InterruptedException {
		// try to login with invalid credentials (Both username & password) are
		// wrong
		loginpage.getEmailTBX().sendKeys("adasd");
		loginpage.getPasswordTBX().sendKeys("adasdczs");
		loginpage.signin();
		Thread.sleep(3000);
		// Assert.assertTrue(condition);
//		assertEquals(loginpage.getPageTitle(), "AdminLTE 2|Log in");

		// loginpage.setInValidEmail();
		// loginpage.setInValidPassword();
		// loginpage.signin();
	}

	@Test
	public void softAssert_demo() {
		/*
		 * Soft Assert – Soft Assert collects errors during @Test. Soft Assert
		 * does not throw an exception when an assert fails and would continue
		 * with the next step after the assert statement. If there is any
		 * exception and you want to throw it then you need to use assertAll()
		 * method as a last statement in the @Test and test suite again continue
		 * with next @Test as it is. We need to create an object to use Soft
		 * Assert which is not needed in Hard Assert.
		 */
		SoftAssert softAssertion = new SoftAssert();
		System.out.println("softAssert Method Was Started");
		softAssertion.assertTrue(false);
		System.out.println("softAssert Method Was Executed");
		softAssertion.assertAll();
		// Note: If you forget to call assertAll() at the end of your test, the
		// test will pass even if any assert objects threw exceptions as shown
		// in the above example. So don’t forget to add assertAll()
	}

	@Test
	public void hardAssert_demo() {
		/*
		 * Hard Assert – Hard Assert throws an AssertException immediately when
		 * an assert statement fails and test suite continues with next @Test
		 * The disadvantage of Hard Assert – It marks method as fail if assert
		 * condition gets failed and the remaining statements inside the method
		 * will be aborted.
		 */
		System.out.println("hardAssert Method Was Started");
		Assert.assertTrue(false);
		System.out.println("hardAssert Method Was Executed");
	}

/*	@Test
	public void verifyLoginPageLabels() {
		SoftAssert softAssertion = new SoftAssert();
		// softAssertion.assertEquals(loginpage.get, expected);

		softAssertion.assertAll();
	}*/

	@Test
	public void mytest2() {
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\PORTABLES\\geckodriver_v0.23.0_win64\\geckodriver.exe");
		 */

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\PORTABLES\\chromedriver_win32\\chromedriver.exe");
		 */

		/*
		 * FirefoxOptions options = new FirefoxOptions();
		 * options.setHeadless(false);
		 * options.setLogLevel(FirefoxDriverLogLevel.TRACE); driver = new
		 * FirefoxDriver(options); driver.get(
		 * "file:///F:/JBK_Software/Selenium%20Software/Offline%20Website/index.html"
		 * ); void getUsername() WebElement mymail=
		 * driver.findElement(By.id("email")); mymail.sendKeys("aaa");
		 * WebElement mypass = driver.findElement(By.id("password"));
		 * mypass.sendKeys("asasas"); WebElement mybutton =
		 * driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button"));
		 * mybutton.click();
		 * 
		 * WebElement mymail_Label= driver.findElement(By.id("email_error"));
		 * String s = mymail_Label.getText(); String uname =
		 * s.substring(s.indexOf('k'), s.length());
		 * System.out.println("Nilesh --- > "+uname); mymail.clear();
		 * mymail.sendKeys(uname); WebElement mypass_Label=
		 * driver.findElement(By.id("password_error")); String s1 =
		 * mypass_Label.getText(); String password = s.substring(s.indexOf('k'),
		 * s.length()); mypass.clear(); mypass.sendKeys(password);
		 * mybutton.click();
		 */
		// driver.close();
		System.out.println("Nilesh");

	}

}
