package com.qa.locators;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LibraryPageObjects {

    @AndroidFindBy(accessibility = "Home")
    private WebElement home_button;
}
