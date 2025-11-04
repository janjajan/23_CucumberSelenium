package com.eurotech.pages;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LoginPage extends BasePage {

//    public LoginPage(){
//        PageFactory.initElements(Driver.get(),this);
//    }

    @FindBy(css = "#email")                    // works like FINDELEMENT
    public WebElement usernameInput;

    @FindBy(id = "yourPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(css = "div[role='alert']")         // SAME ELEMENT, different error messages
    public WebElement errorMessage;

    //@FindAll
    // to use multiple locators if at least one of them is matching it will find the web elements
    @FindAll({
            @FindBy(id = "email"),
            @FindBy(name = "email"),
    })
    public WebElement usernameInputFindAll;

    // If the locators are matching with BOTH elements, will return it.
    @FindBys({
            @FindBy(id = "yourPassword"),
            @FindBy(name = "password"),
    })
    public WebElement passwordInputFindAll;

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void loginWithTeacher(){
        usernameInput.sendKeys(ConfigurationReader.get("username"));
        passwordInput.sendKeys(ConfigurationReader.get("password"));
        loginButton.click();
    }

    public String getWarningMessage(){

        return Driver.get().findElement(By.xpath("//*[contains(text(),'incorrect')]")).getText();

    }

    public String getWarningMessage(String expectedMessage){

        String actualMessage = null;
        if (expectedMessage.contains("incorrect")){
            actualMessage = Driver.get().findElement(By.xpath("//*[contains(text(),'incorrect')]")).getText();
            // OR CAN MAKE STATIC LOCATOR ABOVE IN PAGE LIST
/*        }else if (expectedMessage.contains("enter")){
            actualMessage = Driver.get().findElement(By.xpath("//*[contains(text(),'enter')]")).getText();*/
        } else if (expectedMessage.contains("password!")) {
            actualMessage = Driver.get().findElement(By.xpath("//div[contains(text(),'password!')]")).getText();
        }
        return actualMessage;
    }
}
