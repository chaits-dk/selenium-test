package com.test.example;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class LoginPageTest {

    private static LoginPage page;
    private FirefoxDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        driver = new FirefoxDriver();
        page = new LoginPage(driver, "test", "test",
                "https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
        page.open();
    }

    @Test
    public void testUserInputBoxIsPresentForValidIdentitifier() {
        assertTrue("User Input Text Box is not present ", page.isElementPresentById(page.getUserInputId()));

    }

    @Test(expected = NoSuchElementException.class)
    public void testUserInputBoxIsNotPresentForInValidIdentitifier() {
        page.isElementPresentById("InvalidIdentifier");

    }
    @Test
    public void testUserPassIdIsPresentForValidIdentifier(){
        assertTrue("User Pass Id is not present", page.isElementPresentById(page.getUserPassId()));
    }

    @Test(expected = NoSuchElementException.class)
    public void testUserPassIdIsNotPresentForInValidIdentifier(){
        page.isElementPresentById("InvalidIdentifier");
    }
    @Test
    public void testValidLoginDetails(){
        page.passInput("user_login","opensourcecms");
        page.passInput("user_pass","opensourcecms");
        page.clickButton("wp-submit");
        assertEquals("https://s1.demo.opensourcecms.com/wordpress/wp-admin/", driver.getCurrentUrl());
    }
    @Test(expected = NoSuchElementException.class)
    public void testInValidLoginDetails(){
        page.passInput("user_login","opensourcecm");
        page.passInput("user_pass","opensourcecm");
        page.clickButton("wp-submit");
        page.isElementPresentById("InvalidIdentifier");
    }

   @Test
   public void testRememberMeCheckbox(){
        page.checkbox("rememberme");
   }
    @Test
    public void testLostPassword() {
        page.lostPassword();
        assertEquals("https://s1.demo.opensourcecms.com/wordpress/wp-login.php?action=lostpassword " , driver.getCurrentUrl());
    }

    @Test
    public void testBackToSourceOpenCMS(){

        page.backToOpenSourceCMS();
        assertEquals("https://s1.demo.opensourcecms.com/wordpress/", driver.getCurrentUrl());
    }

    @After
    public void teardown(){

        page.close();
    }



}


