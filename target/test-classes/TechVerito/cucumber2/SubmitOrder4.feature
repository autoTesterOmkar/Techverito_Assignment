
@tag
Feature: Purchase the Books and place order from E-commerce Website
  I want to use this template for my feature file

  Background:
	Given I landed on Ecommerce Page

  @Regression2
      Scenario Outline: Double QTY of added products in cart and check total value
  
    Given Logged in with username <name> and password <password>
    When Increase the quantity by one of added product 
    And Calculate total price of added products
    Then Compare calculated and Total value in cart 

    Examples: 
      | name  							 |  password		         |	
      | OmkarAutoTester      |  OmkarAutoTester@1    | 
   
     
