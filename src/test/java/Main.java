import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize(); // tam ekran icin

        driver.get("https://www.google.com"); // acmak istedigin sayfayi acar
      try{
          Thread.sleep(5000);
      } catch (InterruptedException e){
          throw new RuntimeException(e);
      }
                                            // try dan baslayip throw new in bitimine kadar olan kisim acilan sayfada beklemek icin
        driver.quit();  // tamamen kapatir
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //sayfanin acilmasini beklemesi icin
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); // sayfa uzerinde yapilan islemi beklemesi icin


        // window komutlari
        driver.manage().window().maximize(); // pencereyi tam ekran yapar
        int x = driver.manage().window().getPosition().getX(); // pencerenin x duzlemindeki konumunu verir
        int y = driver.manage().window().getPosition().getX(); // pencerenin y duzlemindeki konumunu verir

        // url kismi

        driver.get("https://www.google.com"); //siteye gitmek icin kullanilir
        String CurrentURL = driver.getCurrentUrl();  //sayfadaki urli getirir
        String Title = driver.getTitle(); // Sayfanin titleini getirir
        String PageSource = driver.getPageSource(); // sayfanin kaynak kodlarini getirir

        // navigate sitenin icindeki butonlar

        driver.navigate().back(); // bir onceki sayfaya geri gider
        driver.navigate().forward(); // bir ileri sayfaya gider
        driver.navigate().refresh(); //

        //eleman alma
        WebElement fullName = driver.findElement(By.id("userName"));  // test yapilan sitede sag tiklayip incele yaptiktan sonr gelen yerde id den cekilir
        fullName.click();
        fullName.sendKeys("Hakan Demir");
        WebElement element2 = driver.findElement(By.cssSelector(".mr-sm-2[placeholder=\"name@example.com\"]"));  // test yapilan sitede sag tiklayip incele yaptiktan sonr gelen yerde classin icindeki yerden cekilir
        WebElement element3 = driver.findElement(By.xpath("//textarea[@id=\"permanentAddress\"]")); // bunun yapisi //tagname[@Attribute='Values']
        WebElement element4 = driver.findElement(By.name(""));
        WebElement element5 = driver.findElement(By.linkText(""));
        WebElement element6 = driver.findElement(By.className(""));

        element6.click(); // sectigin elemana tiklama
        element5.sendKeys("merhaba ben hakan"); // sectigin elemana yazi yazdirma

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,450)");   // bu iki satir sayfayi assagi cekmeyi saglar 0,450 kismi ise ne kadar assagi inecek onu ayarlar


    }
}