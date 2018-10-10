package Radi_Assignment_TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	public WebDriver driver;
    public WebDriverWait wait;
    public static final String testDataExcelFileName = "/testdata.xlsx";
    public WebDriver getDriver() {
        return driver;
    }
    @BeforeClass (description = "Class Level Setup!")
    public void setup () {
    	
        //Create a Chrome driver. All test classes use this.
    		String exePath = "/Users/gopi/eclipse-workspace1/AssignmentLogin/src/test/drivers/chromedriver";
 	    System.setProperty("webdriver.chrome.driver", exePath);
    	  	driver = new ChromeDriver();
        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,15);
        //Maximize Window
        driver.manage().window().maximize();
    }

    @AfterClass(description = "Class Level Teardown!")
    public void teardown () {
        driver.quit();
    }

}

