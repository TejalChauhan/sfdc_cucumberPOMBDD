package com.SalesForceApp.pages.LoginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.SalesForceApp.Base.BasePage;

public class ForgotPassword extends BasePage {
	
	public ForgotPassword(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(id="forgot_password_link") WebElement forgotpassword;
	@FindBy(id="continue") WebElement continue_btn;
	@FindBy(id="un") WebElement userId_forgotpassword;
	
	public void clickForgotPassword()
	{
		waituntilVisible(forgotpassword);
		clickElelement(forgotpassword);
	}
	public void setUserId_ForgotPassword()
	{
		waituntilVisible(userId_forgotpassword);
		enterText(userId_forgotpassword, "");
	}
	public void clickContinueButton()
	{
		clickElelement(continue_btn);
	}
	public String getTitleOfForgotPasswordPage() {
		String title = getTitleOfThePage();
		return title;
	}

}
