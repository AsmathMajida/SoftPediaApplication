package com.StepDefinition;

import com.Pages.Page_Login;
import com.Pages.Page_Register;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Definition_Login 
{
	Page_Login pl=new Page_Login();
	
	@Given("^The user launch the application$")
	public void the_user_launch_the_application() 
	{
		pl.LaunchBrowser();
	}
	@Then("^clicking on the user icon and enter username and password$")
	public void clicking_on_the_user_icon_and_enter_username_and_password()
	{
		pl.icon_credential();
	}

	@Then("^clicking on the login button$")
	public void clicking_on_the_login_button() throws InterruptedException  
	{
		pl.login_button();
		Thread.sleep(3000);
		pl.Quit();
	}
}
