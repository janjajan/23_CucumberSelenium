Feature: Negative Login Test


  Scenario Outline: Negative Login Test

    Given The user is on the login page
    When  The user logs in using "<username>" and "<password>"
    Then  Verify that warning message is "<Warning Message>"

    Examples:
        #!! Use method with IF statements to search for different key words for different locators, but same CODE
      | username             | password       | Warning Message                          |
      | eurotech@gmail.com   | Wrong Password | Password is incorrect. Please check      |
      | WRONGEMAIL@gmail.com | Test54321!     | Email address is incorrect. Please check |
      | eurotech             | Test54321!     | Email address is incorrect. Please check |
      |                      | Test54321!     | Please enter your email.                 |
      | eurotech@gmail.com   |                | Please enter your password!              |




