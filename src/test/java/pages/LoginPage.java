package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import services.DriverInit;

import static services.DriverInit.driver;

public class LoginPage {
    public LoginPage(){
        WebDriver driver = DriverInit.getDriver();
    }
    public void logInSystem(String login, String password) {
        driver.findElement(By.id("j_username")).sendKeys(login);
        driver.findElement(By.id("j_password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@name='Submit']")).click();
    }
}
