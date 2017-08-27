Feature: As a user, I want to use Google Translate, 
	so that I can translate a text tp a different language

Scenario: translate a single word 
	Given On The Google Page  
	When I choose target language 
	And I type a word into source field  
	Then Translation is displayed