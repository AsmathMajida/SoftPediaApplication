package com.Pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Page_ContactUs 
{
	WebDriver driver;
	// declaration of locators and reference variables
	//By click_i_icon=By.xpath("//*[@id=\"navicos\"]/li[2]");
	//By click_contactus=By.linkText("Contact Us");
	By click_radiobutton=By.xpath("/html/body/div/div[2]/div/div[2]/form/p/span[2]/b");
	By message=By.xpath("//*[@id=\"ctf_message_1\"]");
	By email=By.xpath("//*[@id=\"ctf_email_1\"]");
	By click_send=By.xpath("//*[@id=\"spradio_ctf_1\"]/button");
	
	//code for launch browser
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.softpedia.com/");
	}
	//Click the contact us field using move to element method
	public void contactus()
	{
		driver.findElement(By.xpath("//*[@id=\"navicos\"]/li[2]")).click();;
		WebElement a=driver.findElement(By.linkText("Contact Us"));
		Actions action=new Actions(driver);
		action.moveToElement(a).click().build().perform();
	}
	//code for click radio button
	public void radiobutton()
	{
		driver.findElement(click_radiobutton).click();
	}
	//code for send message through passing values for message and email field
	public void message_email(String msg, String emailid)
	{
		driver.findElement(message).sendKeys(msg);
		driver.findElement(email).sendKeys(emailid);
	}
	//code for send button
	public void send_button()
	{
		driver.findElement(click_send).click();
	}
	//code for screenshot
	public  void takeSnapShot(String path) throws Exception
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(path);
        FileUtils.copyFile(SrcFile, DestFile);
	}
	//close the browser
	public void Quit()
	{
		driver.close();
	}
}
