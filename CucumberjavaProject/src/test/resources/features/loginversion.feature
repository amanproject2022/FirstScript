

@smoketest
Feature: feature to test login functionality

  #Author
  
  Scenario: login successfull valid credentials
    Given user is on login page
    When Iuser enters username and password
    And user clicks on login button
    Then login successful navigate to homepage
