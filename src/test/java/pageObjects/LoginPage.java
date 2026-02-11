package pageObjects;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseClass{
	

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	

	@FindBy(xpath = "//i[@class='fa fa-user']")
	WebElement click_myaccount;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement click_login;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement click_submit;
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement ck_msg;
	
	@FindBy(xpath = "(//a[text()='Logout'])[2]")
	WebElement click_logout;
	
	@FindBy(xpath = "(//div[@class='container'])[3]/nav/div[2]/ul/li")
	List<WebElement> valid_categories;
	
	
	public void myaccount()
	{
		click_myaccount.click();
	}
	
	public void login()
	{
		click_login.click();
	}
	
	public void email_add(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void pwd_ent(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void submit()
	{
		click_submit.click();
	}
	
	public boolean myAccount()
	{
		try {
			return(ck_msg.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void logout()
	{
		click_logout.click();
	}
	
	public List<String> categories()
	{
		List<String> names = new ArrayList<>();
		
		for(WebElement list : valid_categories)
		{
			//System.out.println(list.getText());
			names.add(list.getText().trim());
			

		}
		return names;
	} 
	
	/*
	 * public int getCategoryCount() { return valid_categories.size(); }
	 * 
	 * 
	 * public boolean categoriesDisplay() { for(WebElement list : valid_categories)
	 * { if(!list.isDisplayed()) { return false; } } return true; }
	 */
		
	/*public List<String> categories()
	{
		List<String> names = new ArrayList<>();
		
		for(WebElement list : valid_categories)
		{
			//String cat_list = list.getText();
			System.out.println(list.getText());
		}
		return names;
	} */

}
