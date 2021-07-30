Feature: Requesting for an application

  @test
  Scenario Outline: To Requesting for an application
    Given Browser is launched and user is logged in and navigated to application page
    When user clciks on Request access and search for:"<Application>"
    Then user validation for Search details of the "<Application>"
    Then user clicks on plus icon and validate deatails of added cart "<Application>"
    Then user reaches the check out page and validate the details of the application for check out 

    Examples: 
      | Application |
      | 7Geese      |
