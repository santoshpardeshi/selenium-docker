package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchTxt;

    @FindBy(how = How.ID, using = "search_button_homepage")
    private WebElement searchBtn;

    @FindBy(how = How.LINK_TEXT, using = "Videos")
    private WebElement videosLink;

    @FindBy(how = How.CSS, using = "[class='tile__media']")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goToDuckDuck(){
        driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String search){
        wait.until(ExpectedConditions.visibilityOf(searchTxt));
        searchTxt.clear();
        searchTxt.sendKeys(search);
        searchBtn.click();
    }

    public void goToVideo(){
        wait.until(ExpectedConditions.visibilityOf(videosLink));
        videosLink.click();
    }

    public int getResult(){
        By by = By.cssSelector("[class='tile__media']");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println("Size " + allVideos.size());
        return allVideos.size();
    }
}
