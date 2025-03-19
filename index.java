import org.example.Main;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class index {

    public static void main(String[] args){

    }
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void setup() {
        //Start Chrome web browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins");
        driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Maximum browser window
        driver.manage().window().maximize();
    }

    @Test
    public void web() {
        //Enter url into browser
        driver.get("file:\\C:\\Users\\ACER\\OneDrive\\Desktop\\Project\\index.html?/");

        String email = "";
        driver.findElement(By.className("email")).sendKeys("sew99.hansi@gmail.com");
        String password = "";
        driver.findElement(By.className("password")).sendKeys("00000000");

        //Get page title
        System.out.println("Get title " +driver.getTitle());

        //If check box is not selected, check it; if it is selected, ignore the operation
        if (!driver.findElement(By.className("checkbox")).isSelected())
        {
            driver.findElement(By.className("checkbox")).click();
        }
        else
        {
            System.out.println("The checkbox has been selected");
        }

        //Assert condition and if condition is true to do operation if button is button 1, click on it
        if (driver.findElement(By.id("btnLogin")).getAttribute("value").contains("Login"))
        {
            System.out.println("Could not find the button");
        }
        else
        {
            driver.findElement(By.id("btnLogin")).click();
            //driver.switchTo().alert().accept();

        }

        // Check if email or password is empty
        if (email.isEmpty() || password.isEmpty())
        {
            System.out.println("Email or password field is empty. Please fill in both fields.");
/*
            //Ensure the login button is disabled
            WebElement loginButton = driver.findElement(By.id("btnLogin"));
            if (!loginButton.isEnabled()) {
                System.out.println("Login button is disabled as expected.");
            } else {
                System.out.println("Error: Login button should be disabled.");
            }*/
        }
            else {
            System.out.println("Both email and password fields are filled.");

            WebElement loginButton = driver.findElement(By.id("btnlogin"));
            loginButton.click();
            wait.until(ExpectedConditions.urlToBe("file:\\C:\\Users\\ACER\\OneDrive\\Desktop\\Project\\home.html?/"));
/*
            //Find and click the login button if it is enabled
            WebElement loginButton = driver.findElement(By.id("btnLogin"));
            if (loginButton.isEnabled()) {
                loginButton.click();


                // Handle potential pop-up alert
                try {
                    Alert alert = driver.switchTo().alert();
                    System.out.println("Alert message: " + alert.getText());
                    alert.accept(); // Accept the alert
                } catch (NoAlertPresentException e) {
                    System.out.println("No alert present after clicking login.");
                }

            } else {
                System.out.println("Login button is disabled. Cannot proceed.");
            }*/
        }
/*
      //Selenium choose file to upload to application
      driver.findElement(By.id("file1")).sendKeys("");
      driver.findElement(By.id("file2")).sendKeys("");
*/
    }
    @After
    public void teardown() {
        //Close browser
        //driver.quit();
    }}





