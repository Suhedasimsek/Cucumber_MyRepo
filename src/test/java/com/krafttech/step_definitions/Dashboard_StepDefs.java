package com.krafttech.step_definitions;

import com.krafttech.pages.DashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Dashboard_StepDefs {
    DashboardPage dashboardPage=new DashboardPage();
    @Then("The user name should be {string}")
    public void theUserNameShouldBe(String expectedName) {
       String actualName= dashboardPage.getUserName();
        Assert.assertEquals(expectedName, actualName);
    }
    @When("The user navigates to {string} menu")
    public void the_user_navigates_to_menu(String tabName) {
        dashboardPage.naviagateToTab(tabName);
    }
    @Then("The user should be able to see home name as {string}")
    public void the_user_should_be_able_to_see_home_name_as(String expectedHomeName) {
        String actualHomeName= dashboardPage.getHomeName(expectedHomeName);
        Assert.assertEquals(expectedHomeName,actualHomeName);


    }
}
