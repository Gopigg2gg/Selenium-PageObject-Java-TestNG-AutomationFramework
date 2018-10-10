package Radi_Assignment_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Radi_Assignment_Configuration.ReadProperties;
import Radi_Assignment_SeleniumFunction.BasePage;

public class MainPage extends BasePage	{
	public MainPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
//    String URL = "https://radiusagent.com/";
	//Setting up the properties file for geting URL form the config properties file.
	String URL = ReadProperties.getInstance().getURL();
    String signInButtonClass = "//div[@id='__next']/div/div/div[2]/a[3]";

    //Open the Radius Agent page
    public void OpenRadi(){
        driver.get(URL);
    }
    
    //Click the Login button
    public void ClickLoginButton (){
        click(By.xpath(signInButtonClass));
    }

}
