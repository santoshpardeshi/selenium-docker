package com.newtour.pages;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//font[contains(text(),'Confirmation')]")
    private WebElement flightConfirmationHeader;

    @FindBy(how = How.XPATH, using = "//font[contains(text(),'USD')]")
    private List<WebElement> prices;

    @FindBy(how = How.NAME, using = "buyFlights")
    private WebElement buyFlightsBtn;

    @FindBy(how = How.LINK_TEXT, using = "SIGN-OFF")
    private WebElement singOffLink;

    public FlightConfirmationPage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public String getPrice(){
        wait.until(ExpectedConditions.visibilityOf(flightConfirmationHeader));
        System.out.println(flightConfirmationHeader.getText());
        System.out.println(prices.get(1).getText());
        String price = prices.get(1).getText();
        singOffLink.click();
        return price;
    }
}
