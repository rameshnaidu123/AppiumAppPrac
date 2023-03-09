package com.qa.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Sam {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_4");
//        caps.setCapability("appPackage", "com.google.android.libraries");
//        caps.setCapability("appActivity", "com.google.android.libraries.youtube.player.features.gl.vr.VrWelcomeActivity - YouTube");
        caps.setCapability("newCommandTimeout", 18000);
        caps.setCapability("avdLaunchTime", 18000);
        //caps.setCapability("unlockType","pattern");
        //caps.setCapability("unlockKey","9261");


        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, caps);

        driver.findElement(AppiumBy.accessibilityId("YouTube")).click();
       // driver.findElement(AppiumBy.accessibilityId("Library")).click();

        Thread.sleep(5000); // export ADB="$ANDROID_HOME/platform-tools/adb"
        driver.quit();

    }
}
