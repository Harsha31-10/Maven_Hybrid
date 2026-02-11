package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.RegisterPage;
public class Tc1_Registration extends MainClass {
	
	@SuppressWarnings("deprecation")

	/*
	 * Random ran=new Random(); int rann=ran.nextInt(100);
	 */
	
	String randomText = RandomStringUtils.randomAlphabetic(5);
	

	@SuppressWarnings("deprecation")
	String random = RandomStringUtils.randomAlphanumeric(6);

	@Test
    public void registration() {
		
        
        RegisterPage rPage = new RegisterPage(driver);
        
        rPage.myaccount();
        
        rPage.register();
        
        rPage.firstName("Joy");
        
        rPage.lastName("Roy");
        
        rPage.email("joyroy456"+randomText+"@gmail.com");
        
        try {
        	Thread.sleep(3000);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        rPage.phonenum("5432167891");
        
        rPage.password("Joy123@123");
        
        rPage.conPassword("Joy123@123");
        
        rPage.checkbox();
        
        rPage.bContinue();
        
        String conf = rPage.getConfirmation();
        
        Assert.assertEquals(conf, "Your Account Has Been Created!");
    }
	
	

}
