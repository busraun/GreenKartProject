Feature: complete purchase

  Background:
    Given user navigates home page


  Scenario Outline:
    When clicks search box
    And writes a food name and quantity "<foodName>" "<quantity>"
    And clicks Add to Cart button
    And goes to cart and complete purchase
    Then redirect to home page again



    Examples:
      | foodName | quantity |
      | cashews  | 2        |

