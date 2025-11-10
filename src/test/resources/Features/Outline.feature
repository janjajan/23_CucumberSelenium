Feature: Account Test With Scenario Outline

  Scenario: Account Test

    Given  The user is on the login page
    When   The user logs in using "janine.daniels@hotmail.com" and "abc123"
    Then   The Welcome Message contains "Janine"
    And    The user clicks the user account button
    When   The user clicks the "edit profile" tab
    Then   The user should be able to edit their "Full Name" text as "Janine"


  Scenario Outline: Check Account Name Text

    Given  The user is on the login page
    When   The user logs in using "<username>" and "<password>"
    Then   The Welcome Message contains "<name>"
    And    The user clicks the user account button
    When   The user clicks the "<tabName>" tab
    Then   The user should be able to see their profile from Edit Profile Page "<dataField1>" is "<jobTitle>"
    Then   The user should be able to see their profile from Edit Profile Page "<dataField2>" is "<companyName>"


    Examples:
      | username                   | password | name   | tabName  | dataField1 | jobTitle               | dataField2 | companyName |
      | janine.daniels@hotmail.com | abc123   | Janine | Overview | Job        | QA Automation Engineer | Company    | Eurotech    |


