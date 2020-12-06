package com.test.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Parent class for holding all the common methods
 */
public class Page {


    // This class will store all the locator and method
    private final WebDriver driver;
    private final String url;


    // constructor
    public Page(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;

    }

    public void open() {
        driver.get(url);
    }
    //Method to Pass Input
    public void passInput(String identifier, String input) {
        driver.findElement(By.id(identifier)).sendKeys(input);
    }
    // method to click a button
    public void clickButton(String identifier) {
        driver.findElement(By.name(identifier)).click();
    }
    // method to click a link
    public void clicklink(String identifier){ driver.findElement(By.linkText(identifier)).click();}
    // method to tick a checkbox
    public void checkbox(String identifier){ driver.findElement(By.id(identifier)).click();}
    // method to get text
    public String getText(String identifier){return driver.findElement(By.id(identifier)).getText();}

    //check if the element is present
    public boolean isElementPresentById(String identifier) {
        return driver.findElement(By.id(identifier)).isDisplayed();
    }


    public boolean isElementPresentByName(String identifier) {
        return driver.findElement(By.name(identifier)).isDisplayed();
    }
    //close the webdriver
    public void close() {
        driver.close();
    }
}


