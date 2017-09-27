Feature: Buy books

# todo: Exercise - implement scenario steps

  Scenario: Buy a book, whole process
    Given I am logged in as User1
    When I add book Autumn Colors to basket
    And I buy selected books
    Then I see that the order is accepted

  Scenario: Buy several copies of one book
    Given I am logged in as User1
    When I add book Autumn Colors to basket
    And I order 3 copies of Autumn Colors book
    And I buy selected books
    Then I see that the order is accepted