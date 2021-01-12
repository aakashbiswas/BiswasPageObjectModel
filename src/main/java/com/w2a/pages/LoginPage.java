package com.w2a.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;

public class LoginPage extends Page {

	public LoginPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZohoApp doLogin(String username,String password) throws IOException
	{
		type("email_css", username);
        click("nextbutton_css");
		type("password_css", password);
		click("nextbutton1_xpath");
		
		return new ZohoApp();
	}
	public void gotoSalesandMarketing()
	{
		
	}
	public void goToFinance()
	{
		
	}
}
