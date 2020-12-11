@login
Feature: Login

  Scenario Outline: Login with valid username and valid password on <browser>
    Given I already open sentinel login page on <browser>
    When I input username
    And I input password
    And I click login button
    Then Login success

    Examples:
    | browser |
    | firefox |
    | chrome  |
    | safari  |