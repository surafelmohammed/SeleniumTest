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

        driver.navigate().to("https://mail.google.com/mail/u/0/#inbox");
        driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("surafelmohammed66@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();

        Thread.sleep(5000);
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        pass.click();
        pass.sendKeys("Surafel1");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click(); // submit form

        Thread.sleep(4000); // wait until the messages are loaded
        List<WebElement> unreadEmails = driver.findElements(By.xpath("//*[@class='zF']"));

        FileWriter fw=new FileWriter("unread_messages.txt");
        for (WebElement email: unreadEmails ) {
            fw.write(email.getText()+"\n");

        }
        fw.close();
    }
}
