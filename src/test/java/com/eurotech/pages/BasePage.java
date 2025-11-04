package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    // Abstracting PROTECTS base page
    // dont want to create objects from here - not a REAL page, just a blueprint for other pages
    // abstract is so users do not try to create objects from this non-existent page


    //Initialises elements! Required for ALL pages
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//span[text()='Dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//span[text()='Developers']")
    public WebElement developersButton;

    //MAKE LOCATORS DYNAMIC WHEN THEY ARE THE SAME EXCEPT FOR THE TEXT

    public void navigateToMenu(String menuName){                            // accepts name of button as param, adds to xpath
        Driver.get().findElement(By.xpath("//span[text()='"+menuName+"." +
                "']")).click();
                                                                            // locate 6 locators with 1 method
    }




}


