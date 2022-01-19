Feature: Check landing page

  @landIOS
  Scenario: Verify elements on landing page for iOS
    Given Appium server with "iOS" real application is running
    When I print login button name
    And I print SignIn button name
    Then I confirm tests completed with result "IOS TEST PASSED"



  @landAndroid
  Scenario: Verify elements on landing page for Android
    Given Appium server with "Android" real application is running
    When I print login button name
    And I print SignIn button name
    Then I confirm tests completed with result "REAL Android APP TEST PASSED SUCCESS"