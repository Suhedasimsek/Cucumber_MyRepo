package com.krafttech.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefs {
    @Given("The user is on the Login page")
    public void the_user_is_on_the_login_page() {

        System.out.println("Batch 2 was here");
        System.out.println("O open the browser and navigate to Krafttech web page");

    }

    @When("The user enters Mike credentials")
    public void the_user_enters_mike_credentials() {
        System.out.println("I enter Mike username and password and click login button");

    }

    @Then("The user should be able to login")
    public void the_user_shoult_be_able_to_login() {
        System.out.println("I verify that url changed Dashboard page");
    }

    @When("The user enters Sebastian credentials")
    public void theUserEntersSebastianCredentials() {
        System.out.println("I enter Sebastian username and password and click login button");
    }

    @When("The user enters Jhon Nash credentials")
    public void theUserEntersJhonNashCredentials() {
        System.out.println("I enter Jhon Nash username and password and click login button");
    }

    @When("The user enters John Nash credentials")
    public void theUserEntersJohnNashCredentials() {
        System.out.println("I enter Jhon Nash username and password and click login button");
    }

    @Given("The user is on the login page")
    public void theUserIsOnTheLoginPage() {
        System.out.println("O open the browser and navigate to Krafttech web page");
    }
}
