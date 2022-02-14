package com.SalesForceApp.pages.LoginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.SalesForceApp.Base.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(id="username") WebElement username_App;
	@FindBy(id="password") WebElement password_account;
	@FindBy(id="Login") WebElement login_btn;
	@FindBy(id="error") WebElement errormsg;
	@FindBy(id="rememberUn") WebElement rememberMe;
	@FindBy(xpath = "//span[@id='idcard-identity']") WebElement rememberedUserid;
	
	
	public void setUsername(String usrName)
	{
		enterText(username_App, usrName);
	}
	public void setPassword(String passwrd)
	{
		enterText(password_account, passwrd);
	}
	public void clickLoginButton()
	{
		waituntilVisible(login_btn);
		clickElelement(login_btn);
	}
	public String getErrormsg()
	{
		waituntilVisible(errormsg);
		return errormsg.getText();
	}
	public void clickRememberMe()
	{
		waituntilVisible(rememberMe);
		clickElelement(rememberMe);
	}
	public String getRemembedUserId()
	{
		waituntilVisible(rememberedUserid);
		return rememberedUserid.getText();
	}
	public String getTitleOfLoginPage() {
		String title = getTitleOfThePage();
		return title;
	}
	
	
	
	
	
	
	

}
