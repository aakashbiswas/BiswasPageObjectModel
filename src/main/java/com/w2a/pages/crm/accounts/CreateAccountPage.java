package com.w2a.pages.crm.accounts;

import java.io.IOException;

import org.openqa.selenium.By;

import com.w2a.base.Page;

public class CreateAccountPage extends Page {

	public CreateAccountPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void createAccount(String account_name)
	{
		type("name_css", account_name);
	}
}
