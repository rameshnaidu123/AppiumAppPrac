package com.qa.utils;


import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.JavascriptExecutor;

public class UtilMethods extends BaseClass {




       public void scroll(){
           boolean canScrollMore;

               for(int i=0;i<=7;i++){
                   canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                           "left", 100, "top", 100, "width", 200, "height", 200,
                           "direction", "down",
                           "percent", 0.8
                   ));
               }

       }

}
