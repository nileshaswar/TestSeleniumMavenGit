package pageAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	// WebDriver driver;

	public LoginPage(WebDriver driver) {
		// this.driver = driver;
		super(driver);
	}

	public WebElement getEmailTBX() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordTBX() {
		return driver.findElement(By.id("password"));
	}

	public void setInValidEmail() {
		getEmailTBX().sendKeys("ifbsbczlbclizjncAs");
	}

	public void setInValidPassword() {
		getPasswordTBX().sendKeys("csugAIkjbhlzkhf");
	}

	public String getValidEmail() {
		setInValidEmail();
		setInValidPassword();
		signin();
		String s1 = driver.findElement(By.id("email_error")).getText();
		return s1.substring(s1.indexOf('k'), s1.length());
	}

	public String getValidPassword() {
		setInValidEmail();
		setInValidPassword();
		signin();
		String s1 = driver.findElement(By.id("password_error")).getText();
		return s1.substring(s1.indexOf('1'), s1.length());
	}

	public void setValidCredientials(String email, String password) {
		getEmailTBX().clear();
		getEmailTBX().sendKeys(email);
		getPasswordTBX().clear();
		getPasswordTBX().sendKeys(password);
	}
	
	public void navigateToDashboardPage(){
		setValidCredientials(getValidEmail(),getValidPassword());
		signin();
		
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.xpath(".//button[@type='submit']"));
	}
	
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}

	public void signin() {
		getSignInButton().click();

	}

	@FindBy(className = "login-box-msg")
	WebElement getLoginBoxMessageLabel;

	@FindBy(id = "email_error")
	WebElement getEmailLabel;

	@FindBy(id = "password_error")
	WebElement getPasswordLabel;

	public WebElement getLoginBoxMessageLabel() {
		System.out.println(getLoginBoxMessageLabel.getText());
		return getLoginBoxMessageLabel;
	}

	public WebElement getEmailLabel() {
		System.out.println(getEmailLabel.getText());
		return getEmailLabel;
	}

	public WebElement getPasswordLabel() {
		System.out.println(getPasswordLabel.getText());
		return getPasswordLabel;
	}


}
