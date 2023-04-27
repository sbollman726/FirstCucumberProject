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


  # any steps defined under background will be executed before the first step of eahc scenarios
  # in the feature file.
  Background: 
    Given As an entity user, I am logged in
    And I navigate to Items tab

  @createItem @smoketest
  Scenario: As a user, I am able to create an item or a service
    When I click on the Add Item button
    Then I should be on item input page
    When I provide item information name "iphone", price 1800, unit "pc", and description "a good iphone"
    And I click Save Item button
    Then The Item is added to the Item list table
    
  @createItemDB
  Scenario: As a user, I am able to create an item or a service on UI and check the item in DB
    When I click on the Add Item button
    Then I should be on item input page
    When I create an item with following information
    | Coffee Bean | 1000 | lb | Decaf |
    # And I click Save Item button
    # Then The Item is added to the Item list table
    And I should be able to see the item in database
    When I delete the item created above
    Then The item is no longer in the items list table
    
    @createItemInDB
  Scenario: As a user, I am able to create an item or a service on UI and check the item in DB
    When I insert a record into database called "Bacon"
    Then Item should be listed in the items table on the UI
    When I delete the item created above
    Then The item is no longer in the items list table
    
    
  @createItemWithDataTable @smoketest
  Scenario: As a user, I am able to create an item or a service
    When I click on the Add Item button
    Then I should be on item input page
    When I provide item information to the fields
    | Pineapple Core | 300 | pc | A fruitless Pineapple |
    And I click Save Item button
    Then The Item is added to the Item list table

  @updateItem
  Scenario: As a user, I am able to update an item or a service
    When I select the item "iphone"
    And I should be on item details page
    When I update the item price to 80000 dollars
    And I click Update Item button
    Then the Item price is updated to 800 dollars
    
   @updateItemDB
  Scenario: As a user, I am able to create an item or a service on UI and check the item in DB
    When I click on the Add Item button
    Then I should be on item input page
    When I create an item with following information
    | Pineapple Core | 300 | pc | A fruitless Pineapple |
    And I click Save Item button
    #Then The Item is added to the Item list table
    And I should be able to see the item in database
    When I update the item price to 80000 dollars
    Then The item price has been updated to 600 in database
    When I delete the item created above
    Then The item is no longer in the items list table
    
  @deleteItem  
  Scenario: As a user, I am able to delete an item
    When I click on the Add Item button
    Then I should be on item input page
    When I create an item with following information
    | Donut | 1400 | dz | very sweet donut which I dont like |
    Then The Item is added to the Item list table
    When I delete the item created above
    Then The item is no longer in the items list table