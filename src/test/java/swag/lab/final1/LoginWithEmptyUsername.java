package swag.lab.final1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginWithEmptyUsername {

    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;


    @BeforeTest
    public void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait= new WebDriverWait(driver,Duration.ofSeconds(15));
        baseURL="https://www.saucedemo.com/";


    }
    @Test
    public void LoginWithEmptyUsername() throws InterruptedException {

        driver.get(baseURL);
        //Click on username field
        driver.findElement(By.id("user-name")).click();
        //Click on password field
        driver.findElement(By.id("password")).click();
        //Enter valid password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on log in button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify that message "Epic sadface: Username is required appears:
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")).isDisplayed();

    }
    @AfterTest
    public void endTest(){
        driver.quit();
    }
}
