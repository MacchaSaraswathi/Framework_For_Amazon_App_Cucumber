package com.simplilearn.bddtest.phase2_pp_amazon_cucumber.stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.Messages.Duration;

public class Amazon1_steps {
	String driverPath ="drivers\\chromedriver.exe";
	String siteUrl = "https://www.amazon.in/";
	WebDriver driver;
	
	@Given("Open the Chrome and Launch the amazon application")
	public void open_the_chrome_and_launch_the_amazon_application() {
		System.setProperty("webdriver.chrome.driver", driverPath);
	    driver = new ChromeDriver();
	    driver.get(siteUrl);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@When("User on amazon homepage")
	public void user_on_amazon_homepage() {
	    assertEquals(siteUrl, driver.getCurrentUrl());
	}

	@Then("Verify meta title of the page")
	public void verify_meta_title_of_the_page() {
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	}
	@When("Navigate user on dirrent link")
	public void navigate_user_on_dirrent_link() {
		 driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]")).click();
	}
	@Then("Verify meta title of the curent page")
	public void verify_meta_title_of_the_curent_page() {
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();
		assertNotEquals(actualTitle, expectedTitle);
	}

}

