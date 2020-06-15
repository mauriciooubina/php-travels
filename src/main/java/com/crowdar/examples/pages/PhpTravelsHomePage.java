package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class PhpTravelsHomePage extends PageBasePhpTravels {

    private final String FLIGHT_BUTTON = "#search > div > div > div > div > div > nav > ul > li:nth-child(2) > a";
    private final String ONEWAY_FLIGHT = "#flights > div > div > form > div > div.row.mb-10.row-reverse.align-items-start.row-return > div.col-8 > div > div:nth-child(1) > label";
    private final String RETURN_TRIP = "#flights > div > div > form > div > div.row.mb-10.row-reverse.align-items-start.row-return > div.col-8 > div > div:nth-child(2) > label";
    private final String FLIGHT_OPTION = "#flights > div > div > form > div > div.row.mb-10.row-reverse.align-items-start.row-return > div.col-4 > div > div > div > ul > li.active-result.result-selected";
    private final String SELECT_FLY_TYPE = "#flights > div > div > form > div > div.row.mb-10.row-reverse.align-items-start.row-return > div.col-4 > div > div";
    private final String DEPARTURE = "s2id_location_from";
    private final String DEPARTURE_SELECTOR ="#location_from";
    private final String DESTINATION = "s2id_location_to";
    private final String DESTINATION_SELECTOR = "#location_to";
    private final String TOP_OF_CALENDAR = "#datepickers-container > div.datepicker.-bottom-left-.-from-bottom-.active > nav > div.datepicker--nav-title";
    private final String YEAR_SELECTOR = "#datepickers-container > div.datepicker.-bottom-left-.-from-bottom-.active > div > div.datepicker--years.datepicker--body.active > div > div:nth-child(%s)";
    private final String MONTH_SELECTOR = "#datepickers-container > div.datepicker.-bottom-left-.-from-bottom-.active > div > div.datepicker--months.datepicker--body.active > div > div:nth-child(%s)";
    private final String DAY_SELECTOR = "#datepickers-container > div.datepicker.-bottom-left-.-from-bottom-.active > div > div.datepicker--days.datepicker--body.active > div.datepicker--cells.datepicker--cells-days > div:nth-child(%s)";
    private final String DATE_PLACE = "FlightsDateStart";
    private final String DATE_RETURN_PLACE = "FlightsDateEnd";
    private final String DATE_CLICK_RIGHT = "#datepickers-container > div.datepicker.-bottom-left-.-from-bottom-.active > nav > div:nth-child(3)";
    private final String SELECT_DATE = "#datepickers-container > div.datepicker.-bottom-left-.-from-bottom-.active > div > div > div.datepicker--cells.datepicker--cells-days > div:nth-child(27)";
    private final String SELECT_RETURN_DATE = "#datepickers-container > div.datepicker.-bottom-left-.-from-bottom-.active > div > div > div.datepicker--cells.datepicker--cells-days > div:nth-child(32)";
    private final String ADULT = "#flights > div > div > form > div > div.row.no-gutters.mb-15.row-reverse > div.col-md-4.col-xs-12 > div > div > div:nth-child(1) > div > div.form-icon-left > div > input";
    private final String CHILD = "#flights > div > div > form > div > div.row.no-gutters.mb-15.row-reverse > div.col-md-4.col-xs-12 > div > div > div:nth-child(2) > div > div.form-icon-left > div > input";
    private final String INFANT = "#flights > div > div > form > div > div.row.no-gutters.mb-15.row-reverse > div.col-md-4.col-xs-12 > div > div > div:nth-child(3) > div > div.form-icon-left > div > input";
    private final String INCREASE_TRAVELER = "#flights > div > div > form > div > div.row.no-gutters.mb-15.row-reverse > div.col-md-4.col-xs-12 > div > div > div:nth-child(%s) > div > div.form-icon-left > div > span > button.btn.btn-white.bootstrap-touchspin-up";
    private final String DECREASE_TRAVELER  = "#flights > div > div > form > div > div.row.no-gutters.mb-15.row-reverse > div.col-md-4.col-xs-12 > div > div > div:nth-child(%s) > div > div.form-icon-left > div > span > button.btn.btn-white.bootstrap-touchspin-down";
    private final String SEARCH_BUTTON = "#flights div.tab-inner.menu-horizontal-content div.form-search-main-01 form div.form-inner div:nth-of-type(3) div:nth-of-type(4) button.btn-primary.btn.btn-block";


    public PhpTravelsHomePage(RemoteWebDriver driver) {
        super(driver);
        this.url = ""; //here you can define the custom paths For example:"/search" --> www.googe.com/search
    }

    public void go() {
        navigateToCompleteURL();
    }

    public void selectFlight(){clickElement(By.cssSelector(FLIGHT_BUTTON));}

    public void selectTripType(String tripType) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.cssSelector(ONEWAY_FLIGHT));
    }

    public void selectReturnFlight(String tripType) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.cssSelector(RETURN_TRIP));
    }

    public void clickFlightType(String flightType) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.cssSelector(SELECT_FLY_TYPE));
        clickElement(By.cssSelector(FLIGHT_OPTION));
    }

    public void writeDeparture(String departure) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.id(DEPARTURE));
        WebElement departureField = driver.findElement(By.cssSelector(DEPARTURE_SELECTOR));
        departureField.sendKeys(departure);
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES);
        Thread.sleep(2000);
        departureField.sendKeys(Keys.ENTER);
    }

    public void writeDestination(String destination) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.id(DESTINATION));
        WebElement departureField = driver.findElement(By.cssSelector(DESTINATION_SELECTOR));
        departureField.sendKeys(destination);
        Thread.sleep(2000);
        departureField.sendKeys(Keys.ENTER);
    }

    public void selectDateFlight(String date) throws InterruptedException, ParseException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.id(DATE_PLACE));
        Thread.sleep(2000);
        Calendar calendar = createCalendarWithDate(date);
        selectCorrectDate(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
    }

    public void selectReturnDateFlight(String returnDate) throws InterruptedException, ParseException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.id(DATE_RETURN_PLACE));
        Thread.sleep(2000);
        Calendar calendar = createCalendarWithDate(returnDate);
        selectCorrectDate(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
    }

    public void selectCorrectDate(int day, int month, int year){
        clickElement(By.cssSelector(TOP_OF_CALENDAR));
        clickElement(By.cssSelector(TOP_OF_CALENDAR));
        clickElement(By.cssSelector(String.format(YEAR_SELECTOR,year%10+2)));
        clickElement(By.cssSelector(String.format(MONTH_SELECTOR,month)));
        clickElement(By.cssSelector(String.format(DAY_SELECTOR,day +2)));
    }

    public Calendar createCalendarWithDate(String date) throws ParseException {
        Calendar calendar = new GregorianCalendar();
        Date newDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        calendar.setTime(newDate);
        return calendar;
    }

    public void selectCorrectTravelers(String adults, String child, String infant) {
        WebElement adultCount = driver.findElement(By.cssSelector(ADULT));
        writeProperTraveler(1, Integer.parseInt(adults), Integer.parseInt(adultCount.getAttribute("value")));

        WebElement childCount = driver.findElement(By.cssSelector(CHILD));
        childCount.getAttribute("value");
        writeProperTraveler(2, Integer.parseInt(child), Integer.parseInt(childCount.getAttribute("value")));

        WebElement infantCount = driver.findElement(By.cssSelector(INFANT));
        infantCount.getAttribute("value");
        writeProperTraveler(3, Integer.parseInt(infant), Integer.parseInt(infantCount.getAttribute("value")));
    }

    private void writeProperTraveler(int selectorPos, int wantedTravelers, int actualTravelers) {
        if(actualTravelers<wantedTravelers) {
            for (int i = actualTravelers; i < wantedTravelers; i++) {
                clickElement(By.cssSelector(String.format(INCREASE_TRAVELER, selectorPos)));
            }
        }
    }

    public void clickSearchButton() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.cssSelector(SEARCH_BUTTON));
    }
}
