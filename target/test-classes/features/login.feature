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

@login
Feature: GitHub Login feature
  This is GitHub login feature to test positive and negative scenarios
  
 Background:
	 Given User is on the GitHub login page
 
  @positive
  Scenario: Positive login scenario
    #Given User is on the GitHub login page
    When User needs to enter "nakka.swathi@capgemini.com" and "Munny@3793"
    And User clicks on submit button
    Then User is on their GitHub account page
    And User gets email notification for successful login

  
  @negative
  Scenario Outline: Negative login scenario
    #Given User is on the GitHub login page
    When User needs to get data from  <sheetno> and <rowno>
    And User clicks on submit button
    Then User is on the same page
    And User gets forgot password link
    
    Examples:
		|sheetno|rowno|
		|0|0|
		|0|1|
		|0|2|
		|0|3|
  
  