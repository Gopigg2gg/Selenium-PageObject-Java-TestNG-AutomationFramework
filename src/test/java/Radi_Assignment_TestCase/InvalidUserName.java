package Radi_Assignment_TestCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import Radi_Assignment_Configuration.ReadTestData;
import Radi_Assignment_PageFactory.LoginPage;
import Radi_Assignment_PageFactory.MainPage;


public class InvalidUserName extends BaseTest{
	 @BeforeTest
	    public void setupTestData () throws Exception {
	        ReadTestData.setExcelFileSheet("LoginData");
	    }
	 @Test (priority = 0, description="Verify if user enter invalid text in the username field")
	    public void InvalidTextUsernameField () throws Exception{
	    		MainPage mainPage = new MainPage (driver,wait);
	    		LoginPage LoginPage = new LoginPage (driver,wait);
	        mainPage.OpenRadi();
	        mainPage.ClickLoginButton();
	        Thread.sleep(5000);
	        LoginPage.clickSubmit();
	        LoginPage.enterUsername(ReadTestData.getRowData(3));
  			Thread.sleep(500);
  			LoginPage.verifyLoginUserName(ReadTestData.getCellData(3,3));
  	        Thread.sleep(1000);
	    }
}


