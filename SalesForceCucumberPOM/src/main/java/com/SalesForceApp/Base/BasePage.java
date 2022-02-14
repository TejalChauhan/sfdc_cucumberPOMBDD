package com.SalesForceApp.Base;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
		
	public BasePage(WebDriver driver1)
	{
		driver=driver1;
		PageFactory.initElements(driver1, this);
	}
	
	
	public static void launchApp(String url) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	
	
	
	public static void closeDriver()
	{
		driver.close();
	}
	public static void closeAllDriver()
	{
		driver.quit();
	}
	
	public static void enterText(WebElement element,String text)
	{
		if(element.isDisplayed())
		{
			element.clear();
			element.sendKeys(text);
			System.out.println("Pass : text entered");
		}
		else {
			System.out.println("Fail : Element not visible");
		}
	}
	
	public static void clickElelement(WebElement element)
	{
		if(element.isDisplayed())
		{
			element.click();
			System.out.println("Pass : button clicked");
		}
		else {
			System.out.println("Fail : clickElement not visible");
		}
	}
	
	public static void waituntilVisible(WebElement element)
	{
	    wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waituntilAlertPresent()
	{
	    wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void mouseOver(WebElement element)
	{
//		waituntilVisible(element);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public static void acceptAlert()
	{
		waituntilAlertPresent();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}
	public static void dissmisAlert() {
		waituntilAlertPresent();
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
		
	}
	public static void selectByTextData(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		
	}
	public static void selectByIndexData(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public static void selectByValueData(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}
	
	public static String getTitleOfThePage() {
		String title = driver.getTitle();
		return title;
	}
	
	public static void rightClickElement(WebElement element)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}
	public static void doubleClickElement(WebElement element)
	{
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	public static void drag_dropElement(WebElement sourceElement,WebElement targetElement)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement,targetElement);
	}
	
	public static void userDropDownMenu()
	{
		WebElement user_account = driver.findElement(By.id("userNavLabel"));
		waituntilVisible(user_account);
		mouseOver(user_account);
		WebElement arrowbutton = driver.findElement(By.id("userNav-arrow"));
		clickElelement(arrowbutton);
	}
	public void SwitchToFrame(WebElement e)
	{
		waituntilVisible(e);
		driver.switchTo().frame(e);
	}
	public void SwitchToContactInfoFrame(WebElement e) {
		waituntilVisible(e);
		
		driver.switchTo().frame("contactInfoContentId");
	}
	public void SwitchToframeByIndex(WebElement e) {
		waituntilVisible(e);
		driver.switchTo().frame(0);
	}
	public void SwitchToUploadphotoFrame(WebElement e) {
		waituntilVisible(e);
		
		driver.switchTo().frame("uploadPhotoContentId");
	}
	
	public void SwitchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	public String getCurrentWindow() {
		String currentWindow = driver.getWindowHandle();
		return currentWindow;
	}
    public void handleMultiWindow(String CurrentWindow) {
    	Set<String> windows = driver.getWindowHandles();
		 for(String windowHandle : windows)
		 {
			if(!windowHandle.equals(CurrentWindow))
			{
				driver.switchTo().window(windowHandle);
				break;
					
			}

		}
	}
    public void switchToCurrentWindow(String currentWindow) {
    	driver.switchTo().window(currentWindow);
    }
    public void closeNewWindow(String currentTab) {
    	Set<String> Tabs = driver.getWindowHandles();
		for(String TabHandle : Tabs)
		{
			if(!TabHandle.equals(currentTab))
			{
				driver.switchTo().window(TabHandle).close();
				break;
				
			}

	   	}
    }
    
    public boolean waitUntilTitleContains(String title) {
    	 wait = new WebDriverWait(driver,30);
    	 boolean titleflag = wait.until(ExpectedConditions.titleContains(title));
    	 return titleflag;
    			 
    	
    }
    public String getTextElement(WebElement e)
    {
    	return e.getText();
    }
    
	

}
