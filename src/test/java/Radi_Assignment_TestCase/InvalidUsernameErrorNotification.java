package Radi_Assignment_TestCase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Radi_Assignment_Configuration.ReadTestData;
import Radi_Assignment_PageFactory.LoginPage;
import Radi_Assignment_PageFactory.MainPage;

public class InvalidUsernameErrorNotification extends BaseTest{
	
	 @BeforeTest
	    public void setupTestData () throws Exception {
	        ReadTestData.setExcelFileSheet("LoginData");
	    }

	 @Test (priority = 0, description="Enter valid Username and Password and verify success full login")
	
	    public void ValidLoginTest_ValidUserNameValidPassword () throws Exception{
   			MainPage mainPage = new MainPage (driver,wait);
   			LoginPage LoginPage = new LoginPage (driver,wait);
	        mainPage.OpenRadi();
	        Thread.sleep(1000); 
	        mainPage.ClickLoginButton();
	        Thread.sleep(5000); 
	        LoginPage.enterUserNamePassword(ReadTestData.getRowData(4));
	        Thread.sleep(5000); 
	        LoginPage.invalidLoginUsername(ReadTestData.getCellData(4,3));
	        System.out.println(ReadTestData.getCellData(4,3));
	        driver.close();
	    }
	 

}
