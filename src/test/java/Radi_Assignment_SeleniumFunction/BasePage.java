package Radi_Assignment_SeleniumFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
    public WebDriverWait wait;

    public  BasePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    
    //Use the click the element
    public void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }
    
    //Is used to enter the text
    public void enterText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }
    
    //get text from the login page 
    public String getText (By element) {
        return driver.findElement(element).getText();
    }
    
    //clear the field. 
    public void clear(By credentials) {
    		driver.findElement(credentials).clear();
    }
    

}