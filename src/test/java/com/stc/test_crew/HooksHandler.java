package com.stc.test_crew;

import com.stc.test_crew.browser.Browsers;
import com.stc.test_crew.driver.DriverManager;
import com.stc.test_crew.tests.BaseTest;
import com.stc.test_crew.utils.read_properties.ReadProperties;
import io.cucumber.java.After;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;

import static com.stc.test_crew.driver.Driver.*;

    public class HooksHandler extends BaseTest {
        public static String getBrowserName() throws IOException {
            return ReadProperties.setStcConfig().getProperty("browserName");
        }

        @BeforeTest(alwaysRun = true)
        @Parameters({"browserName","countryName","linuxOrWindows"})
        public void setUp(String browserName , String countryName,String linuxOrWindows) throws IOException {
            initDriver(browserName,linuxOrWindows);
            browser.set(new Browsers());
            browser.get().stc.stcHome.getHeader().clickOnCountryName().switchCountry(countryName);
        }
        public void clearCache(){
            clearBrowserCache();
        }
        @AfterTest(alwaysRun = true)
        public void close() throws IOException {
            captureScreenshotAndAttachToReport();
            clearCache();
            closeDriver();
        }

        private void captureScreenshotAndAttachToReport() throws IOException {
             java.io.File screenshot = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
             byte[] screenshotBytes = Files.readAllBytes(screenshot.toPath());
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshotBytes));
        }
}
