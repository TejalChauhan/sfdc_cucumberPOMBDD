package com.SalesForce.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import com.SalesForceApp.pages.HomePages.HomePage;
import com.SalesForceApp.pages.LoginPages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceStepDefinition {
	WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
@Before
public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
}

@Given("user open Salesforce application")
public void user_open_salesforce_application() {
	driver.get("https://login.salesforce.com/");
   
}

@When("user on {string}")
public void user_on(String page) {
   if(page.equalsIgnoreCase("loginpage"))
	   loginP = new LoginPage(driver);
   else if(page.equalsIgnoreCase("homepage"))
	   homeP = new HomePage(driver);
       
}

@When("user enter value into text box username as {string}")
public void user_enter_value_into_text_box_username_as(String username) {
	loginP.setUsername(username);
	System.out.println("user entered username");
}

@When("user enter value into text box password as {string}")
public void user_enter_value_into_text_box_password_as(String password) {
    loginP.setPassword(password);
    System.out.println("user entered password");
}

@When("user click on login button")
public void user_click_on_login_button() {
    loginP.clickLoginButton();
    System.out.println("clicked login button");
}

@Then("verify the page title as {string}")
public void verify_the_page_title_as(String title) {
    Assert.assertTrue(homeP.waitUntilTitleContains(title));
    System.out.println("user is on home page");
}

@Then("verify the error message with the text {string}")
public void verify_the_error_message_with_the_text(String error) {
	String expectedError = "Please enter your password.";
	String actulError = loginP.getErrormsg();

	System.out.println("Expected error message: "+expectedError);
	Assert.assertEquals(actulError, expectedError);
}

@After
public void tearDown() {
	driver.quit();
}



}
