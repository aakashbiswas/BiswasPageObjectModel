package com.w2a.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;

public class ZohoApp extends Page {

	public ZohoApp() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void gotoChat() {

	}

	public  CRMHomePage gotoCRM() throws IOException {

		 click("doit_xpath");
		
		return new CRMHomePage();
	}

	public void gotoSalesIQ() {

	}
}
