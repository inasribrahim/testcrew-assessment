package com.stc.test_crew.tests.saudi_arabia;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stc.test_crew.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class StcSaudiPackageTest extends BaseTest {
    private static final String JSON_FILE_NAME = "saudiData.json";
    private static final String JSON_SUBDIRECTORY = "saudi_arabia";
    private static final String JSON_FILE_PATH = System.getProperty("user.dir") + File.separator +
            "src" + File.separator +
            "test" + File.separator +
            "java" + File.separator +
            "com" + File.separator +
            "stc" + File.separator +
            "test_crew" + File.separator +
            "tests" + File.separator +
            JSON_SUBDIRECTORY + File.separator +
            JSON_FILE_NAME;

    private static final String ARABIC = "العربية";
    private static final String ENGLISH = "English";

    private JsonNode readJsonData(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        return objectMapper.readTree(file);
    }

    private void validateStcPackageByTypeAndLanguage(String packageType, String language) throws InterruptedException, IOException {
        JsonNode jsonNode = readJsonData(JSON_FILE_PATH);

        for (JsonNode row : jsonNode) {
            String actualLanguage = row.get("language").asText();
            String actualPackageType = row.get("packageType").asText();

            if (packageType.equalsIgnoreCase(actualPackageType) && language.equalsIgnoreCase(actualLanguage)) {
                validateStcPackage(row);
            }
        }
    }

    private void validateStcPackage(JsonNode row) throws InterruptedException {
        String language = row.get("language").asText();
        String packageType = row.get("packageType").asText();
        String fees = row.get("fees").asText();
        String currency = row.get("currency").asText();
        String timePeriod = row.get("timePeriod").asText();

        browser.get().stc.setLanguage(language);
        browser.get().stc.stcHome.getHeader().clickOnLanguage(language);

        Assert.assertEquals(browser.get().stc.stcHome.getYourPlanSection().getPackageType(packageType), packageType);
        Assert.assertEquals(browser.get().stc.stcHome.getYourPlanSection().getFeesPackage(packageType, language), fees);
        Assert.assertEquals(browser.get().stc.stcHome.getYourPlanSection().getCurrencyPackage(packageType, language), currency);
        Assert.assertEquals(browser.get().stc.stcHome.getYourPlanSection().getCurrencyTimePeriod(packageType, language), timePeriod);
    }

    @Test
    public void validateStcPackageLiteEnglish() throws InterruptedException, IOException {
        validateStcPackageByTypeAndLanguage("Lite", ENGLISH);
    }

    @Test
    public void validateStcPackageLiteArabic() throws InterruptedException, IOException {
        validateStcPackageByTypeAndLanguage("لايت", ARABIC);
    }

    @Test
    public void validateStcPackageClassicEnglish() throws InterruptedException, IOException {
        validateStcPackageByTypeAndLanguage("CLASSIC", ENGLISH);
    }

    @Test
    public void validateStcPackageBasicArabic() throws InterruptedException, IOException {
        validateStcPackageByTypeAndLanguage("الأساسية", ARABIC);
    }

    @Test
    public void validateStcPackagePremiumEnglish() throws InterruptedException, IOException {
        validateStcPackageByTypeAndLanguage("PREMIUM", ENGLISH);
    }

    @Test
    public void validateStcPackagePremiumArabic() throws InterruptedException, IOException {
        validateStcPackageByTypeAndLanguage("بريميوم", ARABIC);
    }
}
