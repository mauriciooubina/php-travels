package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.PhpTravelsHomePage;
import com.crowdar.examples.pages.PhpTravelsSearchResultPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class PhpTravelsSteps extends PageSteps {

    @Given("The client is in php travels page")
    public void home() {
        Injector._page(PhpTravelsHomePage.class).go();
    }

    @When("The client searchs for a (.*) flight in (.*) from (.*) to (.*) for the date (.*)")
    public void searchFlight(String tripType , String flightType , String departure, String destination, String date) throws InterruptedException {
        Injector._page(PhpTravelsHomePage.class).selectFlight();
        Injector._page(PhpTravelsHomePage.class).selectTripType(tripType);
        Injector._page(PhpTravelsHomePage.class).clickFlightType(flightType);
        Injector._page(PhpTravelsHomePage.class).writeDeparture(departure);
        Injector._page(PhpTravelsHomePage.class).writeDestination(destination);
        Injector._page(PhpTravelsHomePage.class).selectDateFlight(date);

        //CREAR HASH COMO VARIABLE GLOBAL PARA ENCONTRAR RELACION ENTRE ROUND TRIP Y RETURN
        //MANDAR FECHA COMO TEXTO

    }

    @And("its for (.*) adult (.*) child (.*) infant")
    public void select(String adults, String child, String infant){
        Injector._page(PhpTravelsHomePage.class).selectCorrectTravelers(adults, child, infant);
        Injector._page(PhpTravelsHomePage.class).clickSearchButton();
    }

    @And("clicks the (.*) result writing")
    public void clicksTheResultWriting(String result, String mail, String psw, ) {
    }


    @And("completes with name (.*) Surname (.*) email (.*) phone (.*) birthday (.*) passport (.*) expiration (.*) nationality (.*)")
    public void writePersonalInformation(String name, String surname, String email, String phone, String birthday, String passport, String expiration, String nationality) {


    }

    @And("pays with (.*) number (.*) expiration (.*) cvv (.*)")
    public void writePaymentInformation(String arg0, String arg1, String arg2, String arg3) {
    }

    @Then("A reservation number is provide")
    public void statVerification() {
        Assert.assertTrue(!Injector._page(PhpTravelsSearchResultPage.class).getStats().isEmpty());

    }
}
