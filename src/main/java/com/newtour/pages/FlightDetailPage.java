package com.newtour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.NAME, using = "passCount")
    private WebElement passengerDrop;

    @FindBy(how = How.NAME, using = "findFlights")
    private WebElement findFlightsBtn;

    public FlightDetailPage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void selectPassenger(String noOfPassenger){
        wait.until(ExpectedConditions.elementToBeClickable(passengerDrop));
        Select select = new Select(passengerDrop);
        select.selectByValue(noOfPassenger);
    }

    public void gotoFindFlightPage(){
        findFlightsBtn.click();
    }
}
