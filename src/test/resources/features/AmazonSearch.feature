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
@searchTest
Feature: Amazon Search
 
  @searchTestScenario
  Scenario Outline: TestCase
  	Given I am on the Amazon Homepage
    When I search "<testdata>"
    And I click search
    Then I see results of "<testdata>"

    Examples: 
      | testdata          |
      | coffee mug        |
      | pretty coffee mug |
      | cool coffee mug   |
      | cute coffee mug   |
      
			