#author : Bhushan Bende
#Date : 12-06-22
#Description : Trying to impliment Cucumber

Feature: Login 
 @login
Scenario Outline: Login and Logout Test Admin User 1
	Given Lauch Openmrs
	When Login to Openmrs with <UserName> and <Password>
	Then Chosse Location <Location>
	Then Click on Submit Button
	Then Verify Logged In Message <Message>
	Then Logout
	
	Examples:
	|UserName |Password |Location			 | Message																					|
	|Admin    | Admin123|Inpatient Ward|Logged in as Super User (admin) at Inpatient Ward.|   
	
	@register
 Scenario Outline: Login and Register A Patient Test Admin User 1
	Given Lauch Openmrs
	When Login to Openmrs with <UserName> and <Password>
	Then Chosse Location <Location>
	Then Click on Submit Button
	Then Verify Logged In Message <Message>
	Then Click on Action <Action>
	Then Verify Action Tab Title <Title>
	Then Enter Patient Name <Name>
	Then Select Gender <Gender>
	Then Select DOB <DOB>
	Then Enter ADDRESS <ADDRESS>
	Then Enter PhoneNo <PhoneNO>
	Then Add Relation <Relation&Name>
	Then Click on Confirm Button
	Then Get Patient Id
	Then Logout
	
	
		Examples:
	|UserName |Password |Location			 |Action						|Name							| Gender| DOB			|ADDRESS|PhoneNO		|Relation&Name  |Title|Message| 
	|Admin    | Admin123|Inpatient Ward|Register a patient|Vaishali B Singh |Female |18/5/1994|Delhi	|9865327412	|Doctor/Bhushan	|Register a patient|Logged in as Super User (admin) at Inpatient Ward.|
	
	
	@findAPatient
	Scenario Outline: Find patient Record 1
	Given Lauch Openmrs
	When Login to Openmrs with <UserName> and <Password>
	Then Chosse Location <Location>
	Then Click on Submit Button
	Then Click on Action <Action>
	Then Verify Action Tab Title <Title>
	Then Enter A PatientID <PatientId> and Search
	Then Verify The PatientID <PatientID>
	
	 Examples:
	|UserName |Password |Location			 |Action						 |Title							 |PatientId|
	|Admin    | Admin123|Inpatient Ward|Find Patient Record|Find Patient Record|100JDJ	|