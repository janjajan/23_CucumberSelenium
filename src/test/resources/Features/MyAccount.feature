Feature: My Account Menu

  Scenario: Validate username for Teacher
    Given The user is on the login page
    When  The user enters teacher username and password
    Then  The user should be able to login
    When  The user clicks the user account button
    Then  The user should be able to see their profile
    When  The user clicks the edit profile button
    Then  The user should be able to edit their Full Name text


  Scenario: Add new job as Student
    Given The user is on the login page
    When  The user enters Student username and password
    Then  The user should be able to login
    When  The user clicks the user account button
    Then  The user should be able to see their profile
    When  The user clicks on the Add Experience button
    Then  The user can see their Job Title

  Scenario: Get Manager school
    Given The user is on the login page
    When  The user enters Student username and password
    Then  The user should be able to login
    When  The user clicks the user account button
    Then  The user should be able to see their profile
    When  The user clicks on the Add Education button
    Then  The user can see their school
