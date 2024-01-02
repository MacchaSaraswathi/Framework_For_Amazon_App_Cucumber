package com.simplilearn.bddtest.phase2_pp_amazon_cucumber.stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.protobuf.Duration;

public class Amazon3 {
	String driverPath ="drivers\\chromedriver.exe";
	String siteUrl = "https://www.amazon.in/";
	WebDriver driver;
	WebElement searchBox;
	@Given("^Open Chrome and Launch the amazon application$")
	public void open_chrome_and_launch_the_amazon_application() {
		System.setProperty("webdriver.chrome.driver", driverPath);
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(siteUrl);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}
	@When("^User on homepage$")
	public void user_on_homepage() {
	    assertEquals(siteUrl, driver.getCurrentUrl());
	}
	
	@Then("^check if cart is empty$")
	public void check_if_cart_is_empty() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[4]/div[1]/span[2]")).click();
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();
		assertNotEquals(actualTitle, expectedTitle);
	}

}



