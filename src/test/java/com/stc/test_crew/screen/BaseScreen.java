package com.stc.test_crew.screen;


import com.stc.test_crew.driver.DriverManager;
import com.stc.test_crew.utils.waits.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class BaseScreen extends WaitUtils {

    JavascriptExecutor executor;
    public String getElementText(By by){
        return waitUntilElementIsPresence(by).getText();
    }

    public String getCurrentUrl(){
        return DriverManager.getWebDriver().getCurrentUrl();
    }
    public void back() {
        DriverManager.getWebDriver().navigate().back();
    }

    public String getAlertMessage(){
        waitUntilAlertIsPresence();
        return DriverManager.getWebDriver().switchTo().alert().getText();
    }

    public void clickOnOkInAlert(){
        DriverManager.getWebDriver().switchTo().alert().accept();
    }

    public void clickOnElementUsingJS(WebElement link){
        executor = (JavascriptExecutor) DriverManager.getWebDriver();
        executor.executeScript("arguments[0].click();", link);
    }
}
