package Radi_Assignment_PageFactory;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Radi_Assignment_SeleniumFunction.BasePage;
import junit.framework.Assert;

public class LoginPage extends BasePage{
	
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    //Entering the Xpath for LoginPage
    String usename = "//input[@placeholder='Email']";
    String password = "//input[@placeholder = 'Password']";
    String loginSubmitButton = "//button[@type = 'submit']";
    String usernameErrorMessage = "//input[@type ='email']/following-sibling::small";
    String passwordErrorMessage = "//small[text() = 'Password is required.']";
    String InvalidUserName = "//h4[@class ='title')]";
    String LoginUserName	= "//span[text () = 'Gopinath Angusamy']";

    //Enter the username and password
    public void enterUserNamePassword (XSSFRow row) throws InterruptedException{
    		enterText(By.xpath(usename),row.getCell(1).toString());
        Thread.sleep(1000);
        enterText(By.xpath(password), row.getCell(2).toString());
        click(By.xpath(loginSubmitButton));
    }
    
    //Click submit login button in the login page
    public void clickSubmit ()throws InterruptedException{
        click(By.xpath(loginSubmitButton));
        Thread.sleep(1000);
    }
    
    //Enter the username	in the login page
    public void enterUsername (XSSFRow row) throws InterruptedException{
    		enterText(By.xpath(usename),row.getCell(1).toString());
        Thread.sleep(1000);
    }
    
    //Clear the username field inthe login page
    public void clearText () throws InterruptedException{
        Thread.sleep(1000);
    		clear(By.xpath(usename));  
    		
    }

    //verify if user gives blank or invalid password.
    public void verifyLoginUserName (String expectedUserNameMessage) {
        Assert.assertEquals(getText(By.xpath(usernameErrorMessage)), expectedUserNameMessage);
    }

    //verify error message if there is null value in password field
    public void verifyLoginPassword (String expectedPasswordMessage) {
        Assert.assertEquals(getText(By.xpath(passwordErrorMessage)), expectedPasswordMessage);
    }
    
    //verify the notification popup if user gives the invalid username. 
    public void invalidLoginUsername (String expectedPasswordMessage) {
    		WebDriverWait wait = new WebDriverWait(driver, 15);
    		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Email not found"))).getText();
		Assert.assertEquals(getText(By.xpath(InvalidUserName)), expectedPasswordMessage);
}
    //verify the succesfull login page with user name. 
    public void SuccessLoginPage (String expectedPasswordMessage) {
		Assert.assertEquals(getText(By.xpath(LoginUserName)), expectedPasswordMessage);
}
   
}

