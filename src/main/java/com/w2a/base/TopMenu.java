package com.w2a.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;
import com.w2a.pages.crm.accounts.AccountsPage;

public class TopMenu {
	
	WebDriver driver;
	public TopMenu(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void gotoHome() {

	}

	public void gotoFeeds() {

	}

	public void gotoLeads() {

	}

	public AccountsPage gotoAccounts() throws IOException {
       Page.click("accoun_xpath");
       return new AccountsPage();
	}

	public void gotoContacts() {

	}

	public void signOut() {

	}

}
