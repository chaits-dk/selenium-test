package com.test.example;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LostPasswordTest {

    private static LostPasswordPage page;
    private FirefoxDriver driver;


    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        driver = new FirefoxDriver();
        page = new LostPasswordPage(driver, "https://s1.demo.opensourcecms.com/wordpress/wp-login.php?action=lostpassword");
        page.open();
    }

    @Test
    public void testUserInputBoxIsPresentForValidIdentitifier() {
        assertTrue("User Input box not present", page.isElementPresentById(page.getUserInputId()));
    }

    @Test(expected = NoSuchElementException.class)
    public void testUserInputBoxIsNotPresentForInValidIdentitifier() {
        page.isElementPresentById("InvalidIdentifier");
    }
   @Test
    public void testValidUsername(){
        page.getNewPassword("opensourcecms");
        assertEquals("https://s1.demo.opensourcecms.com/wordpress/wp-login.php?checkemail=confirm",driver.getCurrentUrl());
   }
   @Test
    public void testInvalidUsername(){
        page.getNewPassword("");
        assertEquals();
   }
   @Test
    public void testRedirectToLoginPage(){
        page.clicklink("Log in");
        System.out.println(driver.getCurrentUrl());
   }
   @Test
    public void testBackToOpensourcecmslink(){
        page.clicklink("← Back to opensourcecms");
        System.out.println(driver.getCurrentUrl());
   }

}
