Feature: Amazon First Test

  @Amazon @begin  @end
  Scenario Outline: Get Landing on Home Page
    Given I am on Amazon home page
    When I click search box and type "<Beutii Keywords>"
    Then I should see search result page

    Examples:
      | Beutii Keywords|
      | UV box  |
      | sexy Lingerie |