package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePage{

    @FindBy(xpath = "//*[text()='Full Name']")
    public WebElement fullNameElement;

    @FindBy(xpath = "//button[text()='Save Changes']")
    public WebElement saveChangesBtn;

    @FindBy(xpath = "//*[text()='Add Experience'][@value='experience']")
    public WebElement saveExperienceBtn;

    @FindBy(xpath = "//span[text()='Manager']")
    public WebElement experienceJobRecord;

    public void navigateProfileMenu(String tabName){

        Driver.get().findElement(By.xpath("//*[text()='"+tabName+"'][@role='tab']")).click();
    }

    public void editProfile(String inputField,String newData){
        WebElement inputBox= Driver.get().findElement(By.xpath("//label[contains(text(),'"+inputField+"')]/following-sibling::div/input"));
        inputBox.clear();
        inputBox.sendKeys(newData);
    }


}
