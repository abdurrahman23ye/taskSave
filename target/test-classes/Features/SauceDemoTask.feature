Feature: Sauce Demo Webpages tests.

  @task
  Scenario: Test to complete an order


    Given User opens "sauceDemo" webpage
    And  User writes "username" to usernames textbox
    And  User writes "password" to passwords textbox
    And  User clicks "login" button
    And User chooses random two product and adds them to cart