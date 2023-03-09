package com.qa.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
   public  AndroidDriver driver;

    public static AppiumDriverLocalService service22;
    public static AndroidDriver  driverinit() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_33_x86_64");
        caps.setCapability("appPcakage", "com.google.android.libraries");
        caps.setCapability("appActivity", "com.google.android.libraries.youtube.player.features.gl.vr.VrWelcomeActivity - YouTube");
        caps.setCapability("newCommandTimeout", 18000);
        caps.setCapability("avdLaunchTime", 18000);
        caps.setCapability("unlockType","pattern");
        caps.setCapability("unlockKey","9261");

        // com.google.android.apps.messaging.ui.ConversationListActivity - Messages
        String appurl = "";

        URL url = new URL("http://127.0.0.1:4723/");
//        driver = new AndroidDriver(url, caps);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
       return null;
    }

    public void serverinit() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_33_x86_64");
        caps.setCapability("appPackage", "com.google.android.libraries");
        caps.setCapability("appActivity", "com.google.android.libraries.youtube.player.features.gl.vr.VrWelcomeActivity - YouTube");
        caps.setCapability("newCommandTimeout", 18000);
        caps.setCapability("avdLaunchTime", 18000);
        caps.setCapability("unlockType","pattern");
        caps.setCapability("unlockKey","9261");

        // com.google.android.apps.messaging.ui.ConversationListActivity - Messages
        String appurl = "";


        File logsPath=new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"com"+File.separator+"qa"+File.separator+"logs"+File.separator+"server_logs.txt");
        File nodee=new File("/usr/bin/node");
        File appiumm=new File("/usr/bin/appium");
        service22=AppiumDriverLocalService
                .buildService(new AppiumServiceBuilder()
                        .usingDriverExecutable(nodee)
                        .withAppiumJS(appiumm)
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                        .withIPAddress("127.0.0.1")
                        .usingPort(4724)
                        .withLogFile(logsPath)
                        .withArgument(GeneralServerFlag.LOG_LEVEL,"warn:debug")


                );
        service22.start();

        //URL url = new URL("http://127.0.0.1:4723/");
       // driver = new AndroidDriver(url, caps);
        System.out.println(service22.getUrl());
        this.driver=new AndroidDriver(service22.getUrl(),caps);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public  AndroidDriver getDriver() throws MalformedURLException, InterruptedException {

        if(this.driver==null){
           serverinit();
        }
        return this.driver;
    }


    public void sendKeys(WebElement e,String txt) throws MalformedURLException, InterruptedException {
         waitForVisibilityOfElement(e);
         e.sendKeys(txt);
    }

    public void click(WebElement e) throws MalformedURLException, InterruptedException {
        waitForVisibilityOfElement(e);
        e.click();
    }

    public String getText(WebElement e) throws MalformedURLException, InterruptedException {
        waitForVisibilityOfElement(e);
        String attValue=e.getText();
        return attValue;
    }

    public void waitForVisibilityOfElement(WebElement element) throws MalformedURLException, InterruptedException {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));


    }







}
