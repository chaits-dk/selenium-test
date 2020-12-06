package com.test.example;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LostPasswordTest {

    private static LostPasswordPage page;
    private FirefoxDriver driver;

    //Open LostPasswordpage in the Firefox webdriver
    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        driver = new FirefoxDriver();
        page = new LostPasswordPage(driver, "https://s1.demo.opensourcecms.com/wordpress/wp-login.php?action=lostpassword");
        page.open();
    }
    //Test to see if the User Input text box is present.
    @Test
    public void testUserInputBoxIsPresentForValidIdentitifier() {
        assertTrue("User Input box not present", page.isElementPresentById(page.getUserInputId()));
    }
    //Negetive test to see if the Userinput box is not present.
    @Test(expected = NoSuchElementException.class)
    public void testUserInputBoxIsNotPresentForInValidIdentitifier() {
        page.isElementPresentById("InvalidIdentifier");
    }
    //Test for valid user details
   @Test
    public void testValidUsername(){
        page.getNewPassword("opensourcecms");
        assertEquals("https://s1.demo.opensourcecms.com/wordpress/wp-login.php?checkemail=confirm",driver.getCurrentUrl());
   }
    //Test for Invalid or Null user details.
   @Test
    public void testInvalidUsername(){
        page.getNewPassword("");
       assertEquals("ERROR: Enter a username or email address.",page.getText("login_error"));
   }
    // Test if the link redirects to Login Page.
   @Test
    public void testRedirectToLoginPage(){
        page.clicklink("Log in");
        System.out.println(driver.getCurrentUrl());
   }
    // Test if the link redirects to Opensourcelink
   @Test
    public void testBackToOpensourcecmslink(){
        page.clicklink("← Back to opensourcecms");
        System.out.println(driver.getCurrentUrl());
   }
   @After
    public void teardown(){
        page.close();
   }

}
