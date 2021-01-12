package com.w2a.pages.crm.accounts;

import java.io.IOException;

import org.openqa.selenium.By;

import com.w2a.base.Page;

public class AccountsPage extends Page {
public AccountsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
public CreateAccountPage gotoCreateAccounts() throws IOException
{
	click("create_account_xpath");
	return new CreateAccountPage();
}
public void gotoImportAccounts()
{
	
}
}
