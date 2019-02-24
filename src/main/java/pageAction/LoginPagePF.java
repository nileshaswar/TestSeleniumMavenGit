package pageAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

//import org.openqa.selenium.support.FindBy;

public class LoginPagePF {

	WebDriver driver;

	// public WebElement we;

	public LoginPagePF(WebDriver driver) {
		// System.out.println(this.driver+"global in pom java class");
		// System.out.println(driver+"Local which came from test class");
		this.driver = driver;
		// System.out.println(this.driver+"global in pom java class after assignment");
	}

	public WebElement getEmailTBX() {
		// System.out.println("1");
		return driver.findElement(By.id("email"));

	}

	public WebElement getPasswordTBX() {
		return driver.findElement(By.id("password"));
	}

	public void setInValidEmail() {
		getEmailTBX().clear();
		getEmailTBX().sendKeys("ifbsbczlbclizjncAs");
	}

	public void setInValidPassword() {
		getPasswordTBX().clear();
		getPasswordTBX().sendKeys("csugAIkjbhlzkhf");
	}

	public String getValidEmail() {
		getEmailTBX().sendKeys("aaaa");
		String s1 = driver.findElement(By.id("email_error")).getText();
		return s1.substring(s1.indexOf('j'), s1.length());
	}

	public String getValidPassword() {
		getPasswordTBX().sendKeys("aaaa");
		String s1 = driver.findElement(By.id("password_error")).getText();
		return s1.substring(s1.indexOf('j'), s1.length());
	}

	public void setValidEmail(String email) {
		getEmailTBX().clear();
		getEmailTBX().sendKeys(email);
	}

	public void setValidPassword(String password) {
		getPasswordTBX().clear();
		getPasswordTBX().sendKeys(password);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void signin() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

//	@FindBy(xpath = "//p[@Class='login-box-msg']")
//	WebElement getLoginBoxMessageLabel;

	@FindBy(className = "login-box-msg")
	WebElement getLoginBoxMessageLabel;
	
	@FindBy(id = "email_error")
	WebElement getEmailLabel;

	@FindBy(id = "password_error")
	WebElement getPasswordLabel;
	

}
