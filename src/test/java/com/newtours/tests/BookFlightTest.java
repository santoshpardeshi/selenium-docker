package com.newtours.tests;

import com.newtour.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {
    private String noOfPassengers;
    private String expPrice;

    @BeforeMethod
    @Parameters({"noOfPassengers","expPrice"})
    public void getParam(String noOfPassengers, String expPrice){
        this.noOfPassengers = noOfPassengers;
        this.expPrice = expPrice;
    }

    @Test
    public void registrationPageTest(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterFullname("Sele" ,"Docker");
        registrationPage.userCredential("Selenium","Docker");
        registrationPage.clickSubmitBtn();
    }

    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationTest(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlighDetailPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightDetailPageTest(){
        FlightDetailPage flightDetailPage= new FlightDetailPage(driver);
        flightDetailPage.selectPassenger(noOfPassengers);
        flightDetailPage.gotoFindFlightPage();
    }

    @Test(dependsOnMethods = "flightDetailPageTest")
    public void findFlightPageTest(){
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFlightsPage();
        findFlightPage.gotoFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPageTest")
    public void flightConfirmationPageTest(){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actPrice = flightConfirmationPage.getPrice();
        Assert.assertEquals(actPrice,expPrice);
    }
}
