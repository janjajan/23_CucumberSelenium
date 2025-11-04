package com.eurotech.step_definitions;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class DashboardStepDefs {

    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();

    @Then("The user should be able to see following menus")
    public void the_user_should_be_able_to_see_following_menus(List<String> expectedMenuList) {

        System.out.println("menuNames.size() = " + expectedMenuList.size());
        System.out.println("menuNames = " + expectedMenuList);

        System.out.println("BrowserUtils.getElementsText(dashboardPage.dashboardMenu) = "
                + BrowserUtils.getElementsText(dashboardPage.dashboardMenu));

        Assert.assertEquals(expectedMenuList,BrowserUtils.getElementsText(dashboardPage.dashboardMenu));
    }


    @When("The user logs in using the following credentials")
    public void theUserLogsInUsingTheFollowingCredentials(Map<String,String> userCredentials) {
        // first way
//        loginPage.usernameInput.sendKeys(userCredentials.get("username"));
//        loginPage.passwordInput.sendKeys(userCredentials.get("password"));
//        loginPage.loginButton.click();

        // second way
        loginPage.login(userCredentials.get("username"), userCredentials.get("password"));

        Assert.assertTrue(dashboardPage.welcomeMessage.getText().contains(userCredentials.get("message")));
    }
}
