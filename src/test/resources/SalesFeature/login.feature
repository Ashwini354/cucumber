
Feature: login into salesforce
Background:user is loggen in

  Scenario:provide valid username and invalid password
  Given check proper salesforce page
  When user enters "ashu@techarc.com" into username field
  When user enters "123" into password field
  When user click login button
  Then wrong password displayed 
  
  Scenario:provide valid username and valid password
  Given check proper salesforce page
  When user enters "ashu@techarc.com" into username field
  When user enters "Sivarani54#" into password field
  When user click login button
  Then vrify home page "Home Page ~ Salesforce - Developer Edition"

 
  