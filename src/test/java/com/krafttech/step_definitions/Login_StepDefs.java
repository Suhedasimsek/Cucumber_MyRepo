package com.krafttech.step_definitions;

import com.krafttech.pages.DashboardPage;
import com.krafttech.pages.LoginPages;
import com.krafttech.utilities.BrowserUtils;
import com.krafttech.utilities.ConfigurationReader;
import com.krafttech.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class Login_StepDefs {
    LoginPages loginPages=new LoginPages();
    DashboardPage dashboardPage=new DashboardPage();
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
    @Given("User should be on the login page")
    public void user_should_be_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }
    @When("User should input login information")
    public void user_should_input_login_information() {
        loginPages.loginUser();

    }
    @Then("User should be on home page")
    public void user_should_be_on_home_page() {
        BrowserUtils.waitFor(2);
        String actualTitle=Driver.get().getTitle();
        System.out.println(actualTitle);
        String expectedTitle="Dashboard - Kraft Techex Lab - aFm";
        Assert.assertEquals(expectedTitle,actualTitle);

    }


    @When("User should input {string} and {string}")
    public void userShouldInputAnd(String email, String password) {
        loginPages.loginWithParameters(email, password);

    }
    @Then("User should input following credentials")
    public void user_should_input_following_credentials(Map<String,String> userInfo) {
        loginPages.loginWithParameters(userInfo.get("email"), userInfo.get("password"));
        String actualName=dashboardPage.getUserName();
        String expectedName=userInfo.get("Name");
        Assert.assertEquals(expectedName,actualName);

    }
    @Then("The warning message contains {string}")
    public void the_warning_message_contains(String expectedWarningMessage) {
        BrowserUtils.waitFor(1);
        String actualWarningMessage = loginPages.getWarningMessageText(expectedWarningMessage);
        Assert.assertEquals(expectedWarningMessage,actualWarningMessage);
    }

}

