package com.seleniumcpsatchallenge.qa.problemstatements;

import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import com.seleniumcpsatchallenge.qa.base.TestBase;
import com.seleniumcpsatchallenge.qa.pages.PremierLeaguePage;
import com.seleniumcpsatchallenge.qa.util.TestUtil;

public class ProblemStatementPremierLeague extends TestBase{

	PremierLeaguePage testPremierLeague;
	TestUtil testUtil;

	public ProblemStatementPremierLeague() {
		super();
	}

	@Before
	public void setUp() {
		//using FireFox 60.7.2esr (32-bit)
		// Pass the name of browser as argument in which you want to Execute script
		initialization("FireFox");
		testPremierLeague = new PremierLeaguePage();
		testUtil = new TestUtil();
		driver.get("https://www.premierleague.com/home");
		
	}

	@Test
	public void premierLeaguePageTest() throws InterruptedException {

		testPremierLeague.advertisementClose();
		testPremierLeague.acceptCookiesOnPremierLeaguePage();
		testPremierLeague.premierLeaguePageAction();
		
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindowID = it.next();
		String childWindowID = it.next();
		
		
		testUtil.switchToWindow(childWindowID);
		String officailWebsite = driver.findElement(By.xpath("//div[@class='website']//a")).getText();
		System.out.println("The official website URL on the page : " +officailWebsite);
		
		String titleOfNewlyOpenedWindow = driver.getTitle();
		System.out.println("The page title of the newly opened window : " +titleOfNewlyOpenedWindow);
		
		testUtil.switchToWindow(parentWindowID);
		String titleOfParentPage = driver.getTitle();
		System.out.println("The page title of the newly opened window : " +titleOfParentPage);
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
}
