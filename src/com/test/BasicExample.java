/**
 * This is the Basic example to open a browser, perform basic operation and close the browser
 */
package com.test;

/**
 * @author Ramesh
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasicExample {

	static WebDriver bDriver;


	public void openBrowser(String browserType, String url){

		String currentDir = System.getProperty("user.dir");

		if (browserType.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", currentDir+"\\drivers\\geckodriver.exe");
			bDriver = new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", currentDir+"\\drivers\\chromedriver.exe");
			bDriver = new ChromeDriver();
		}
		else if (browserType.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", currentDir+"\\drivers\\IEDriverserver.exe");
			bDriver = new InternetExplorerDriver();
		}
		else if (browserType.equalsIgnoreCase("htmlunitdriver")){
			bDriver = new HtmlUnitDriver();
		}


		if(url.isEmpty()){
			url = "about:blank";
		}

		bDriver.manage().window().maximize();
		bDriver.get(url);
	}

	public void closeBrowser(){
		if (bDriver != null){
			bDriver.close();
			bDriver.quit();
		}
	}

	public void testBrowser(){
		System.out.println("Current URL - " +bDriver.getCurrentUrl());
		System.out.println("Title URL - " +bDriver.getTitle());
	}

	public static void main(String[] args) {
		BasicExample driver = new BasicExample();
		driver.openBrowser("chrome", "https://www.facebook.com");
		driver.testBrowser();
		driver.closeBrowser();
	}
}

