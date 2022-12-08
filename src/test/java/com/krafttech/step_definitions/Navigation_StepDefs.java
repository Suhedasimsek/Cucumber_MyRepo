package com.krafttech.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Navigation_StepDefs {

    @Then("go to Developers menu and get the text of Developer")
    public void goToDevelopersMenuAndGetTheTextOfDeveloper() {
        System.out.println("Then");

    }

    @When("Get the text of dashboard")
    public void getTheTextOfDashboard() {
        System.out.println("When");
    }

    @Then("go to Edit Profile menu and get the text of Edit User Profile")
    public void goToEditProfileMenuAndGetTheTextOfEditUserProfile() {
        System.out.println("Then");
    }

    @Then("go to My Profile menu and get the text of User Profile")
    public void goToMyProfileMenuAndGetTheTextOfUserProfile() {
        System.out.println("Then");
    }



}


