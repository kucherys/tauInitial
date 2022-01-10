Feature: Create New Task
  @testIOS
  Scenario: The user can add new task
    Given Click Add new Task
    Given Enter TaskName
    Given Enter TaskDesc
    When Click Save
    Then Task added successfully
