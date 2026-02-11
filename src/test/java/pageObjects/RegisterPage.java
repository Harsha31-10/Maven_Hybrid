package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BaseClass{
	
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath = "//i[@class='fa fa-user']")
	WebElement click_myaccount;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement click_register;
	
	@FindBy(id = "input-firstname")
	WebElement txtFirstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@type='tel']")
	WebElement txtPhone;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement txtPwd;
	
	@FindBy(xpath = "//input[@name='confirm']")
	WebElement txtConPwd;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement ckBox;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement confirmation;
	
	
	public void myaccount()
	{
		click_myaccount.click();
	}
	
	public void register()
	{
		click_register.click();
	}
	
	
	public void firstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void lastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void email(String mail)
	{
		txtEmail.sendKeys(mail);
	}
	
	public void phonenum(String num)
	{
		txtPhone.sendKeys(num);
	}
	
	public void password(String pwd)
	{
		txtPwd.sendKeys(pwd);
	}
	
	public void conPassword(String pwd)
	{
		txtConPwd.sendKeys(pwd);
	}
	
	public void checkbox()
	{
		ckBox.click();
	}
	
	public void bContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmation() {
		try {
			return(confirmation.getText());
		} catch(Exception e) {
			return(e.getMessage());
		}
	}
}
