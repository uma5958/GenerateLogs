package com.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;	

public class LoginTest {
	//What is log? : capturing info/activities at the time of program execution. 
	// types of logs:
		//1. info
		//2. warn
		//3. debug
		//4. fatal
		
	//how to generate the logs? : use Apache log4j API (log4j jar)
	//How it works? : it reads log 4j configuration from log4j.properties file
	//where to create: create inside resources folder
	
	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);
	
	
	@BeforeMethod
	public void setup(){
		log.info("****************************** Starting test cases execution  *****************************************");

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");	
		driver = new ChromeDriver(); 
		log.info("launching chrome broswer");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	
	
	@Test(priority=1)
	public void titleTest(){
		log.info("****************************** starting title test case *****************************************");
		String title = driver.getTitle();
		System.out.println(title);
		log.info("login page title is--->"+title);
		log.info("****************************** ending title test case *****************************************");

	}
	
	@Test(priority=2)
	public void urlTest(){
		log.info("****************************** starting url test case *****************************************");
		String url = driver.getCurrentUrl();
		System.out.println(url);
		log.info("login page title is--->"+url);
		log.info("****************************** ending url test case *****************************************");
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");
	}
	
	
	
	
	
	
	
	
}
