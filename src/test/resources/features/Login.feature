Feature: Krafttech Log in Test

  Scenario: Login as Mike
    Given The user is on the login page
    When The user enters Mike credentials
    Then The user should be able to login

  Scenario: Login as Sebastian
    Given The user is on the login page
    When The user enters Sebastian credentials
    Then The user should be able to login

  Scenario: Login as John Nash
    Given The user is on the login page
    When The user enters John Nash credentials
    Then The user should be able to login