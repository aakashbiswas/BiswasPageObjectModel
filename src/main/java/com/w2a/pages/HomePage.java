package com.w2a.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;

public class HomePage extends Page {
	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void goToSignUp() {
		driver.findElement(By.cssSelector(".zh-signup")).click();
	}

	public LoginPage goToLogin() throws IOException {
		click("loginlink_css");
		return new LoginPage();
	}

	public void goToSupport() {

		driver.findElement(By.cssSelector(".zh-support")).click();
	}

	public void goToZohoEdu() {

	}

	public void learnMore() {

	}

	public void validateFooterLinks() {

	}

}
