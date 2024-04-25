package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.Actions;
import services.DriverInit;
import static services.DriverInit.driver;

public class BuildPage {
    public BuildPage() {
        WebDriver driver = DriverInit.getDriver();
    }
    public BuildPage clickConsoleOutputButton(){
        Actions.click(driver.findElement(By.xpath("//*[text()='Console Output']")));
        return new BuildPage();
    }
}
