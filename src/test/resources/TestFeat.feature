Feature: Validating the Initiators functionality

  Scenario Outline: Perform the testing using valid data
    Given user is present on the homepage of the application
    And user enters the "<Username>" and "<Password>"
    When user clicks on the create project
    And user enters the following details "<Name>" "<Client Name>" "<Description>" "<Project Code>"
    Then user clicks on the next button
    And user click on the submit button

    Examples: 
      | Username | Password | Name        | Client Name | Description | Project Code |
      | Java     | Java@123 | TestProject | Deloitte    | Test Sample |          101 |
