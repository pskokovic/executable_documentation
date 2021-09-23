Feature: Modify logged in user's details

# todo: Exercise 1 - implement missing scenario steps

  Scenario: Modify valid user's details
    Given I am logged in
    When I am on the EditProfile page
    And I modify my profile details
    Then My profile details are saved