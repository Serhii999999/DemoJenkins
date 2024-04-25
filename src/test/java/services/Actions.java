package services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static services.DriverInit.driver;

public class Actions {
    public static void open(String url){
        driver.navigate().to(url);
    }
    public static void click(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable
                (element));
        if(element.isDisplayed()){
            element.click();
        }
    }
    public static void clickWithJS(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    public static void navigateBack(){
        driver.navigate().back();
    }
    public static int retrieveNumberFromPage(String pattern){
        String desiredText = "";
        WebElement preElement = new WebDriverWait
                (driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("pre")));
        String preText = preElement.getText();
        Pattern patternMatch = Pattern.compile(pattern);
        Matcher matcher = patternMatch.matcher(preText);

        while (matcher.find()) {
            desiredText = matcher.group(1);
        }
        return Integer.parseInt(desiredText);
    }
    public static boolean areApproximatelyEqual(int val1, int val2, int threshold){
        int difference = Math.abs(val1-val2);
        return difference <= threshold;
    }
    }
