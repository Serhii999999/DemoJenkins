package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.Actions;
import services.DriverInit;

import static services.DriverInit.driver;

public class ScreamingFrogPage {
    public ScreamingFrogPage(){
        WebDriver driver = DriverInit.getDriver();

    }
    public ScreamingFrogPage frogLink(){
        Actions.clickWithJS(driver.findElement(By.xpath("//span[text()='ScreamingFrog']")));
        return new ScreamingFrogPage();
    }
    public ScreamingFrogPage preprodLinkClick(){
        Actions.clickWithJS(driver.findElement(By.xpath("//td//span[text()='preprod']")));
        return new ScreamingFrogPage();
    }
    public ScreamingFrogPage prodLinkClick(){
        Actions.clickWithJS(driver.findElement(By.xpath("//td//span[text()='prod']")));
        return new ScreamingFrogPage();
    }

}
