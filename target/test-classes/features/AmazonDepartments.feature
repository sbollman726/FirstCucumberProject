#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#Test case:
#go to amazon.com
#verify that you are on the amazon home page. (verify with title).
#verify dropdown value is by default "All Departments"
#select department Home & Kitchen, and search coffee mug.
#verify you are on coffee mug search results page (use title).
#verify you are in Home & Kitchen department.
Feature: Amazon Departmentd

  @amazonTest
  Scenario: As a User, I am able to select different departments and search
    Given I am on the amazon homepage
    And The department dropdown is "All Departments"
    When I selecet the department "Home & Kitchen"
    And I search "Coffee Mug"
    Then I should be on "Coffee Mug" search result page
    And The department dropdown is "Home & Kitchen"
