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
    // Navigate to the Login page using Firefox driver.
    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        driver = new FirefoxDriver();
        page = new LoginPage(driver,
                "https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
        page.open();
    }
    // Test to see if the User Input box is present for Username

    @Test
    public void testUserInputBoxIsPresentForValidIdentitifier() {
        assertTrue("User Input Text Box is not present ", page.isElementPresentById(page.getUserInputId()));

    }
    // Test to check if the UserInput box is not present for Username
    @Test(expected = NoSuchElementException.class)
    public void testUserInputBoxIsNotPresentForInValidIdentitifier() {
        page.isElementPresentById("InvalidIdentifier");

    }
    // Test to see if the Password Input box is present.
    @Test
    public void testUserPassIdIsPresentForValidIdentifier(){
        assertTrue("User Pass Id is not present", page.isElementPresentById(page.getUserPassId()));
    }
    // Test to see if the Password Input box is not present.
    @Test(expected = NoSuchElementException.class)
    public void testUserPassIdIsNotPresentForInValidIdentifier(){
        page.isElementPresentById("InvalidIdentifier");
    }
    //Test with valid Login details.
    @Test
    public void testValidLoginDetails(){
        page.login("opensourcescm","opensourcescm");
        assertEquals("https://s1.demo.opensourcecms.com/wordpress/wp-login.php", driver.getCurrentUrl());
    }
    //Test with Invalid Login details
    @Test(expected = NoSuchElementException.class)
    public void testInValidLoginDetails(){
        page.login("","");
        page.isElementPresentById("InvalidIdentifier");
    }
    // Test Remember me check box
   @Test
   public void testRememberMeCheckbox(){
        page.checkbox("rememberme");
   }
   // Test Lost Password link.
    @Test
    public void testLostPassword() {
        page.lostPassword();
        assertEquals("https://s1.demo.opensourcecms.com/wordpress/wp-login.php?action=lostpassword" , driver.getCurrentUrl());
    }
    //Test Back to Opensourcescm link.

    @Test
    public void testBackToSourceOpenCMS(){

        page.backToOpenSourceCMS();
        assertEquals("https://s1.demo.opensourcecms.com/wordpress/", driver.getCurrentUrl());
    }
    // Close the page.
    @After
    public void teardown(){

        page.close();
    }



}


