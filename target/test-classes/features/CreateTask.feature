Feature: Create New Task
#  @testIOS
#  Scenario: The user can add new task
#    Given Click Add new Task
#    Given Print task number "TASK1"
#    Given Enter TaskName
#    Given Enter TaskDesc
#    When Click Save
#    Then Task added successfully
  @testIOS
  Scenario: The user can add new task again
    Given Click Add new Task
    Given Print task number "TASK2 started"
    Given Enter TaskName
    Given Enter TaskDesc
    When Click Save
    Then Task added successfully
