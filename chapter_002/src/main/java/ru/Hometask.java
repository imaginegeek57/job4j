package ru;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hometask {

    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void firstTest(){
        driver.manage().window().maximize();
        driver.get("https://habr.com/ru/");
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"search-form-field\"]"));
        searchField.sendKeys ("xpath\n");
        // sort по рейтенгу
        WebElement press = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/section/div[1]/div[2]/ul/li[3]/a"));
        press.click();
    }
    @After
    public void close() {
        driver.close();
    }
}
