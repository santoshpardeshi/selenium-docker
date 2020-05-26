package com.newtour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.NAME, using = "reserveFlights")
    private WebElement reserveFlightsBtn;

    @FindBy(how = How.NAME, using = "buyFlights")
    private WebElement buyFlightsBtn;

    public FindFlightPage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void submitFindFlightsPage(){
        wait.until(ExpectedConditions.elementToBeClickable(reserveFlightsBtn));
        reserveFlightsBtn.click();
    }

    public void gotoFlightConfirmationPage(){
        wait.until(ExpectedConditions.elementToBeClickable(buyFlightsBtn));
        buyFlightsBtn.click();
    }
}
