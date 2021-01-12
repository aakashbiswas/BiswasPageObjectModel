package com.w2a.pages.crm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.w2a.base.Page;

public class CRMHomePage extends Page {

	public CRMHomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public void verifyNoActivityFound()
	{
		WebElement ew=driver.findElement(By.xpath("//h4[normalize-space()='No Activities found']"));
		if(ew.isDisplayed())
		{
			System.out.println();
		}
	}
	public void verifyTextCrmHome()
	{
		WebElement re = driver.findElement(By.xpath("//h4[text()='No Deals found']"));
	}
}
