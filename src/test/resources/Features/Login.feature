@Sanity             #Will run ALL tests contained on the page when put above the Feature keyword
Feature: Login Functionality

@Login
  Scenario: Login as a Teacher
    Given The user is on the login page
    When  The user enters teacher username and password
    Then  The user should be able to login

@Student @Smoke
  Scenario: Login as a Student
    Given  The user is on the login page
    When   The user enters Student username and password
    Then   The user should be able to login

@Developer
  Scenario: Login as a Dveloper
    Given  The user is on the login page
    When   The user enters Developer username and password
    Then   The user should be able to login


