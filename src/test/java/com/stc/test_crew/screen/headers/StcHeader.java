package com.stc.test_crew.screen.headers;

import com.stc.test_crew.driver.DriverManager;
import com.stc.test_crew.screen.BaseScreen;
import org.openqa.selenium.By;

public class StcHeader extends BaseScreen {
    SignInPage signUpPage;
    CountryType countryType;
    private final By countryNameField = By.id("country");
    private final By signInField = By.id("signin");
    private final By languageField = By.id("translation-btn");

    public CountryType clickOnCountryName(){
        waitUntilElementUntilIsClickable(countryNameField).click();
        return new CountryType();
    }

    public SignInPage clickOnSignIn(){
        waitUntilElementUntilIsClickable(signInField).click();
        return new SignInPage();
    }
    public void clickOnLanguage(String language) throws InterruptedException {
       Thread.sleep(10000);
       String dynamicXpath = "//*[@id='translation-btn' and contains(.,'"+language+"')]";
        clickOnElementUsingJS(DriverManager.getWebDriver().findElement(By.xpath(dynamicXpath)));
    }
    public SignInPage getSignUpPage() {
        return signUpPage;
    }

}
