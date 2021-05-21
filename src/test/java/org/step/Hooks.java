package org.step;

import org.base.Base;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends Base {

	

	@Before
	public static void loadPage() {
		loadBrowser();
		loadUrl("https://www.facebook.com/");

	}

	@After
	public void closeBrowser() {
		close();

	}

}
