package fuelCost;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FuelCostTest {
    private static WebDriver driver;

    @BeforeClass
    public static void start(){
        System.setProperty("webdriver.gecko.driver", "Z:\\MPR\\lab6\\src\\main\\resources\\geckodriver.exe");
        var options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver(options);
        driver.get("https://www.calculator.net/fuel-cost-calculator.html");
    }

    public static String fuelCostOutput(String distance, String fuelEffiency, String gasPrice){
        driver.findElement(By.name("tripdistance")).clear();
        driver.findElement(By.name("tripdistance")).sendKeys(distance);
        driver.findElement(By.name("fuelefficiency")).clear();
        driver.findElement(By.name("fuelefficiency")).sendKeys(fuelEffiency);
        driver.findElement(By.name("gasprice")).clear();
        driver.findElement(By.name("gasprice")).sendKeys(gasPrice);
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        return driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText();
    }

    @Test
    public void fuelTest1(){
        String distance = "333";
        String fuelEffiency = "5.5";
        String gasPrice = "1.8";
        String output = fuelCostOutput(distance, fuelEffiency, gasPrice);
        String expected = "This trip will require 18.3 liters of fuel, which amounts to a fuel cost of $32.97.";
        Assert.assertEquals(expected, output);
    }

    @Test
    public void fuelTest2(){
        String distance = "1000";
        String fuelEffiency = "100";
        String gasPrice = "10";
        String output = fuelCostOutput(distance, fuelEffiency, gasPrice);
        String expected = "This trip will require 1,000 liters of fuel, which amounts to a fuel cost of $9,999.96.";
        Assert.assertEquals(expected, output);
    }

    @AfterClass
    public static void stop(){
        driver.close();
    }
}
