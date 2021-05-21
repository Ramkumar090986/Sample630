Feature: User is verifying the facebook login page

  Scenario Outline: Verifying the login functionaloty for facebook
    Given User is on facebook application
    When User loging in by entering "<username>" and "<password>"
    Then user click on the login button

    Examples: 
      | username | password |
      | Java     | Java@123 |
