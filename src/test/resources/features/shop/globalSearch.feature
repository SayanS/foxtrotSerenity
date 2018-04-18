Feature: Header - Global search

  Background: Precondition steps
    Given Home page is opened

  Scenario: Check Search results list of the Global Search field
    When Enter "SONY" into Global search field
    Then Global search drop-down list should contains "SONY"


  Scenario Outline: Check Global Search functionality
    When Global search for "<text>"
    Then Page title should contain "<text>"
    Examples:
      | text                        |
      | Телевизор SONY KDL43WE754BR |


  Scenario: Check ability to open Product details page form Search results
    When Global search for "Пылесос"
    When Open Product details page of "Пылесос ROWENTA RH9051WO"

  @run
  Scenario: Add product to cart from Search results page
    When Global search for "Пылесос"
    When Add to cart product "Пылесос-робот ECOVACS ROBOTICS DEEBOT SLIM DA 60 Lightning Green (ER-DS)" from Search results page