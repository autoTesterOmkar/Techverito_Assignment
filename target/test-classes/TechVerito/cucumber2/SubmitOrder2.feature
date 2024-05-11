
@tag
Feature: Purchase the Books and place order from E-commerce Website
  I want to use this template for my feature file

  Background:
	Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Add Book products to cart
  
    Given Logged in with username <name> and password <password>
    When I add product <productName> to Cart
    Then Verify product <productName> added to cart 

    Examples: 
      | name  							 |  password		         |	productName |
      | OmkarAutoTester      |  OmkarAutoTester@1    |  Roomies     | 
      | OmkarAutoTester      |  OmkarAutoTester@1    |  harry potter and the chamber of secrets  |
      | OmkarAutoTester      |  OmkarAutoTester@1    |  harry potter and the prisoner of azkaban |

      
      
      
      