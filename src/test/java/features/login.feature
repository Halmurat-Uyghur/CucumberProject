Feature: login functionality

  Scenario: valid login
    Given user open google page
    When user search "haha"
    Then user navigated to the home page


  Scenario: invalid login
    Given user on login page
    When user enter invalid username and invalid password
    Then user see error message



