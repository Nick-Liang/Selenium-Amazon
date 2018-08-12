Feature: Amazon First Test

  @Amazon @begin  @reuseSession
  Scenario: Get Landing on Home Page
    Given I am on Amazon home page

  @Amazon @reuseSession
  Scenario Outline: Check Login Status, logon when it's not
    Given I am not logged in
    When I hover my mouse on sign-in area and click through to login page
    Then I input my email address "<username>"
    Then I input my password "<password>"
    Then I should be redirect back to home page with logged in

    Examples:
    | username| password |
    | nick.liang.au@gmail.com | goalgoal313429 |

  @Amazon @reuseSession
  Scenario Outline: Search Items and have a look
    Given I am on Amazon home page
    When I click search box and type "<Keywords>"
    Then I should see search result page
    Then I will scroll to "<ASIN>"
    When I click add to cart
    Then I should see add cart successful page
    Examples:
      | Keywords     | ASIN |
      | bodystocking | B07CWPW9DY |

  @Amazon @end
  Scenario Outline: Close my browser
    Given I am signing out
    When All tests are completed
    Then I should send an email to "<To>", from "<From>", with msg "<Message>" and password is "<Password>"
    Examples:
      | To     | From | Message | Password |
      | simon@monamii.cn;conan@monamii.cn | notification@monamii.cn | Cart is ready please login <b>nick.liang.au@gmail.com</b> to check | welcome?12345 |

