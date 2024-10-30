Feature: This is just a test file
  #Given When Then AND But
  @apple
  Scenario: This is a demo test case
    Given User print their favorite fruit name
    When User starts writing the name
    Then They completes the statement


  @api
  Scenario Outline: Booking api testing
    Given User made a post request with "<Firstname>", "<Lastname>", "<TotalPrice>"
    When User enters "<Checkin>" & "<Checkout>" dates and provide any "<AdditionalNeeds>"
    And User receives response
    Then The totalprice should be "<ExpectedTotalPrice>"

    Examples:
      |Firstname| Lastname|TotalPrice|Checkin|Checkout|AdditionalNeeds|ExpectedTotalPrice
      |Tester1|QA1|45.25             |2018-01-01|2018-01-02|Dinner    |45.25
      |Tester1|QA1|45.25             |2018-01-01|2018-01-02|Dinner    |45.25


