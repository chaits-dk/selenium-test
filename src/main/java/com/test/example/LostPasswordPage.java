package com.test.example;

import org.openqa.selenium.WebDriver;

public class LostPasswordPage extends Page {



    private static final String USER_INPUT_ID = "user_login";
    private final static String GET_NEW_PASSWORD_ID = "wp-submit";
    private final static String REDIRECT_LOGIN_PAGE = "Log in";
    private final static String BACK_TO_OPENSOURCESCM = "← Back to opensourcecms";

    public LostPasswordPage(WebDriver driver, String url) {
        super(driver, url);

    }

    public void getNewPassword(String username) {
        passInput(USER_INPUT_ID, username);
        clickButton(GET_NEW_PASSWORD_ID);
    }

    public void redirectToLogin(){
        clicklink(REDIRECT_LOGIN_PAGE);
    }

    public void redirectBackToSchwurbelshop(){
        clicklink(BACK_TO_OPENSOURCESCM);
    }

    //helper function for unit testing
    public String getUserInputId() {
        return USER_INPUT_ID;
    }
}