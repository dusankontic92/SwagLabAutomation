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

public class CheckOut {
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
    public void CheckOut() throws InterruptedException {

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
        //Click on button "add to cart" to add Sauce Labs Backpack
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        //Verify that product appears in Cart
        driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]")).isDisplayed();
        //Check product name on PLP page
       String nameOfProductOnPlPage = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/div[1]")).getText();
       System.out.println(nameOfProductOnPlPage);
        //click on shopping cart
        driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]")).click();
        //Check product name on PDP page
        String nameOfProductOnPdPage = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/a[1]/div[1]")).getText();
        System.out.println(nameOfProductOnPdPage);
        //Check that name of product on PLP is the same as the name of product on PDP
        Assert.assertEquals(nameOfProductOnPdPage,nameOfProductOnPlPage);
        //Click on Checkout button
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        //Verify that ,,Checkout:Your information" appears
        driver.findElement(By.xpath("//span[contains(text(),'Checkout: Your Information')]")).isDisplayed();
        //Click on First name field
        driver.findElement(By.xpath("//input[@id='first-name']")).click();
        //Enter Valid First name
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Dusan");
        //Click on Last name field
        driver.findElement(By.xpath("//input[@id='last-name']")).click();
        //Enter Valid Last name
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Kontic");
        //Click on Zip/Postal code
        driver.findElement(By.xpath("//input[@id='postal-code']")).click();
        //Enter valid Zip/Postal code
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("11194");
        //Click on Continue button
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        //Verify that "Checkout:Overview" appears
        driver.findElement(By.xpath("//span[contains(text(),'Checkout: Overview')]")).isDisplayed();
        //Click on Finish button
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        Thread.sleep(3000);
        //Verify that "Checkout:Complete" appears
        driver.findElement(By.xpath("//span[contains(text(),'Checkout: Complete!')]")).isDisplayed();
        //Click on "Back to home" button
        driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
        //Verify that user is back to PLP page (Product appears)
        driver.findElement(By.xpath("//span[contains(text(),'Products')]")).isDisplayed();



    }
    @AfterTest
    public void endTest(){
        driver.quit();
    } }




