package com.Pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Page_Search 
{
	WebDriver driver;
	//Declaration of reference variable and locators
	By Search_word=By.id("hp_search");
	By click_go=By.xpath("//*[@id=\"main-search\"]/form/button");
	By vlc_link=By.xpath("//*[@id=\"wrapper\"]/div[2]/div[2]/div[3]/h4/a");
	By click_downloadnow=By.linkText("DOWNLOAD NOW");
	By external_mirror=By.xpath("//*[@id=\"dllinks\"]/div[3]/a");
	// code for lanuch the browser
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.softpedia.com/dyn-search.php?search_term");
	}
	//search for vlc media player using xpath
	public void Search()
	{
		driver.findElement(Search_word).sendKeys("vlc");
		
	}
	// code for click go button
	public void gobutton()
	{
		driver.findElement(click_go).click();
	}
	//code for download the media player using xpath
	public void download()
	{
		driver.findElement(vlc_link).click();
		driver.findElement(click_downloadnow).click();
		driver.findElement(external_mirror).click();
	}
	//code for check whether the file is exist or not using assert
	public void check_file() throws InterruptedException
	{
		File ff=new File("C:\\Users\\Admin\\Downloads\\vlc-3.0.8-win64(1)ss.exe");
		boolean bb=ff.exists();
		if(bb)
		{
			// file exist
			System.out.println("the file is exist");
			Assert.assertTrue(bb);
		}
		else
		{
			//file does not exist	
			System.out.println("the file does not exist");
			Assert.assertFalse(bb);
		}
		
		
	}
	//code for screenshot
	public  void takeSnapShot(String path) throws Exception
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(path);
        FileUtils.copyFile(SrcFile, DestFile);
	}
		
	// close the browser
	public void Quit()
	{
		driver.close();
	}
}

