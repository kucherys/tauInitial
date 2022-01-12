#EXPERIMENTAL FRAMEWORK
Feature: Verify landing page functionality

  @landIOS
  Scenario: Verify elements on landing page for iOS
    Given Appium server and simulator with application type "iOS" started
    When I print text "HELLO IOS"
    Then I print login button name
    And I confirm tests completed with result "IOS TEST PASSED" and stop Appium server


#  @landAndroid
#  Scenario: Verify elements on landing page for Android
#    Given Appium server and simulator with application type "Android" started
#    When I print text "HELLO Android"
#    Then I print login button name
#    And I confirm tests completed with result "Android TEST PASSED" and stop Appium server

