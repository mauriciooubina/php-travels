Feature: As a potential client i need to book a flight in the PHPTravel webpage

  @Smoke
  Scenario: As a user I want to navigate PHPTravel and complete booking process
    Given The client is in php travels page
    When The client searchs for a oneway flight in economy from buenos aires to miami for the date 21-11-2020
    And its for 1 adult 0 child 0 infant
    And clicks the 1 result writing email mauriciooubina@gmail.com password estoesunapruebA123
    And completes with name Mauricio Surname Oubina email mauriciooubina@gmail.com phone 1234567890 birthday 1998-10-11 passport 12345 expiration 2022-12-22 nationality Argentina
    And pays with Visa number 4263982640269299 expiration month 2 year 2023 cvv 837
    Then A reservation number is not provide


  @Smoke
  Scenario: As a user I want to navigate PHPTravel and complete a booking process for a round trip
    Given The client is in php travels page
    When the client searchs for a round trip flight in economy from buenos aires to madrid for the date 15-12-2020 and 20-12-2020
    And its for 2 adult 1 child 1 infant
    And clicks the 1 result writing email mauriciooubina@gmail.com password estoesunapruebA123
    And completes with name Jorge Surname Lopez email jorgelopez@hotmail.com phone 1023456789 birthday 1995-3-2 passport 54342 expiration 2023-5-2 nationality Argentina
    And pays with Visa number 4263982640269298 expiration month 3 year 2022 cvv 837
    Then A reservation number is not provide
