package com.cydeo.tests;

import com.cydeo.pages.CalculatorPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalcPomTest {
    /**
     * 5 * 8 = 40
     */

    AppiumDriver<MobileElement> driver;
@Test
    public void test() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 3");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10");
        caps.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/calculator.apk");

        URL url = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<MobileElement>(url,caps);

        CalculatorPage calc = new CalculatorPage();
        calc.clickSingleDigit(4);
        calc.multiply.click();
        calc.clickSingleDigit(8);
        calc.equals.click();

        Assertions.assertEquals(40,Integer.parseInt(calc.result.getText()));

        driver.closeApp();



    }

}
