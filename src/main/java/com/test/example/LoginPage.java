package com.test.example;

import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {


    private final static String USER_INPUT_ID = "user_login";
    private final static String USER_PASS_ID = "user_pass";
    private final static String SUBMIT_ID = "wp-submit";
    private final static String LOST_PASSWORD = "Lost your password?";
    private final static String BACK_TO_OPENSOURCECMS = "← Back to opensourcecms";
    private final static String REMEMBER_ME = "rememberme";


    public LoginPage(WebDriver driver, String url) {
        super(driver, url);

    }

    public void login(String username, String password) {
        passInput(USER_INPUT_ID, username);
        passInput(USER_PASS_ID, password);
        clickButton(SUBMIT_ID);
    }

    public void lostPassword(){

        clicklink(LOST_PASSWORD);
    }
    public void backToOpenSourceCMS(){

        clicklink(BACK_TO_OPENSOURCECMS);
    }

    public void RememberMe(){

        checkbox(REMEMBER_ME);
    }


    // helper functions for unit testing
    public String getUserInputId() {
        return USER_INPUT_ID;
    }

    public String getUserPassId() {
        return USER_PASS_ID;
    }

}
