@Login
Feature: Krafttech Log in Test
  Background:
    Given User should be on the login page
@Mike
  Scenario: Login as Mike

    When The user enters Mike credentials
    Then The user should be able to login
@wip @smoke
  Scenario: Login as Sebastian

    When The user enters Sebastian credentials
    Then The user should be able to login
@John
  Scenario: Login as John Nash

    When The user enters John Nash credentials
    Then The user should be able to login

  Scenario: User should be abe to login with valid credentilas

    When User should input login information
    Then User should be on home page

  Scenario: Login with parameters

    When User should input "user11@test.com" and "Test123456"
    Then User should be on home page


  Scenario: Login as a given user

    Then User should input following credentials

      | email    | user22@test.com |
      | password | Test123456      |
      | Name     | User22          |

  Scenario Outline: Data table and scenario outline
    Then User should input following credentials

      | email    | <userEmail> |
      | password | <password>  |
      | Name     | <name>      |

    Examples:
      | userEmail               | password   | name           |
      | user22@test.com         | Test123456 | User22         |
      | eddiem@kraft.com        | eddiem12   | Eddie Murphy   |
      | morganfreeman@kraft.com | mfreeman   | Morgan Freeman |