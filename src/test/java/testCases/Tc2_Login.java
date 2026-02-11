package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class Tc2_Login extends MainClass{
	
	@Test
	public void login() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.myaccount();
		
		lp.login();
		
		lp.email_add(pr.getProperty("email"));
		
		Thread.sleep(3000);
		
		lp.pwd_ent(pr.getProperty("password"));
		
		lp.submit();
		
		boolean target = lp.myAccount();
		
		if (target) {
		    Assert.assertTrue(true, "Login Successful");
		} else {
		    Assert.fail("Login failed due to invalid email or password.");
		}
		
		//Assert.assertEquals(target, true, "Email was incorrect");
		
	}
	
}
