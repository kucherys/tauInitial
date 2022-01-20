Feature: Verify product carousel page functionality

  @carousel
  Scenario: Verify elements on product carousel page
    Given Appium server with "Android" real application is running
    When I verify landing page is loaded
    And I log in to product carousel page
    And I verify product carousel page is loaded
    Then I verify elements on product carousel page
      | pageNumber | logoText                     | instructionText                                  | openBankAccountButton | eligibilityLabel |
      | 2          | Achieve your financial goal  | Make your money work harder with our Savings Pot | Open bank account     | Am I eligible?   |
      | 3          | Discover exciting new deals  | Enjoy exclusive offers from our partners         | Open bank account     | Am I eligible?   |
      | 4          | Financing at your fingertips | Apply online hassle-free                         | Open bank account     | Am I eligible?   |
      | 1          | Manage your money on the go  | Stay in control with our Savings Account-i       | Open bank account     | Am I eligible?   |
#    When I verify if I am eligible
#    And I verify Eligibility criteria modal is loaded
#    Then I verify elements on Eligibility criteria modal
#      | I am a Malaysian with a MyKad, residing in Malaysia                       |
#      | I am aged 18 years and above                                              |
#      | I have an existing internet banking account with another bank in Malaysia |
#      | I am NOT a US person                                                      |
#      | I am NOT a tax resident in any other country                              |
#      | I am a new Al-Rajhi bank customer applying for an individual account      |
#    And I close eligibility modal




