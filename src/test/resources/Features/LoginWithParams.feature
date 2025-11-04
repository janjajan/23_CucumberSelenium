Feature: Log in as different users
    ## SAME TESTS, DIFFERENT DATA  --- DATA DRIVEN TESTING

  Background:
    Given The user is on the login page
  # CANNOT BE USED WHEN PARAMETERS ARE USED

#  Scenario: Login as student with parameters
#
#    When  The user logs in using "johndoe@gmail.com" and "Hello12345!"
#    Then  The user should be able to login
#    Then  The Welcome Message contains "John"
#
#    # These steps are reusable, so copy/pasting these steps will not require extra work
#
#  Scenario: Login as teacher with parameters
#
#    When  The user logs in using "janine.daniels@hotmail.com" and "abc123"
#    Then  The user should be able to login
#    Then  The Welcome Message contains "Janine"

  Scenario Outline: Different User Type "<name>"

    When  The user logs in using "<username>" and "<password>"
    Then  The user should be able to login
    Then  The Welcome Message contains "<name>"

    Examples:
      | username                   | password    | name    |
      | johndoe@gmail.com          | Hello12345! | John    |
      | eurotech@gmail.com         | Test54321!  | Teacher |
      | janine.daniels@hotmail.com | abc123      | Janine  |