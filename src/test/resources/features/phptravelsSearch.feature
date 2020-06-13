Feature: As a potential client i need to book a flight in the PHPTravel webpage

  @Smoke
  Scenario: As a user I want to navigate PHPTravel and complete booking process
    Given The client is in php travels page
    When The client searchs for a oneway flight in economy from buenos aires to miami for the date 21-11-2020
    And its for 1 adult 0 child 0 infant
    And clicks the 1 result writing email mauriciooubina@gmail.com password estoesunapruebA123
    And completes with name Mauricio Surname Oubina email mauriciooubina@gmail.com phone 1234567890 birthday 1998-10-11 passport 12345 expiration 2022-12-22 nationality Argentina
    And pays with Visa number 4263982640269299 expiration month 2 year 2023 cvv 837
    Then A reservation number is provide
