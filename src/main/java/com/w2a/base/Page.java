package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.Utilities;




public class Page {
public static WebDriver driver=null;
public static TopMenu menu;
public static Properties config = new Properties();
public static Properties OR = new Properties();
public static FileInputStream fis;
public static Logger log = Logger.getLogger("devpinoyLogger");
public static ExcelReader excel = new ExcelReader(
		System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\excel\\testdata.xlsx");
public static WebDriverWait wait;
public ExtentReports rep = ExtentManager.getInstance();
public static ExtentTest test;
public Page() throws IOException {
	// TODO Auto-generated constructor stub
	if(driver==null)
	{
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\properties\\Config.properties");
		config.load(fis);
		log.debug("config file loaded !!!");
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\properties\\OR.properties");
		OR.load(fis);
		log.debug("OR file loaded !!!");
		if (config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\\\Drivers\\\\Firefox\\\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (config.getProperty("browser").equals("chrome")) {
			/*
			 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
			 * + "\\src\\test\\resources\\executables\\chromedriver.exe");
			 */
			//WebDriverManager.chromedriver().setup();
			
			//log.debug("chrome launched");
		
	System.setProperty("webdriver.chrome.driver", 
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\executables\\chromedriver.exe");
	Map<String, Object> prefs = new HashMap<String, Object>();
	prefs.put("profile.default_content_setting_values.notifications", 2);
	prefs.put("credentials_enable_service", false);
	prefs.put("profile.password_manager_enabled", false);
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("prefs", prefs);
	options.addArguments("--disable-extensions");
	options.addArguments("--disable-infobars");
	driver=new ChromeDriver(options);
	log.debug("chrome launched");
		}
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to" + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitwaitmae")),
				TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		menu=new TopMenu(driver);
	
}
}
public static void click(String locator) {
	if (locator.endsWith("_css")) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
	} else if(locator.endsWith("_xpath")){
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
	}
	else
	{
		driver.findElement(By.id(OR.getProperty(locator))).click();
	}
	log.debug("Clicking on element: "+locator);
	test.log(LogStatus.INFO, "Clicking on:" + locator);
}

public static void type(String locator, String value) {
	if (locator.endsWith("_css")) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
	} else {
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
	}
	log.debug("Typing in as:" + locator + "entered value as:" + value);
	test.log(LogStatus.INFO, "Typing in as:" + locator + "entered value as:" + value);
}

public boolean isElementPresent(By by) {

	try {
		driver.findElement(by);
		return true;
	} catch (NoSuchElementException e) {
		// TODO: handle exception
		return false;
	}
}

static WebElement dropdown;

public void select(String locator, String value) {
	if (locator.endsWith("_css")) {
		dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
	} else {
		dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
	}
	Select select = new Select(dropdown);
	select.selectByVisibleText(value);
	test.log(LogStatus.INFO, "Selecting from dropdown:" + locator + "value as:" + value);
}

public static void verifyEquals(String expected, String actual) throws Throwable {
	try {
		Assert.assertEquals(actual, expected);
	} catch (Throwable t) {
		// TODO: handle exception
		Utilities.captureScreenshot();
		Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
		Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName
				+ " height=200 width=200></img></a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		// Extent Reports
		test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
		test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));
	}
}
public static void quit()
{
	driver.quit();
}
}
