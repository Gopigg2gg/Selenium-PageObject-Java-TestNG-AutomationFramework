package Radi_Assignment_TestCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import Radi_Assignment_Configuration.ReadTestData;
import Radi_Assignment_PageFactory.LoginPage;
import Radi_Assignment_PageFactory.MainPage;

public class EmptyPassword extends BaseTest{
	
	 @BeforeTest
	    public void setupTestData () throws Exception {
	        ReadTestData.setExcelFileSheet("LoginData");
	    }

	 @Test (priority = 0, description="Valid username and blank in the passwordfield")
	    public void EmptyPasswordField_ValidUsername() throws Exception{
   			MainPage mainPage = new MainPage (driver,wait);
   			LoginPage LoginPage = new LoginPage (driver,wait);
	        mainPage.OpenRadi();
	        mainPage.ClickLoginButton();
	        Thread.sleep(1000);
	        LoginPage.enterUserNamePassword(ReadTestData.getRowData(1));
	        Thread.sleep(1000);
	        LoginPage.verifyLoginPassword(ReadTestData.getCellData(1,4));
	        driver.quit();  
	    }
	 

}
