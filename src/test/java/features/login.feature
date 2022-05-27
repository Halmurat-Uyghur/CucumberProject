Feature: login functionality

  Scenario: valid login
    Given user on login page
    When user enter valid username and valid password
    Then user navigated to the home page


  Scenario: invalid login
    Given user on login page
    When user enter invalid username and invalid password
    Then user see error message



