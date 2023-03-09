package com.qa.locators;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePageObjects {

    @AndroidFindBy(accessibility = "Home")
    private WebElement home_button;

    @AndroidFindBy(accessibility = "Shorts")
    private WebElement shorts_button;

    @AndroidFindBy(accessibility = "Subscriptions: New content is available")
    private WebElement subcription_button;

    @AndroidFindBy(accessibility = "Library")
    private WebElement library_button;




}
