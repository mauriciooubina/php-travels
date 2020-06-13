package com.crowdar.examples.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class PhpTravelsFlightPage extends PageBasePhpTravels {

    private final String FIRST_RESULT = "#LIST > li:nth-child(1) > div > div.theme-search-results-item-preview > div.row > form > div.col-md-2 > div > button";

    public PhpTravelsFlightPage(RemoteWebDriver driver) {
        super(driver);
        this.url = ""; //here you can define the custom paths For example:"/search" --> www.googe.com/search
    }

    public void clickFirstResult() {clickElement(By.cssSelector(FIRST_RESULT));}
}
