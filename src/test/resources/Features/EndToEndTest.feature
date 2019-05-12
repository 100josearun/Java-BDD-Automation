Feature: Cleartrip Flight Search and Booking 
	Description: The purpose of this feature is test Flight search and Booking in Cleartrip Website

Scenario: Cleartrip Flight Search 
	Given user is on Cleartrip Homepage 
	When user enters Origin and Destination 
		| Origin | Destination |
		| DEL    | BOM         |
	And Date as "16/June/2019" 
	And select 1 Adult and 1 Child 
	And clicked on Search Flights button 
	Then Flight Search Results should be displayed 
	
#Scenario: Filtering Flight Search Results 
#	Given user is on Flight Search results page 
#	When user hover on "SpiceJet", Only text should be displayed 
#	And when user click on Only button 
#	Then Flights of SpiceJet should be filtered and displayed 
#	And Flights with no checkin baggage should be displayed as well 
