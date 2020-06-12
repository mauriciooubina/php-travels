package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class PhpTravelsHomePage extends PageBasePhpTravels {

    private final String FLIGHT_BUTTON = "#search > div > div > div > div > div > nav > ul > li:nth-child(2) > a";
    private final String ONEWAY_FLIGHT = "#flights > div > div > form > div > div.row.mb-10.row-reverse.align-items-start.row-return > div.col-8 > div > div:nth-child(1) > label";
    private final String FLIGHT_OPTION = "#flights > div > div > form > div > div.row.mb-10.row-reverse.align-items-start.row-return > div.col-4 > div > div > div > ul > li.active-result.result-selected";
    private final String SELECT_FLY_TYPE = "#flights > div > div > form > div > div.row.mb-10.row-reverse.align-items-start.row-return > div.col-4 > div > div";
    private final String DEPARTURE = "s2id_location_from";
    private final String DESTINATION = "s2id_location_to";
    private final String DATE_PLACE = "FlightsDateStart";
    private final String SEARCH_BUTTON = "#flights div.tab-inner.menu-horizontal-content div.form-search-main-01 form div.form-inner div:nth-of-type(3) div:nth-of-type(4) button.btn-primary.btn.btn-block";
    private final String FIRST_RESULT = "#LIST > li:nth-child(1) > div > div.theme-search-results-item-preview > div.row > form > div.col-md-2 > div > button";


    public PhpTravelsHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = ""; //here you can define the custom paths For example:"/search" --> www.googe.com/search
    }

    public void go() {
        navigateToCompleteURL();
    }

    /*public void enterSearchCriteria(String text) {
        completeField(By.xpath(INPUT_SEARCH_XPATH), text);
    }*/

    public void selectFlight(){clickElement(By.cssSelector(FLIGHT_BUTTON));}

    public void selectTripType(String tripType) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.cssSelector(ONEWAY_FLIGHT));
    }

    public void clickFlightType(String flightType) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.cssSelector(SELECT_FLY_TYPE));
        clickElement(By.cssSelector(FLIGHT_OPTION));
    }

    public void writeDeparture(String departure) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.id(DEPARTURE));
        WebElement departureField = driver.findElement(By.cssSelector("#location_from"));
        departureField.sendKeys(departure);
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
        Thread.sleep(3000);
        departureField.sendKeys(Keys.ENTER);
    }

    public void writeDestination(String destination) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.id(DESTINATION));
        WebElement departureField = driver.findElement(By.cssSelector("#location_to"));
        departureField.sendKeys(destination);
        Thread.sleep(3000);
        departureField.sendKeys(Keys.ENTER);
    }

    public void selectDateFlight(String date) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.id(DATE_PLACE));
        Thread.sleep(3000);
        clickElement(By.cssSelector("#datepickers-container > div.datepicker.-bottom-left-.-from-bottom-.active > nav > div:nth-child(3)"));
        clickElement(By.cssSelector("#datepickers-container > div.datepicker.-bottom-left-.-from-bottom-.active > nav > div:nth-child(3)"));
        clickElement(By.cssSelector("#datepickers-container > div.datepicker.-bottom-left-.-from-bottom-.active > nav > div:nth-child(3)"));
        clickElement((By.cssSelector("#datepickers-container > div.datepicker.-bottom-left-.-from-bottom-.active > div > div > div.datepicker--cells.datepicker--cells-days > div:nth-child(27)")));
    }

    public void selectCorrectTravelers(String adults, String child, String infant) {

    }

    public void clickSearchButton() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.cssSelector(SEARCH_BUTTON));
    }
}
