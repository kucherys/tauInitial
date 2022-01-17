Feature: Create New Task

  @testIOS
  Scenario: The user can add new task again
    Given Appium server with "iOS" application is running
    Given Click Add new Task
    Given Print task number "EXPEREMENTAL app WITH ADDED CAPABILITIES 4"
    Given Enter TaskName
    Given Enter TaskDesc
    When Click Save
    Then Task added successfully

  @landingIOS
  Scenario: Verify elements on landing page for iOS
    Given Appium server with "iOS" real application is running
    When I print login button name
    And I print SignIn button name
    Then I confirm tests completed with result "IOS TEST PASSED"

