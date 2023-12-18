package com.stc.test_crew.screen;

import com.stc.test_crew.driver.DriverManager;
import com.stc.test_crew.screen.headers.StcHeader;
import com.stc.test_crew.screen.headers.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class StcHome extends BaseScreen{
    StcHeader header;
    SignInPage signInPage;
    ChooseYourPlanSection chooseYourPlanSection;

    public StcHome(){
        header = new StcHeader();
        signInPage = new SignInPage();
        chooseYourPlanSection = new ChooseYourPlanSection();
    }

    public StcHeader getHeader(){
        return header;
    }
    public ChooseYourPlanSection getYourPlanSection() {
        return chooseYourPlanSection;
    }

}
