package com.krafttech.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefs {
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Given");
    }

    @When("The user enters Mike credentials")
    public void the_user_enters_mike_credentials() {
        System.out.println("When Mike");
    }

    @Then("The user should be able to login")
    public void the_user_should_be_able_to_login() {
        System.out.println("Then");
    }

    @When("The user enters Sebastian credentials")
    public void theUserEntersSebastianCredentials() {
        System.out.println("When Sebastian");
    }

    @When("The user enters John Nash credentials")
    public void theUserEntersJohnNashCredentials() {
        System.out.println("When Sebastian");
    }
}

