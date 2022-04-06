package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegidtration extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void test_account_Registration() {
		
		logger.info("Started TC_001_AccountRegidtration ");
		
		try {
		driver.get(rb.getString("appURL"));
		logger.info("Opened URL ");
		driver.manage().window().maximize();
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Opened ClickMyAccount");
		hp.clickRegister();
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName("Jhon");
		regpage.setLastName("Canedy");
		regpage.setEmail(randomestring()+"@gamil.com");
		logger.info("Sent Gmail");
		regpage.setTelephone("65656565");
		regpage.setPassword("abcdefhg");
		regpage.setConfirmPassword("abcdefhg");
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Your Account is created ");
			Assert.assertTrue(true);
			
		}
		else
		{
			logger.info("Your Account creation failed ");
			captureScreen(driver, "test_accout_Registration"); //Capturing screenshot
			Assert.assertTrue(false);
		}	
		
	}
		catch(Exception e) {
			Assert.fail();
			logger.info("Failed testcase");
		}
		
		logger.info("Test case finished ...... ");
}

}
