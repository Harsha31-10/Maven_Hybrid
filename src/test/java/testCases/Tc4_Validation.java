package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class Tc4_Validation extends MainClass{
	
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
		
		List<String> actualCategories = lp.categories();

	    System.out.println("Categories on page: " + actualCategories);
	    
	    System.out.println(actualCategories.size());
	    
	    if (!actualCategories.isEmpty())
	    {
	        System.out.println("Categories are present on the page");
	    } else
	    {
	        System.out.println("Categories are not present on the page");
	    }
		
	}
	
}
