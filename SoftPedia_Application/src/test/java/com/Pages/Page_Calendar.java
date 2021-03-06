package com.Pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Page_Calendar 
{
	WebDriver driver;
	// declaring reference variable and locators with expressions
	By cal_left=By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[1]/a");
	By click_date=By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div[2]/div[17]/a");
	By click_news=By.xpath("/html/body/div[1]/div[2]/div[2]/div[18]/div[3]/h3/a");
	// code for launch the browser
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://news.softpedia.com/newsArchive/");
	}
	//code for click left element in the calendar field
	public void select_mon_year()
	{
		driver.findElement(cal_left).click();
	}
	//code for select date
	public void select_date()
	{
		driver.findElement(click_date).click();
	}
	// code for scrolling the news
	public void Scroll_click()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");	
		driver.findElement(click_news).click();
	}
	//code for screenshot
	public  void takeSnapShot(String path) throws Exception
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(path);
        FileUtils.copyFile(SrcFile, DestFile);
	}
	// Close method
	public void quit() 
	{
			
		driver.close();
	}
}
