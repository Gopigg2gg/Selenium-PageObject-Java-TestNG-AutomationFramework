package Radi_Assignment_TestCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import Radi_Assignment_PageFactory.MainPage;
import Radi_Assignment_PageFactory.LoginPage;
import Radi_Assignment_Configuration.ReadTestData;


public class EmptyUsernamePassword extends BaseTest{
	
	 @BeforeTest
	    public void setupTestData () throws Exception {
	        ReadTestData.setExcelFileSheet("LoginData");
	    }

	 @Test (priority = 0, description="")
	
	  	public void EmptyField () throws Exception{
	    		MainPage mainPage = new MainPage (driver,wait);
	    		LoginPage LoginPage = new LoginPage (driver,wait);
	        mainPage.OpenRadi();
	        mainPage.ClickLoginButton();
	        Thread.sleep(1000);
	        LoginPage.clickSubmit();
   			Thread.sleep(500);
   			LoginPage.verifyLoginUserName(ReadTestData.getCellData(2,3));
   	        Thread.sleep(1000);
   			LoginPage.verifyLoginPassword(ReadTestData.getCellData(2,4));
   			driver.quit();
	    }
}
