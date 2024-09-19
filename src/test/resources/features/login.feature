Feature: Log into the system

  @basic
  Scenario: Log into ECOMM with one valid user
    Given I am on the Login page
    When I log in as User1
    Then I am logged in

  @outline
  Scenario Outline: Log into ECOMM with all users
    Given I am on the Login page
    When I enter <user> credentials
    And I log in
    Then I am logged in
    Examples:
      | user  |
      | User1 |
      | User2 |
      | User3 |
      | User4 |
      | User5 |
