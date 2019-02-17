package com.nilesh;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowserTests {

//	public static void main(String[] args) {
		
	@Test
	public void mytest1(){
		System.setProperty("webdriver.gecko.driver",
				"C:\\PORTABLES\\geckodriver_v0.23.0_win64\\geckodriver.exe");
		
/*		System.setProperty("webdriver.chrome.driver",
				"C:\\PORTABLES\\chromedriver_win32\\chromedriver.exe");*/
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(false);
		options.setLogLevel(FirefoxDriverLogLevel.TRACE);
		WebDriver driver = new FirefoxDriver(options);
		driver.get("file:///F:/JBK_Software/Selenium%20Software/Offline%20Website/index.html");
		WebElement mymail= driver.findElement(By.id("email"));
		mymail.sendKeys("aaa");
		WebElement mypass = driver.findElement(By.id("password"));
		mypass.sendKeys("asasas");
		WebElement mybutton = driver.findElement(By.xpath("//*[@id='form']/div[3]/div/button"));
		mybutton.click();
		mymail.clear();
		mymail.sendKeys("kiran@gmail.com");
		mypass.clear();
		mypass.sendKeys("123456");
		mybutton.click();
		driver.close();
		
	}
}
