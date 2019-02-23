package pageAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	protected WebElement getEmailTBX() {
		return driver.findElement(By.id("email"));
	}

	protected WebElement getPasswordTBX() {
		return driver.findElement(By.id("password"));
	}

	protected String getValidEmail() {
		getEmailTBX().sendKeys("aaaa");
		String s1 = driver.findElement(By.id("email_error")).getText();
		return s1.substring(s1.indexOf('j'), s1.length());
	}

	protected String getValidPassword() {
		getPasswordTBX().sendKeys("aaaa");
		String s1 = driver.findElement(By.id("password_error")).getText();
		return s1.substring(s1.indexOf('j'), s1.length());
	}

	protected void setValidEmail(String email) {
		getEmailTBX().clear();
		getEmailTBX().sendKeys(email);
	}

	protected void setValidPassword(String password) {
		getPasswordTBX().clear();
		getPasswordTBX().sendKeys(password);
	}

	protected void signin() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

	// @FindBy()

}
