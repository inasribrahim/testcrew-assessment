package com.stc.test_crew.platform;

import com.stc.test_crew.screen.StcHome;

public class Stc {

    public StcHome stcHome;
    String language ;
    public Stc(){
        stcHome = new StcHome();
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage(){
        return language;
    }
}
