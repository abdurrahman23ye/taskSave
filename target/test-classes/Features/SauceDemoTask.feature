Feature: Sauce Demo Webpages tests.

  @task
  Scenario: Test to complete an order


    Given User opens "sauceDemo" webpage
    And  User writes "username" to usernames textbox
    And  User writes "password" to passwords textbox
    And  User clicks "login" button
    And User chooses random two product and adds them to cart
    And User clicks "cart" button
    And User clicks "checkout" button
    And User fills name,last name and zip code infos to the textboxs
    And  User clicks "continue" button
    And User verifies added products and total price
    And User clicks "finish" button
    And User verifies complete transaction by the see the text that include "Thank you"
    Then User close web page
