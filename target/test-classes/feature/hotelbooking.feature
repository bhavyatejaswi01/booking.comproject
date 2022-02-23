Feature: Reservation of hotel room
  I want to use this template for my feature file

  @register
  Scenario: Registration of user
    Given user is on home page and click on Register button
    When user is on Register page enter email and proceed
    Then user enter password and confirm password and proceed
    # When user get registration sucess
 
  @sign-in
  Scenario: sign-in of user
    Given user is on home page and click on sign-in button
    When user is on login page enter email and proceed
    When valid enter password and proceed
    Then user get login sucess

  @reserve
  Scenario: Reservation of a room
    Given User is on landing page
    Then Search for room with place and dates
    When user is on result page and select requried hotel
    Then in that page user reserve no.of rooms and proceed
    When enter mandotary details of customers and proceed to pay
    Then enter payment details and complete booking
    Then user gets the booking confirmation page
