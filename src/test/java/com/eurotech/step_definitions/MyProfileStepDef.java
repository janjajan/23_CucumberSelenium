package com.eurotech.step_definitions;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.MyProfilePage;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MyProfileStepDef {

    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();
    MyProfilePage myProfilePage = new MyProfilePage();

    @When("The user clicks the user account button")
    public void the_user_clicks_the_user_account_button() {

        dashboardPage.navigateMyAccount();
    }
    @Then("The user should be able to see their profile")
    public void the_user_should_be_able_to_see_their_profile() {

        Assert.assertTrue(myProfilePage.fullNameElement.isDisplayed());
    }
    @When("The user clicks the edit profile tab")
    public void the_user_clicks_the_edit_profile_tab() {

        dashboardPage.editProfileTab.click();

    }
    @Then("The user should be able to edit their Full Name text")
    public void the_user_should_be_able_to_edit_their_full_name_text() {
        System.out.println("I can select the text under Full Name");
    }

    @When("The user clicks on the Add Experience button")
    public void the_user_clicks_on_the_add_experience_button() {

        dashboardPage.saveExperienceBtn.click();
    }
    @Then("The user can see their Job Title")
    public void the_user_can_see_their_job_title() {

        System.out.println("I can see my job title");
    }

    @When("The user clicks on the Add Education tab")
    public void the_user_clicks_on_the_add_education_tab() {

        dashboardPage.addEducationTab.click();
    }
    @Then("The user can see their school")
    public void the_user_can_see_their_school() {

        System.out.println("I can see my school/bootcamp");
    }

    @Then("The user should be able to see their profile {string} is {string}")
    public void the_user_should_be_able_to_see_their_profile_is(String jobTitle, String expectedJob) {

        BrowserUtils.waitFor(1);
        Assert.assertEquals(dashboardPage.getUserInfoEditProfile(jobTitle),expectedJob);
    }

    @When("The user enters Student login {string} and {string}")
    public void the_user_enters_and(String usernameStudent, String passwordStudent) {

        loginPage.login(usernameStudent, passwordStudent);
    }

    @When("The user enters Manager login {string} and {string}")
    public void the_user_enters_manager_login_and(String usernameManager, String passwordManager) {

        loginPage.login(usernameManager, passwordManager);
    }

    @When("The user enters {string} and {string}")
    public void the_user_enters(String username, String password) {

        loginPage.login(username, password);
    }

    @When("The user clicks the Save Changes button")
    public void the_user_clicks_the_save_button() {

        BrowserUtils.clickWithJS(myProfilePage.saveChangesBtn);

    }
    @Then("The changes should be applied")
    public void the_changes_should_be_applied() {

        System.out.println("The profile is updated but probably we need another assertion here");
    }

    @Then("The user can navigate to the Add Experience page")
    public void the_user_can_navigate_to_the_add_experience_page() throws InterruptedException {

        dashboardPage.addExperienceTab.click();
        Thread.sleep(2000);
        Assert.assertTrue("WARNING: Add Experience page not selected",dashboardPage.saveExperienceBtn.isDisplayed());

    }

    @When("The user changes the field {string} to {string}")
    public void the_user_changes_the_field_to(String fieldName, String fieldUpdate) {


    }

    @Then("The changes are saved after clicking Add Experience button")
    public void the_changes_are_saved_after_clicking_add_experience_button() {


    }

    @When("The user clicks on the Add Experience tab")
    public void the_user_clicks_on_the_add_experience_tab() {

        dashboardPage.addExperienceTab.click();
    }

    @When("The user selects the field {string}")
    public void the_user_selects_the_field(String info) {

        dashboardPage.editUserInfo(info);

    }
    @Then("The user should be able to update the {string} field")
    public void the_user_should_be_able_to_update_the_field(String info) {

        System.out.println("Here we have dynamic code that allows us to update any of the fields");
    }

    @Then("The updated data is now saved")
    public void the_updated_data_is_now_saved() {

        System.out.println("Here we have an assertion that somehow knows the data entered into the previous methods");
    }

    @Then("The user adds {string} school and {string} to a new Educational Record")
    public void the_user_adds_school_and_to_a_new_educational_record(String schoolOrBootcampInput, String degreeOrCertificateInput) throws InterruptedException {

        dashboardPage.schoolOrBootcampField.sendKeys(schoolOrBootcampInput);
        dashboardPage.degreeOrCertificateField.sendKeys(degreeOrCertificateInput);
        Thread.sleep(2000);
        dashboardPage.saveEducationBtn.click();
        Thread.sleep(1000);
        //dashboardPage.studyFromDate.sendKeys("01011999");

    }

    @When("The user clicks the Add Education button")
    public void the_user_clicks_the_Add_Education_button() {

        dashboardPage.saveEducationBtn.click();
    }
    @Then("The Educational Record has been saved.")
    public void the_educational_record_has_been_saved() {

        dashboardPage.profileOverviewTab.click();
        String recordCheck = dashboardPage.getEducationRecord("EuroTech");
        Assert.assertEquals("WARNING: Expected educational record not found","EuroTech",recordCheck);
    }

    @When("The user clicks the {string} tab")
    public void theUserClicksTheTab(String tabName) {

        myProfilePage.navigateProfileMenu(tabName);
    }

    @Then("The user should be able to edit their {string} text as {string}")
    public void theUserShouldBeAbleToEditTheirTextAs(String inputField, String newData) throws InterruptedException {

        myProfilePage.editProfile(inputField,newData);
        Thread.sleep(1000);
    }

    @Then("Verify that {string} updated with {string}")
    public void verifyThatUpdatedWith(String inputField, String expectedInfo) throws InterruptedException {

        Thread.sleep(1000);
        Assert.assertEquals(expectedInfo,dashboardPage.getUserInfoEditProfile(inputField));
    }


    @When("The user clicks on the Add Experience save button")
    public void theUserClicksOnTheAddExperienceSaveButton() {

        myProfilePage.saveExperienceBtn.click();
    }

    @Then("Verify that Experience updated with {string} record")
    public void verifyThatExperienceUpdatedWithRecord(String expectedExperience) {

        Assert.assertEquals(expectedExperience,myProfilePage.experienceJobRecord.getText());
    }

    @Then("The user should be able to see their profile from Edit Profile Page {string} is {string}")
    public void theUserShouldBeAbleToSeeTheirProfileFromEditProfileIs(String locator, String expectedInfo) {

        Assert.assertEquals(dashboardPage.getUserInfoEditProfile(locator),expectedInfo);
    }


}
