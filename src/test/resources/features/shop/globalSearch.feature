Feature: Header - Global search

  Background: Precondition steps
    Given Home page is opened

  @old
  Scenario: Check Search results list of the Global Search field
    When Enter "SONY" into Global search field
    Then Global search drop-down list should contains "SONY"

  @old
  Scenario Outline: Check Global Search functionality
    When Global search for "<text>"
    Then The Title of Search results page should contain "<text>"
    Examples:
      | text                        |
      | Телевизор SONY KDL43WE754BR |

  @run
  Scenario: Check ability to open Product details page form Search results
    When Global search for "Пылесос"
    When Open Product details page of "Пылесос циклонный ROWENTA RO539621"

  @old
  Scenario: Check ability to Add product to the cart from Search results page
    When Global search for "Пылесос"
    When Click on Add to cart button for product "Пылесос THOMAS Perfect Air Animal Pure" on Search results page
    Then PreCart pop-up should be opened
    Then PreCart pop-up should contain product "Пылесос THOMAS Perfect Air Animal Pure"
    When Click on Go to Cart button on PreCart pop-up

  @old
  Scenario: Check ability to Add product to the Cart from Shop page
    When Select "Смартфоны" from the Header Catalog menu
    When Click on Add to Cart button for items number
      | 1 |
      | 2 |
      | 3 |


  @old
  Scenario Outline: Check ability to open Shop page for appropriate Product group
    When Select "<itemName>" from the Header Catalog menu
    Then URL of the Current page should contain "<pageName>"
    Then Shop page should be opened with "<title>"
    Examples:
      | itemName   | pageName                     | title      |
      | Смартфоны  | /shop/mobilnye_telefony.html | Смартфоны  |
      | Телевизоры | /shop/led_televizory.html    | Телевизоры |
#      | Ноутбуки          | /shop/noutbuki.html          | Ноутбуки           |
#      | Холодильники      | /shop/holodilniki.html       | Холодильники       |
#      | Стиральные машины | /shop/stiralki.html          | Стиральные машины  |
#      | Обогреватели      | /portal-obogrevateli.html    | Обогреватели       |
#      | Пылесосы          | /shop/pylesosy.html          | Пылесосы           |
#      | Микроволновки     | /shop/mikrovolnovki.html     | Микроволновые печи |

  @old
  Scenario: Check email notification
    When Read email messages with credentials
      | email      | lloydp2017@gmail.com |
      | password   | Rfhfylfitkm12r       |
      | imapServer | imap.gmail.com       |
      | imapPort   | 993                  |



