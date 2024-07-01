package swag.lab.final1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidLogOut {
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
    public void ValidLogOut() throws InterruptedException {

        driver.get(baseURL);
        //Click on username field
        driver.findElement(By.id("user-name")).click();
        //Enter valid username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Click on password field
        driver.findElement(By.id("password")).click();
        //Enter valid password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Click on log in button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify that "Products" on header on PLP appears
        driver.findElement(By.xpath("//span[contains(text(),'Products')]")).isDisplayed();
        //Click on Hamburger Menu
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        //Click on logout button
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
        //Verify that we are on the Log in page
        driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).isDisplayed();


    }
    @AfterTest
    public void endTest(){
        driver.quit();
    } }




