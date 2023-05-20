package com.cydeo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorOperationsTest {

    AppiumDriver<MobileElement> driver;

    @BeforeEach
    @Test
    public void init() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        caps.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        URL url = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(url, caps);
    }

    @Test
    public void test() {

/**
 * 4 + 5 = 9
 */

        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
        driver.findElement(MobileBy.AccessibilityId("plus")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(MobileBy.AccessibilityId("equals")).click();

        String actResult = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

        Assertions.assertEquals(9,Integer.parseInt(actResult));


    }
    /**
     * 15 / 5 = 3
     */
@Test
    public void test2(){
        driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(MobileBy.AccessibilityId("divide")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(MobileBy.AccessibilityId("equals")).click();
        String actResult = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
        Assertions.assertEquals(3,Integer.parseInt(actResult));
    }


    @AfterEach
    @Test
    public void close() {

        driver.closeApp();

    }
}
