Feature: My Account Homework

#   User Story:
#      As a registered user,
#      I want to edit my personal information on the Edit Profile page,
#      so that I can keep my account details up to date.
#      so that I can keep my account details up to date.
#   Acceptance Criteria:
#       User can log in with a valid email and password.
#       User can open the Edit Profile tab from their account page.
#       User can change fields such as Full Name, Job, and Company.
#       User can click Save (or Update) to apply the changes.
#       Updated information is visible on the profile page after saving.

  Scenario: Validate Full Name update
    Given The user is on the login page
    When  The user enters "janine.daniels@hotmail.com" and "abc123"
    Then  The user should be able to login
    #User can log in with a valid email and password.
    Then  The Welcome Message contains "Janine"
    When  The user clicks the user account button
    Then  The user should be able to see their profile
    When  The user clicks the "Edit Profile" tab
    #User can open the Edit Profile tab from their account page.
    Then  The user should be able to edit their "Full Name" text as "Janine"
    When  The user clicks the Save Changes button
    Then  Verify that "Full Name" updated with "Janine"

#    Story 2: Add a New Experience

#    User Story:
#         As a user,
#         I want to add a new job experience to my profile,
#         so that I can show my career history to others.
#    Acceptance Criteria:
#         User can log in successfully.
#         User can open the Add Experience tab.
#         User can enter values for:
#              Job Title
#              Company
#              Location
#              From Date / To Date
#              Job Description
#         After clicking Add Experience, the new job appears in the list.


  Scenario: Add a new Job Experience
    Given The user is on the login page
    When  The user enters "janine.daniels@hotmail.com" and "abc123"
    Then  The user should be able to login
    #User can log in with a valid email and password.
    Then  The Welcome Message contains "Janine"
    When  The user clicks the user account button
    Then  The user should be able to see their profile
    When  The user clicks the "Add Experience" tab
    And   The user should be able to edit their "Job Title *" text as "Manager"
    And   The user should be able to edit their "Company *" text as "School"
    And   The user should be able to edit their "From Date" text as "10/10/2002"
    When  The user clicks on the Add Experience save button
    Then  Verify that Experience updated with "Manager" record

#    Story 3: Add Education Record
#    User Story:
#         As a user,
#         I want to record my education information,
#         so that I can display my academic background on my profile.
#    Acceptance Criteria:
#        User can log in with valid credentials.
#        User can open the Add Education tab.
#        User can enter:
#             School or Bootcamp
#             Degree or Certificate
#             Study field
#             From Date / To Date
#             Program Description
#       User can select Current School if still studying.
#       When the user clicks Add Education, the new record appears in their education list.
#


  Scenario: Add a new Educational Record
    Given The user is on the login page
    When  The user enters "janine.daniels@hotmail.com" and "abc123"
    Then  The user should be able to login
    #User can log in successfully
    Then  The Welcome Message contains "Janine"
    When  The user clicks the user account button
    Then  The user should be able to see their profile
    When  The user clicks on the Add Education tab
    Then  The user adds "EuroTech" school and "SDET" to a new Educational Record
    When  The user clicks the Add Education button
    Then  The Educational Record has been saved.

