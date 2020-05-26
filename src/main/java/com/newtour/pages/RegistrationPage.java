package com.newtour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver  driver;
    private WebDriverWait wait;

    @FindBy(how = How.NAME , using = "firstName")
    private WebElement firstNameTxt;

    @FindBy(how = How.NAME , using = "lastName")
    private WebElement lastNameTxt;

    @FindBy(how = How.NAME , using = "email")
    private WebElement usernameTxt;

    @FindBy(how = How.NAME , using = "password")
    private WebElement passwordTxt;

    @FindBy(how = How.NAME , using = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(how = How.NAME , using = "register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        driver.get("http://newtours.demoaut.com/mercuryregister.php");
        wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
    }

    public void enterFullname(String first, String last){
        firstNameTxt.clear();
        firstNameTxt.sendKeys(first);
        lastNameTxt.clear();
        lastNameTxt.sendKeys(last);
    }

    public void userCredential(String username, String passwd){
        usernameTxt.clear();
        usernameTxt.sendKeys(username);
        passwordTxt.clear();
        passwordTxt.sendKeys(passwd);
        confirmPasswordTxt.clear();
        confirmPasswordTxt.sendKeys(passwd);
    }

    public void clickSubmitBtn(){
        submitBtn.click();
    }
}
