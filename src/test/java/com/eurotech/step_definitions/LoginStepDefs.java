package com.eurotech.step_definitions;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginpage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        // 1. using Driver class GETTER method, to create browser driver. 2.
    }

    @When("The user enters teacher username and password")
    public void the_user_enters_teacher_username_and_password() {

        // First way
        // loginpage.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
        // second way
           loginpage.loginWithTeacher();
    }

    @Then("The user should be able to login")
    public void the_user_should_be_able_to_login() {

        Assert.assertTrue("WARNING: Login Failed", dashboardPage.welcomeMessage.isDisplayed());
    }

    @When("The user enters Student username and password")
    public void the_user_enters_student_username_and_password() {
        System.out.println("I enter student username and password");
    }

    @When("The user enters Developer username and password")
    public void the_user_enters_developer_username_and_password() {
        System.out.println("I enter developer username and password");
    }

    @When("The user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {

        loginpage.login(username,password);
    }

    @Then("The Welcome Message contains {string}")
    public void the_welcome_message_contains(String name) {

        Assert.assertTrue("WARNING: Welcome message does NOT contain "+name+"",dashboardPage.welcomeMessage.getText().contains(name));
    }

    @Then("Verify that warning message is {string}")
    public void verify_that_warning_message_is(String expectedMessage) {

        String actualMessage = loginpage.getWarningMessage(expectedMessage);
        Assert.assertEquals(expectedMessage,actualMessage);



    }
}
