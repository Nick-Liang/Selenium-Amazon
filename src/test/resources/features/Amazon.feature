Feature: Amazon First Test

  @Amazon @begin  @end
  Scenario Outline: Get Landing on Home Page
    Given I am on Amazon home page
    When I click search box and type "<Beutii Keywords>"
    Then I should see search result page
    Then I will scroll to "<Item Title>"

    Examples:
      | Beutii Keywords| Item Title |
      | UV box         | Vitamin C Facial Serum     |