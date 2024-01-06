Feature: Search Food

  Background:
    Given user navigates home page

  Scenario Outline:
    When clicks search box
    And writes a vegetable or fruit name "<foodName>"
    And clicks search button
    Then sees the "<foodName>"

    Examples:
      | foodName |
      | banana   |
      | pear     |
      | beans    |


