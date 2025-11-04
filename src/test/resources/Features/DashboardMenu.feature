Feature: Dashboard Menu


  Scenario: User able to see the Dashboard menus after logged in

    #USED TO VERIFY LISTS
    Given The user is on the login page
    When  The user logs in using "janine.daniels@hotmail.com" and "abc123"
    Then  The user should be able to see following menus
    | Dashboard  |
    | Developers |
    | Components |
    | Forms      |
    | JavaScript |


    Scenario:  Log in as a specific user
      Given The user is on the login page
      When  The user logs in using the following credentials
      |username | janine.daniels@hotmail.com |
      |password | abc123                     |
      |message  | Janine                     |