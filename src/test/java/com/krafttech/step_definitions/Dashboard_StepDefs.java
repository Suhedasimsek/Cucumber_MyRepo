package com.krafttech.step_definitions;

import com.krafttech.pages.DashboardPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Dashboard_StepDefs {
    DashboardPage dashboardPage=new DashboardPage();
    @Then("The user name should be {string}")
    public void theUserNameShouldBe(String expectedName) {
       String actualName= dashboardPage.getUserName();
        Assert.assertEquals(expectedName, actualName);
    }
}
