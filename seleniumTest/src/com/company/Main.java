package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        System.setProperty("webdriver.gecko.driver", "/home/surafel/Documents/geckodriver-v0.24.0-linux64/geckodriver");
        WebDriver driver;
        driver = new FirefoxDriver();
        driver.get("http://google.com");
        System.out.println("Successfully opened the website localhost");
        Thread.sleep(5);
        driver.quit();


//        System.setProperty("webdriver.chrome.driver", "/home/surafel/Documents/geckodriver-v0.24.0-linux64/chromedriver");
//        WebDriver driver;
//        driver = new ChromeDriver();
////Launch the some site
//            driver.get("http://google.com");
//// Print a Log In message to the screen
//        System.out.println("Successfully opened the website localhost");
////Wait for 5 Sec
//        //Thread.sleep(5);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//
//// Close the driver
//        driver.quit();
    }
}
