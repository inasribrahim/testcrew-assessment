package com.stc.test_crew.screen.headers;

import com.stc.test_crew.screen.BaseScreen;
import org.openqa.selenium.By;

public class CountryType  extends BaseScreen {
    private final By countryBahrain = By.id("bh-contry-flag");
    private final By countrySaudiArabia = By.id("sa-contry-flag");
    private final By countryKuwait = By.id("kw-contry-flag");
    public void switchCountry(String countryName) {
        countryName = countryName.toLowerCase();
        switch (countryName) {
            case "bahrain":
                selectYourCountry(countryBahrain);
                break;
            case "saudiarabia":
                selectYourCountry(countrySaudiArabia);
                break;
            case "kuwait":
                selectYourCountry(countryKuwait);
                break;
            default:
                throw new IllegalArgumentException("Invalid country name: " + countryName);
        }
    }

    private void selectYourCountry(By by) {
        waitUntilElementUntilIsClickable(by).click();
    }
}