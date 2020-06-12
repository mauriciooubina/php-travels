Feature: As a potential client i need to book a flight in the PHPTravel webpage

  @Smoke
  Scenario: As a user I want to navigate PHPTravel and complete booking process
    Given The client is in php travels page
    When The client searchs for a oneway flight in economy from buenos aires to miami for the date 21-11-2020
    And its for 1 adult 0 child 0 infant
    Then A reservation number is provide
