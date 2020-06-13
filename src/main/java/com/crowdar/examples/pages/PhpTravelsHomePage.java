package com.crowdar.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

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
    private final String FIRST_RESULT = "#LIST > li:nth-child(1) > div > div.theme-search-results-item-preview > div.row > form > div.col-md-2 > div > button";
    private final String USERNAME_EMAIL = "username";
    private final String USERNAME_PASSWORD = "password";
    private final String NAME = "#name";
    private final String SURNAME = "#surname";
    private final String MAIL = "#email";
    private final String PHONE = "phone";
    private final String BIRTHDAY = "birthday";
    private final String PASSPORT = "cardno";
    private final String EXPIRATION = "expiration";
    private final String NATIONALITY = "nationality";
    private final String CARD = "cardtype";
    private final String CARD_VISA = "#cardtype > option:nth-child(5)";
    private final String CARD_NUMBER = "card-number";
    private final String CARD_MONTH = "expiry-month";
    private final String MONTH = "#expiry-month > option:nth-child(%s)";
    private final String CARD_YEAR = "expiry-year";
    private final String YEAR = "#expiry-year > option:nth-child(%s)";
    private final String CARD_CVV = "cvv";
    private final String CONDITIONS = "body > div.body-inner > div > div.main-wrapper.scrollspy-action > div.page-wrapper.page-payment.bg-light > div > div > div.col-12.col-lg-8 > div > div.content-wrapper > form > div.custom-control.custom-checkbox.form-group.acceptterm > label";
    private final String CHECKING = "confirmBooking";



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

    public void selectDateFlight(String date) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.id(DATE_PLACE));
        Thread.sleep(2000);
        clickElement(By.cssSelector(DATE_CLICK_RIGHT));
        clickElement(By.cssSelector(DATE_CLICK_RIGHT));
        clickElement(By.cssSelector(DATE_CLICK_RIGHT));
        clickElement((By.cssSelector(SELECT_DATE)));
    }

    public void selectReturnDateFlight(String returnDate) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        clickElement(By.id(DATE_RETURN_PLACE));
        Thread.sleep(2000);
        clickElement(By.cssSelector(DATE_CLICK_RIGHT));
        clickElement(By.cssSelector(DATE_CLICK_RIGHT));
        clickElement(By.cssSelector(DATE_CLICK_RIGHT));
        clickElement((By.cssSelector(SELECT_RETURN_DATE)));
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

    public void clickFirstResult() {clickElement(By.cssSelector(FIRST_RESULT));}

    public void writeEmail(String mail) {completeField(By.id(USERNAME_EMAIL), mail);}

    public void writePassword(String psw) {completeField(By.id(USERNAME_PASSWORD), psw);}

    public void writeName(String name) {
        WebElement namePath = driver.findElement(By.cssSelector(NAME));
        namePath.sendKeys(name);
    }

    public void writeSurname(String surname) {
        WebElement surnamePath = driver.findElement(By.cssSelector(SURNAME));
        surnamePath.sendKeys(surname);
    }

    public void writeMail(String email) {completeField(By.cssSelector(MAIL), email);}

    public void writePhone(String phone) {completeField(By.id(PHONE), phone);}

    public void writeBirthday(String birthday) {completeField(By.id(BIRTHDAY), birthday);}

    public void writePassport(String passport) {completeField(By.id(PASSPORT), passport);}

    public void writeExpiration(String expiration) {completeField(By.id(EXPIRATION), expiration);}

    public void writeNationality(String nationality) throws InterruptedException {
        WebElement departureField = driver.findElement(By.id(NATIONALITY));
        departureField.sendKeys(nationality);
        Thread.sleep(2000);
        departureField.sendKeys(Keys.ENTER);
    }

    public void selectCreditCard(String card) throws InterruptedException {
        clickElement(By.id(CARD));
        Thread.sleep(2000);
        clickElement(By.cssSelector(CARD_VISA));
    }

    public void writeCardNumber(String cardNumber) {completeField(By.id(CARD_NUMBER), cardNumber);}

    public void selectExpiration(String cardExpirateMonth, String cardExpirateYear) throws InterruptedException {
        clickElement(By.id(CARD_MONTH));
        Thread.sleep(1000);
        int month = Integer.parseInt(cardExpirateMonth) + 1;
        clickElement(By.cssSelector(String.format(MONTH, String.valueOf(month))));

        clickElement(By.id(CARD_YEAR));
        Thread.sleep(1000);
        int year = Integer.parseInt(cardExpirateYear) + 2;
        clickElement(By.cssSelector(String.format(YEAR, String.valueOf(year%10))));
    }

    public void writeCvv(String cvv) {completeField(By.id(CARD_CVV), cvv);}

    public void acceptConditions() {clickElement(By.cssSelector(CONDITIONS));}

    public void finishChecking() {clickElement(By.id(CHECKING));}
}
