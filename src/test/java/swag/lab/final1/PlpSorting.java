package swag.lab.final1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PlpSorting {
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
    public void PlpSorting() throws InterruptedException {

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
        //Get name of the first product
        String FirstProductName = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/div[1]")).getText();
        System.out.println(FirstProductName);
        //Click on filter button
        driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[2]/div[1]/span[1]/select[1]")).click();
       //Choose option to sort by Name(Z to A)
        driver.findElement(By.xpath("//option[contains(text(),'Name (Z to A)')]")).click();
        //Get name of the first product after sorting
        String FirstProductNameSorted = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/div[1]")).getText();
        System.out.println(FirstProductNameSorted);
        //Check that name of the first product in the list is different after sorting
        Assert.assertNotEquals(FirstProductName,FirstProductNameSorted);


    }
    @AfterTest
    public void endTest(){
        driver.quit();
    } }



