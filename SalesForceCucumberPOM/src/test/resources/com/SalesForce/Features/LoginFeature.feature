
Feature: Login into SalesForce application
 

  Scenario: Login with valid username and valid password
   Given user open Salesforce application
   When user on "LoginPage"
   When user enter value into text box username as "anu@archtek.com"
   When user enter value into text box password as "TestingDemo#123"
   When user click on login button
   When user on "HomePage"
   Then verify the page title as "Home Page"
   
  Scenario: Login with valid username and Blank password
   Given user open Salesforce application
   When user on "LoginPage"
   When user enter value into text box username as "anu@archtek.com"
   When user enter value into text box password as ""
   When user click on login button
   When user on "Loginpage"
   Then verify the error message with the text "Please enter your password."
  
