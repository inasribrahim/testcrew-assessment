package com.stc.test_crew.screen;

import org.openqa.selenium.By;

public class ChooseYourPlanSection extends BaseScreen {
    private final By classicType = By.xpath("//strong[@id='name-الأساسية' or @id='name-classic']");
    private final By liteType = By.xpath("//strong[@id='name-لايت' or @id='name-lite']");
    private final By premiumType = By.xpath("//strong[@id='name-بريميوم' or @id='name-premium']");
    private final By liteCurrency = By.xpath("//*[@id='currency-lite' or @id='currency-لايت']");
    private final By classicCurrency = By.xpath("//*[@id='currency-classic' or @id='currency-الأساسية']");
    private final By premiumCurrency = By.xpath("//*[@id='currency-premium' or @id='currency-بريميوم']");


    public String getClassicPackage() {
        return getElementText(classicType);
    }

    public String getLitePackage() {
        return getElementText(liteType);
    }

    public String getPremiumPackage() {
        return getElementText(premiumType);
    }

    public String getLiteCurrency(String language) {
        if(language.equals("العربية")) {
            String[] parts = waitUntilElementUntilIsVisible(liteCurrency).getText().split(" ")  ;
            return parts[1] + " " +parts[2].split("/")[0];
        }
        else return waitUntilElementUntilIsVisible(liteCurrency).getText().split("/")[0].split(" ")[1];
    }

    public String getClassicCurrency(String language) {
        if(language.equals("العربية")) {
            String[] parts = waitUntilElementUntilIsVisible(classicCurrency).getText().split(" ");
            return parts[1] + " " +parts[2].split("/")[0];
        }
        else return waitUntilElementUntilIsVisible(classicCurrency).getText().split("/")[0].split(" ")[1];
    }

    public String getPremiumCurrency(String language) {
        if(language.equals("العربية")) {
            String[] parts = waitUntilElementUntilIsVisible(premiumCurrency).getText().split(" ");
            return parts[1] + " " +parts[2].split("/")[0];
        }
        return waitUntilElementUntilIsVisible(premiumCurrency).getText().split("/")[0].split(" ")[1];
    }

    public String getLiteTimePeriod (String language) {
        if(language.equals("العربية")) return waitUntilElementUntilIsVisible(liteCurrency).getText().split("/")[1];
        else return waitUntilElementUntilIsVisible(liteCurrency).getText().split("/")[1];
    }

    public String getClassicTimePeriod (String language) {
        if(language.equals("العربية")) return waitUntilElementUntilIsVisible(classicCurrency).getText().split("/")[1];
        else return waitUntilElementUntilIsVisible(classicCurrency).getText().split("/")[1];
    }

    public String getPremiumTimePeriod (String language) {
        if(language.equals("العربية")) return waitUntilElementUntilIsVisible(premiumCurrency).getText().split("/")[1];;
        return waitUntilElementUntilIsVisible(premiumCurrency).getText().split("/")[1];
    }

    public String getLiteFees(String language) {
        if(language.equals("العربية")) return waitUntilElementUntilIsVisible(liteCurrency).getText().split("\\s+")[0];
        else return waitUntilElementUntilIsVisible(liteCurrency).getText().split("/")[0].split(" ")[0];
    }

    public String getClassicFees(String language) {
        if(language.equals("العربية")) return waitUntilElementUntilIsVisible(classicCurrency).getText().split("\\s+")[0];
        else return waitUntilElementUntilIsVisible(classicCurrency).getText().split("/")[0].split(" ")[0];
    }

    public String getPremiumFees(String language) {
        if(language.equals("العربية")) return waitUntilElementUntilIsVisible(premiumCurrency).getText().split("\\s+")[0];
        return waitUntilElementUntilIsVisible(premiumCurrency).getText().split("/")[0].split(" ")[0];
    }

    public String getPackageType(String pacakageType) {
        pacakageType = pacakageType.toLowerCase();
        switch (pacakageType) {
            case "lite":
            case "لايت":
                return getLitePackage();
            case "classic":
            case "الأساسية":
                return getClassicPackage();
            case "premium":
            case "بريميوم":
                return getPremiumPackage();
            default:
                throw new IllegalArgumentException("Invalid package name: " + pacakageType);
        }
    }

    public String getFeesPackage(String pacakageType,String lan) {
        pacakageType = pacakageType.toLowerCase();
        switch (pacakageType) {
            case "lite":
            case "لايت":
                return getLiteFees(lan);
            case "classic":
            case "الأساسية":
                return getClassicFees(lan);
            case "premium":
            case "بريميوم":
                return getPremiumFees(lan);
            default:
                throw new IllegalArgumentException("Invalid package name: " + pacakageType);
        }
    }

    public String getCurrencyPackage(String pacakageType,String lan) {
        pacakageType = pacakageType.toLowerCase();
        switch (pacakageType) {
            case "lite":
            case "لايت":
                return getLiteCurrency(lan);
            case "classic":
            case "الأساسية":
                return getClassicCurrency(lan);
            case "premium":
            case "بريميوم":
                return getPremiumCurrency(lan);
            default:
                throw new IllegalArgumentException("Invalid country name: " + pacakageType);
        }
    }
    public String getCurrencyTimePeriod(String pacakageType,String lan) {
        pacakageType = pacakageType.toLowerCase();
        System.out.println(pacakageType);
        switch (pacakageType) {
            case "lite":
            case "لايت":
                return getLiteTimePeriod(lan);
            case "classic":
            case "الأساسية":
                return getClassicTimePeriod(lan);
            case "premium":
            case "بريميوم":
                return getPremiumTimePeriod(lan);
            default:
                throw new IllegalArgumentException("Invalid country name: " + pacakageType);
        }
    }
}