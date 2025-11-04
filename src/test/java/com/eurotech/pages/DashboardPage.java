package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;
import java.util.List;

public class DashboardPage extends BasePage {

//    public DashboardPage(){
//        PageFactory.initElements(Driver.get(),this);
//    }

    //!! DO NOT NEED PAGE FACTORY WHEN BASE HAS IT!

    @FindBy(css = "div[class='card'] h2")
    public WebElement welcomeMessage;

    @FindBy(css = ".d-none.d-md-block.dropdown-toggle.ps-2")
    public WebElement myAccountBtn;

    @FindBy(xpath = "//span[text()='My Profile']")
    public WebElement myProfileBtn;

    @FindBy(xpath = "//button[@role=\"tab\"][contains(text(),'Experience')]")
    public WebElement addExperienceTab;

    @FindBy(xpath = "//button[@role=\"tab\"][contains(text(),'Edit')]")
    public WebElement editProfileTab;

    @FindBy(xpath = "//button[text()='Add Education'][@tabindex='-1']")
    public WebElement addEducationTab;

    @FindBy(xpath = "//button[@role=\"tab\"][contains(text(),'Overview')]")
    public WebElement profileOverviewTab;

    //can probably make dynamic tabs with //button[@role="tab"] or [@tabindex='-1']

    @FindBy(xpath = "//*[text()='Full Name']/following-sibling::div")
    public WebElement userFullName;

    @FindBy(xpath = "//*[text()='Job']/following-sibling::div")
    public WebElement userJob;

    @FindBy(xpath = "//*[text()='Email']/following-sibling::div")
    public WebElement userEmail;

    @FindBy(xpath = "//*[contains(text(),'Bootcamp')]/following-sibling::div/input")
    public WebElement schoolOrBootcampField;

    @FindBy(xpath = "//*[contains(text(),'Certificate')]/following-sibling::div/input")
    public WebElement degreeOrCertificateField;

//    @FindBy(css = "#fromdate")
//    public WebElement studyFromDate;


    @FindBy(xpath = "//button[@name='submit'][contains(text(),'Experience')]")
    public WebElement saveExperienceBtn;

    @FindBy(xpath = "//button[contains(text(),'Save Changes')]")
    public WebElement saveChangesBtn;

    @FindBy(xpath = "//button[@name='submit'][contains(text(),'Education')]")
    public WebElement saveEducationBtn;

    @FindBy(xpath = "//span[contains(@class,'afm')]")
    public List<WebElement> dashboardMenu;


    public void navigateMyAccount(){
        myAccountBtn.click();;
        myProfileBtn.click();
    }


    // When you have several LOCATORS with similar PATH but different TEXT, can use METHODS to call withut making
    // many separate entries
    public String getUserInfoEditProfile(String locator){
       return Driver.get().findElement(By.id(locator)).getAttribute("value");
    }

    public String getUserInfoOverview(String info){
        return Driver.get().findElement(By.xpath("//div[text()='"+info+"']/following-sibling::div")).getText();
    }


    public void editUserInfo(String info){

        Driver.get().findElement(By.xpath
                ("//label[contains(text(),'"+info+"')]/following-sibling::div/input")).click();
    }

    public String getEducationRecord(String info){

       return Driver.get().findElement(By.xpath
               ("//h5[text()='Education Details']/parent::div//tbody//span[text()='"+info+"']")).getText();
    }


}
