package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.DataProviders;

public class Tc3_LoginDDT extends MainClass {

	@Test(dataProvider = "Login", dataProviderClass = DataProviders.class)
	public void loginDDT(String email, String pwd, String exp) {
		try {
			LoginPage lp = new LoginPage(driver);

			lp.myaccount();

			lp.login();

			lp.email_add(email);

			lp.pwd_ent(pwd);

			lp.submit();

			boolean target = lp.myAccount();

			if (exp.equalsIgnoreCase("Valid")) {

				Assert.assertTrue(target, "Expected login success but it failed");

				lp.logout(); // logout only when login is successful
			} else if (exp.equalsIgnoreCase("Invalid")) {

				Assert.assertFalse(target, "Expected login failure but it passed");
			}

			/*
			 * if(exp.equalsIgnoreCase("Valid")) { if(target == true) // Login success -
			 * Pass { lp.logout(); Assert.assertTrue(true); } else // Login fail - fail {
			 * Assert.assertTrue(false); } }
			 * 
			 * if(exp.equalsIgnoreCase("Invalid")) { if(target == true) // Login success -
			 * Fail { lp.logout(); Assert.assertTrue(false); }
			 * 
			 * else // Login fail - Pass { Assert.assertTrue(true); } }
			 */

		} catch (Exception e) {
			Assert.fail("Exception occurred during login validation:");
		}
	}

}



// http://192.168.0.123:4444
