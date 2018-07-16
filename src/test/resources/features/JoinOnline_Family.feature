Feature: Product selection:Family Cover,Age <65,$180K-$210-Join Online - Switching Funds:No

@JoinOnlineFamilyCover @begin
  Scenario: User selects customise coverage
    Given I am on HCF home page
    When I navigate through health and customise-cover menus
    Then I should see basic details page

@JoinOnlineFamilyCover
  Scenario Outline: User fills basic details
    Given I am on basic details page
    When I fill fmaily status"<Family Status>", state"<location>", age"<Age>" and click on Next button
    Then i should see taxrebate page

    Examples: 
      | Family Status | location | Age     |
      | Family cover  |NSW|Under 65|

@JoinOnlineFamilyCover
  Scenario Outline: User finds taxRebate eligility
    Given I am on rebate details page
    When I select registeredas "<Registered as>", annualincome"<AnnualIncome>",displays rebate "<Rebate>"
    Then I should see hospital cover page

    Examples: 
      | Registered as | AnnualIncome       | Rebate  |
      | Family    | $180,001 - $210,000 | 17.289% |

@JoinOnlineFamilyCover
  Scenario Outline: User selects Hospital COVER and EXTRAS
    Given I am on HOSPITAL COVER page
    When I select Hospital cover"<hospitalcover>", Extras"<extras>" and click Next button.
    Then I should see EXCESS page

    Examples: 
      | hospitalcover | extras        |
      | Mid Plus Hospital  | Bronze Plus Extras |

@JoinOnlineFamilyCover
  Scenario Outline: User selects HOSPITAL EXCESS can pay
    Given I am on hospital excess page
    When I select hospital excess"<excesspay>" and click Next button.
    Then I should see Cover Summary page

    Examples: 
      | excesspay |
      | $500      |

@JoinOnlineFamilyCover
  Scenario: Validate Cover Summary page
    Given I am on Cover Sumary Page
    When I validate rebate as Rebate , hospital excess as excesspay
    And I validate hospital cover and extras
    And I click on Continue Button
    Then I Should see Purchase page
    Then I Click on Purchase link to see Getting Started page

@JoinOnlineFamilyCover
  Scenario: User Confirms "Is everyone under Medicare coverage" and "Is Existing HCF Member ofverage"
    Given I am on Getting Started page
    #Swapped the lines
    And I Check not an existing HCF Member
    When I Check Medical entitlement    
    Then I Click Getting started and should see Join details page
    
@JoinOnlineFamilyCover
Scenario Outline: User provides persoanl information
 Given I am on Join Details page
 When I fill Title "<Title>" , Gender "<Gender>", Firstname, Surname and tick continuous cover
 And I fill client DOB
 And I fill Email "<Email>" , Mobile "<Mobile>"
 And I fill Address "<Address>", select state "<state>" 
 And I fill partner Title "<PartnerTitle>" , Gender "<PartnerGender>", Firstname, Lastname and DOB
 And I fill dependent Title "<DepTitle>" , Gender "<DepGender>", Firstname, Lastname and DOB
 And I do not want to claim government rebate 
 And I do not switch partner funds
 And I Switch Funds "<Switch funds>" 
 And I confirm the declaration

 Examples:
 |Title|Gender|Email|Mobile|Address|state|Switch funds|PartnerTitle|PartnerGender|DepTitle|DepGender|
 |Mr|M|EPermanent@hcf.com.au|0400000000|U15 Russell Street|NSW|no|Mrs|F|Master|M|
 
 
@JoinOnlineFamilyCover @end
Scenario Outline: User provides Payment details information
 Given I am on Payment Details page 
 When I select First Payment Mode as Pay now
 And I select Type of card "<cardtype>" and card details for one-off payment 
 #And I select regular payment frequency "<debitfrequency>" and Nominated Debit day 
 And I select regular payment frequency "<debitfrequency>" and wish to pay by Ezipay direct debit
 Then I should see welcome message

Examples:
 |cardtype|debitfrequency|
 |Mastercard|Monthly|