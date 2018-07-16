Feature: Amazon First Test

  @Amazon @begin @end
  Scenario: Get Landing on Home Page
    Given I am on Amazon home page
    When I navigate through health and customise-cover menus
    Then I should see basic details page

  @Amazon
  Scenario Outline: User fills basic details
    Given I am on basic details page
    When I fill fmaily status"<Family Status>", state"<location>", age"<Age>" and click on Next button
    Then i should see taxrebate page

    Examples: 
      | Family Status | location | Age      |
      | Single cover  | NSW       | Under 65 |

  @Amazon
  Scenario Outline: User finds taxRebate eligility
    Given I am on rebate details page
    When I select registeredas "<Registered as>", annualincome"<AnnualIncome>",displays rebate "<Rebate>"
    Then I should see hospital cover page

    Examples: 
      | Registered as | AnnualIncome       | Rebate  |
      | Individual    | $90,001 - $105,000 | 18.547% |

  @Amazon
  Scenario Outline: User selects Hospital COVER and EXTRAS
    Given I am on HOSPITAL COVER page
    When I select Hospital cover"<hospitalcover>", Extras"<extras>" and click Next button.
    Then I should see EXCESS page

    Examples: 
      | hospitalcover | extras        |
      | Mid Hospital  | Bronze Extras |

  @Amazon
  Scenario Outline: User selects HOSPITAL EXCESS can pay
    Given I am on hospital excess page
    When I select hospital excess"<excesspay>" and click Next button.
    Then I should see Cover Summary page

    Examples: 
      | excesspay |
      | $500      |

  @Amazon
  Scenario: Validate Cover Summary page
    Given I am on Cover Sumary Page
    When I validate rebate as Rebate , hospital excess as excesspay
    And I validate hospital cover and extras
    And I click on Continue Button
    Then I Should see Purchase page
    Then I Click on Purchase link to see Getting Started page

  @Amazon
  Scenario: User Confirms "Is everyone under Medicare coverage" and "Is Existing HCF Member ofverage"
    Given New I am on Getting Started page
    #Swapped the lines
    And I select not an existing HCF Member
    When I select Medical entitlement
    And I enter email address
    And I select stay in touch
    Then I Click continue to Personal details button

  @Amazon
  Scenario Outline: User provides persoanl information
    Given I am on Personal Details page
    When I select Title "<Title>" , Gender "<Gender>", Firstname, Surname
    And I fill client DOB, contact number "<Mobile>"
    And I fill Address "<Address>" and suburb"<suburb>"
    And I Want to claim rebate and fill Medicare details
    And I Switch Funds "<Switch funds>"
    And I confirm the declaration

    Examples: 
      | Title | Gender | Email               | Mobile     | Address            | suburb      | Switch funds |
      | Mr    | M      | jthumati@hcf.com.au | 0400000000 | U15 Russell Street | Strathfield | no           |

  @Amazon
  Scenario Outline: User provides Payment details information
    Given I am on Payment Details page
    When I select Payment Mode
    And I select Type of card "<cardtype>" , debit frequencey "<debitfrequency>" and Nominated Debit day
    Then I should see welcome message

    Examples: 
      | cardtype   | debitfrequency |
      | Mastercard | Fortnightly    |
