Feature: Testing Logs and report


Scenario: Testing google

Given user is on google form
When user types on the form
Then user validates the page title

Scenario: User search the details on google form

Given user is on google form
When user types on the form
Then user gets the details of the search

