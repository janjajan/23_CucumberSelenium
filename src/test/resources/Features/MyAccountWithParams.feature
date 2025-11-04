Feature: My Account With Parameters

  Background:
    Given The user is on the login page
    When  The user enters Student login "johndoe@gmail.com" and "Hello12345!"
    Then  The user should be able to login
    Then  The Welcome Message contains "John Doe"
    When  The user clicks the user account button


  @Teacher @username
  Scenario: Validate username for Teacher
    Given The user is on the login page
    When  The user logs in using "janine.daniels@hotmail.com" and "abc123"
    Then  The user should be able to login
    Then  The Welcome Message contains "Janine"
    When  The user clicks the user account button
    # ^^ call a METHOD with multiple actions in it
    Then  The user should be able to see their profile "Job" is "QA Automation Engineer"
    When  The user clicks the "Edit Profile" tab
    Then  The user should be able to edit their Full Name text


  @Student
  Scenario: Add new job as Student
    Given The user is on the login page
    When  The user enters Student login "johndoe@gmail.com" and "Hello12345!"
    Then  The user should be able to login
    Then  The Welcome Message contains "John Doe"
    When  The user clicks the user account button
    Then  The user should be able to see their profile "Company" is "School"
    When  The user clicks the "Add Experience" tab
    Then  The user can see their Job Title

@Manager
  Scenario: Get Manager school
    Given The user is on the login page
    When  The user enters Manager login "ms_manager@gmail.com" and "HelloWorld1!"
    Then  The user should be able to login
    Then  The Welcome Message contains "Manager"
    When  The user clicks the user account button
    Then  The user should be able to see their profile "Email" is "ms_manager@gmail.com"
    When  The user clicks the "Add Education" tab
    Then  The user can see their school