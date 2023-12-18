package com.stc.test_crew.driver;

import com.stc.test_crew.utils.read_properties.ReadProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;


public final class Driver {
     protected static final String remoteDriverHub="http://localhost:4444/wd/hub";

    static LoggingPreferences logPrefs = new LoggingPreferences();

    private Driver(){}
    public static void initDriver(String browserName,String linuxOrWindows) throws IOException {
        if (linuxOrWindows.equalsIgnoreCase("linux")) {
            if (isNull(DriverManager.getWebDriver())) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                        "enableVNC", true,
                        "enableVideo", true
                ));

                if (browserName.equalsIgnoreCase("chrome")) {
                    capabilities.setCapability("browserName", "chrome");
                    capabilities.setCapability("browserVersion", "98.0");
                    DriverManager.setWebDriver(new RemoteWebDriver(new URL(remoteDriverHub), capabilities));
                    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
                    DriverManager.getWebDriver().navigate().to(getUrl());
                } else if (browserName.equalsIgnoreCase("edge")) {
                    capabilities.setCapability("browserName", "MicrosoftEdge");
                    capabilities.setCapability("browserVersion", "98.0");
                    DriverManager.setWebDriver(new RemoteWebDriver(new URL(remoteDriverHub), capabilities));
                    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
                    DriverManager.getWebDriver().navigate().to(getUrl());
                } else if (browserName.equalsIgnoreCase("firefox")) {
                    capabilities.setCapability("browserName", "firefox");
                    capabilities.setCapability("browserVersion", "97.0");

                    DriverManager.setWebDriver(new RemoteWebDriver(new URL(remoteDriverHub), capabilities));
                    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
                    DriverManager.getWebDriver().navigate().to(getUrl());
                }
            }
        }
            else if (linuxOrWindows.equalsIgnoreCase("windows")) {
                if (isNull(DriverManager.getWebDriver())) {
                    if (browserName.equalsIgnoreCase("chrome")) {
                        DriverManager.setWebDriver(new ChromeDriver());
                        DriverManager.getWebDriver().navigate().to(getUrl());
                    } else if (browserName.equalsIgnoreCase("edge")) {
                        DriverManager.setWebDriver(new EdgeDriver());
                        DriverManager.getWebDriver().navigate().to(getUrl());
                    } else if (browserName.equalsIgnoreCase("firefox")) {
                        DriverManager.setWebDriver(new FirefoxDriver());
                        DriverManager.getWebDriver().navigate().to(getUrl());
                    }
                }
            }
        setMaximizeBrowser();
        }
    public static void closeDriver(){
        if(isNotNull(DriverManager.getWebDriver())){
            DriverManager.getWebDriver().quit();
            DriverManager.unLoad();
        }
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNotNull(Object object) {
        return object != null;
    }

    public static String getUrl() throws IOException {
            return ReadProperties.setStcConfig().getProperty("stcUrl");
    }

    public static void setMaximizeBrowser() {
        DriverManager.getWebDriver().manage().window().maximize();;
    }

    public static void clearBrowserCache() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getWebDriver();
        jsExecutor.executeScript("window.localStorage.clear();");
        jsExecutor.executeScript("window.sessionStorage.clear();");
        jsExecutor.executeScript("window.location.reload();");
    }
}
