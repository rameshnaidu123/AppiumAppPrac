package com.qa.Test;

import com.google.common.collect.ImmutableMap;
import com.qa.utils.BaseClass;
import com.qa.utils.UtilMethods;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;

public class SampleTest extends BaseClass {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        BaseClass bb=new BaseClass();
        AndroidDriver driver=bb.getDriver();
        driver.findElement(AppiumBy.accessibilityId("YouTube")).click();
        driver.findElement(AppiumBy.accessibilityId("Library")).click();
       //  WebElement ss=driver.findElement(By.xpath("//*[contains(@text,'Java in Telugu || Java in Telugu by Kotha Abhishek'])"));
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Java in Telugu || Java in Telugu by Kotha Abhishek\"))"));
//        UtilMethods uu=new UtilMethods();
//      //  uu.scroll();
        //driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        driver.lockDevice(Duration.ofSeconds(5));
        Thread.sleep(2000);
        driver.terminateApp("com.google.android.youtube");
        Thread.sleep(2000);

        driver.findElement(AppiumBy.accessibilityId("Settings")).click();
        WebElement rr=driver.findElement(AppiumBy.id("com.android.settings:id/main_content_scrollable_container"));
        for(int i=0;i<3;i++){
            ((JavascriptExecutor)driver).executeScript("mobile:scrollGesture", ImmutableMap.of(
                  //  "left",100,"top",100,"width",200,"height",600,
                    "elementId",rr,
                    "direction","down",
                    "percent",1.0

            ));
        }
        Thread.sleep(5000);


    }

    public  void quit() throws MalformedURLException, InterruptedException {
        getDriver().quit();
    }
}
