package com.newtour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.LINK_TEXT, using = "sign-in")
    private WebElement singInLink;

    @FindBy(how = How.LINK_TEXT,using = "Flights")
    private WebElement flightsLink;

    public RegistrationConfirmationPage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goToFlighDetailPage(){
        wait.until(ExpectedConditions.visibilityOf(singInLink));
        flightsLink.click();
    }

}
