package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.gecko.driver", "/home/surafel/Documents/geckodriver-v0.24.0-linux64/geckodriver");
        WebDriver driver;
        driver = new FirefoxDriver();

        driver.navigate().to("https://mail.google.com/mail/u/0/#inbox"); // navigate to gmail website
        driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("YOUR-EMAIL-GOES-HERE"); // enter email address
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();

        Thread.sleep(5000);
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")); // reference of password
        pass.click();
        pass.sendKeys("YOUR-PASSWORD-GOES-HERE"); // enter password
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click(); // submit form

        Thread.sleep(4000); // wait until the messages are loaded
        List<WebElement> unreadEmails = driver.findElements(By.xpath("//*[@class='zF']")); // filter out unread texts

        FileWriter fw=new FileWriter("unread_messages.txt"); // iterate and write on file
        for (WebElement email: unreadEmails ) {
            fw.write(email.getText()+"\n");

        }
        fw.close();
    }
}
