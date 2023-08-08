import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class firstSeleniumAutomationTest {

    public static void main (String [] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,250)");
        WebElement elementsButton = driver.findElement(By.xpath("//h5[normalize-space()='Elements']"));
        elementsButton.click();
        WebElement  webTablesButton = driver.findElement(By.xpath("//span[normalize-space()='Web Tables']"));
        webTablesButton.click();
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();
        WebElement firstName = driver.findElement(By.cssSelector(".mr-sm-2[placeholder=\"First Name\"]"));
        firstName.click();
        firstName.sendKeys("Hakan");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.click();
        lastName.sendKeys("Demir");
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.click();
        email.sendKeys("hkn-demir@hotmail.com");
        WebElement age = driver.findElement(By.xpath("//input[@id='age']"));
        age.click();
        age.sendKeys("34");
        WebElement salary = driver.findElement(By.xpath("//input[@id='salary']"));
        salary.click();
        salary.sendKeys("2000");
        WebElement department = driver.findElement(By.xpath("//input[@id='department']"));
        department.click();
        department.sendKeys("Information Technology");
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.quit();


    }
}
