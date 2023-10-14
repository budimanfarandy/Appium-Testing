package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {



        // Desired Capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","Pixel 2 API 30");
        desiredCapabilities.setCapability("udid","emulator-5554");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("appPackage","com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("noReset",true);

        // URL
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        // Instance AndroidDriver
        AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);

        // MobileElement
        // 1 + 2 = 3

        MobileElement satu = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_1");
        MobileElement dua = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        MobileElement tambah = (MobileElement) driver.findElementById("com.google.android.calculator:id/op_add");
        MobileElement samaDengan = (MobileElement) driver.findElementById("com.google.android.calculator:id/eq");
        satu.click();  // di Katalon artinya tap
        tambah.click();
        dua.click();
        samaDengan.click();
        MobileElement hasil = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        String txtHasil = hasil.getText();
        System.out.println(txtHasil);
        /*if (txtHasil.equals("3")) {
            System.out.println("Passes");
        } else {
            System.out.println("Failed");
        }*/
        assertEquals(txtHasil,"3");


        // Chalenge  3 - 4 = -1
         MobileElement tiga = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
         MobileElement empat = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_4");
         MobileElement kurang = (MobileElement) driver.findElementByXPath("//android.widget.ImageButton[contains(@content-desc, \"min\")]");
         tiga.click();
         kurang.click();
         empat.click();
         samaDengan.click();
         MobileElement result = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
         String txtResult = result.getText();
         System.out.println(txtResult);
         /*if (txtResult.equals("−1")){
             System.out.println("Passes"); 
         } else {
             System.out.println("Failed");
         }*/
         assertEquals(txtResult, "−1");


        driver.quit();

    }


    // Method Assert
    public static void assertEquals(String actual, String expected){
        if (actual.equals(expected)){
            System.out.println("Passes");
        } else {
            System.out.println("Failed");
        }
    }

}