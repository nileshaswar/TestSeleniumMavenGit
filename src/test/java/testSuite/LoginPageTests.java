package testSuite;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pageAction.LoginPage;

//import pageActions.LoginPage;

public class LoginPageTests extends LoginPage {

	WebDriver driver;

	public LoginPageTests(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@BeforeSuite
	void initializeDriver() {
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(false);
		options.setLogLevel(FirefoxDriverLogLevel.TRACE);
		System.setProperty("webdriver.gecko.driver",
				"C:\\PORTABLES\\geckodriver_v0.23.0_win64\\geckodriver.exe");
		driver = new FirefoxDriver(options);
	}

	@BeforeClass
	void openLoginPage() {

		driver.get("file:///F:/JBK_Software/Selenium%20Software/Offline%20Website/index.html");
		LoginPage loginpage = new LoginPage(driver);

	}

	@Test
	public void mytest1() {
		// try to login with invalid credentials (Both username & password) are
		// wrong
		System.out.println("Nilesh1");
//		getEmailTBX().sendKeys("aa");
//		getPasswordTBX().sendKeys("asasa");
//		signin();
	}
	
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
