package services;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DriverInit {
   public static WebDriver driver;
    public static WebDriver getDriver(){
        if(driver==null){
            driver = new ChromeDriver();
        }
        return driver;
    }
}
