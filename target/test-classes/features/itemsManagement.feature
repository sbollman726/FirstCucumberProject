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
@regression @itemsTests
Feature: Items Management

  # any steps defined under background will be executed before the first step
  # of each scenarios in the feature file
  Background: 
    Given As an entity user, I am logged in
    And I navigate to Items tab

  @createItem @smoketest
  Scenario: As a user, I am able to create an item or a service
    When I click on the Add Item button
    Then I should be on item input page
#   When I provide item information "Books", price 1800, unit "pc", and description "a good book"
    When I provide item information to the fields
    | Red Apple | 50000 | box | alot of nice apple |
    And I click Save Item button
    Then The Item is added to the Item list table

  @updateItem
  Scenario: As a user, I am able to update an item or a service
    When I select the item "Books"
    Then I should be on item details page
    When I update the item price to 3000 dollars
    And I click Update Item button
    Then the Item price is updated to 30 dollars
    
	@deleteItem
	Scenario: As a user, I am able to create and delete an item or a service
		When I click on the Add Item button
		Then I should be on item input page
		When I provide item information to the specified fields "Tree Bean", price 399322, unit "pc", and description "A Tree Bean"
		And I click Save Item button
		Then The Item is added to the Item list table
		When I select the checkbox next to specified item
		And I click on actions dropdown
		And I click delete
		And I confrim delete
		Then I should not see the item listed
