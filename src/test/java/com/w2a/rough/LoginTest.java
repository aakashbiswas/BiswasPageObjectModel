package com.w2a.rough;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.w2a.base.Page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoApp;
import com.w2a.pages.crm.CRMHomePage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountPage;

public class LoginTest {

	public static void main(String[] args) throws IOException {

		HomePage home = new HomePage();
		LoginPage login = home.goToLogin();
		ZohoApp zp = login.doLogin("labshastag@gmail.com", "dipanker@123");
		CRMHomePage cp = zp.gotoCRM();
		AccountsPage ap = Page.menu.gotoAccounts();
		CreateAccountPage ca = ap.gotoCreateAccounts();
		ca.createAccount("Raman");
	}

}
