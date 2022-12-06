@Login
Feature: Krafttech Log in Test
@Mike
  Scenario: Login as Mike
    Given The user is on the login page
    When The user enters Mike credentials
    Then The user should be able to login
@Sebastian @smoke
  Scenario: Login as Sebastian
    Given The user is on the login page
    When The user enters Sebastian credentials
    Then The user should be able to login
@John
  Scenario: Login as John Nash
    Given The user is on the login page
    When The user enters John Nash credentials
    Then The user should be able to login