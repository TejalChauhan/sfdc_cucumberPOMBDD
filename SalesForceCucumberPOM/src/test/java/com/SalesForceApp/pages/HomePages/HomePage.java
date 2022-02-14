package com.SalesForceApp.pages.HomePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SalesForceApp.Base.BasePage;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(id="userNavLabel") WebElement user_DashboardAccount;
	@FindBy(id="userNav-arrow") WebElement arrowbutton;
	@FindBy(linkText = "Logout") WebElement logout;
	@FindBy(xpath = "//li[@id='Account_Tab']/a") WebElement AccountTab;
	@FindBy(xpath = "//a[@title='Opportunities Tab']") WebElement OppertunityTab;
	@FindBy(id="tryLexDialogX") WebElement lightDialogue;
	@FindBy(xpath = "//a[@title='Leads Tab']") WebElement LeadsTab;
	@FindBy(xpath = "//li[@id='Contact_Tab']//a") WebElement ContactTab;
	@FindBy(xpath = "//a[@title='Home Tab']") WebElement HomeTab;
	
	
	public String getTitleOfHomePage() {
		String title = getTitleOfThePage();
		System.out.println("title of Page : "+title);
		return title;
	}
	public void logoutHomepage(){
		waituntilVisible(user_DashboardAccount);
		mouseOver(user_DashboardAccount);
		clickElelement(arrowbutton);
		waituntilVisible(logout);
		clickElelement(logout);
		
	}
	public void clickAccountTab() {
		waituntilVisible(AccountTab);
		clickElelement(AccountTab);
	}
	
	public void handleLightDialogue() {
		// TODO Auto-generated method stub
		if (lightDialogue.isDisplayed())
		{ 
			lightDialogue.click();
		}
	}
	public void clickOppertunityTab() {
		waituntilVisible(OppertunityTab);
		clickElelement(OppertunityTab);
	}
	public void clickLeadTab() {
		waituntilVisible(LeadsTab);
		clickElelement(LeadsTab);
	}
	public void clickContactTab() {
		waituntilVisible(ContactTab);
		clickElelement(ContactTab);
	}
	public void clickHomeTab() {
		
		waituntilVisible(HomeTab);
		mouseOver(HomeTab);
		clickElelement(HomeTab);
	}
	
	

}
