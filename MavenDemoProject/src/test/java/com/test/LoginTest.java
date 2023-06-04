package com.test;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.LoginPages;

public class LoginTest {
	
	WebDriver driver=null;
	LoginPages lp=null;
    DashBoardPage dp=null;
	
	@BeforeSuite
	public void setup() {// open a browser and launch appliation
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/DELL/Downloads/Salenium%20Software/Offline%20Website/index.html");
		
	}
		@Test
		public void test01() {
			
		lp = new LoginPages(driver);// login pages driver initialization
		dp=lp.validLogin();
		
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
		
		@Test
		public void test02() {
				ArrayList<String> expectedCourses= new ArrayList<String>();
				expectedCourses.add("Selenium");
				expectedCourses.add("Java / J2EE");
				expectedCourses.add("Python");
				expectedCourses.add("Php");
				
				ArrayList<String>actualCourses= dp.verifyCourses();
				Assert.assertEquals(actualCourses, expectedCourses);
		}
		
 }


