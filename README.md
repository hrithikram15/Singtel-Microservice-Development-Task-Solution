# Singtel-Microservice-Development-Task-Solution

This repository contains a microservices-based solution for customer management using Java and the Spring Boot framework. The architecture follows the principles of Microservices Architecture with RESTful Web Services. It's composed of three separate microservices:

**Customer Microservice**
The Customer Microservice allows for the management of customers. It provides the following functionalities through REST APIs:

Create Customer: Add new users or customers.
Get Customer Details: Retrieve customer details, including their ID, subscribed plan, and other information.
Update Customer Details: Modify customer information.
Delete Customer: Remove a user from the system.
Subscribe to Plans: Allows customers to subscribe to their preferred plans and select add-ons.

**Plan Microservice**
The Plan Microservice handles plan management. It offers the following functionalities through REST APIs:

Create Plans: Add new subscription plans.
Search Plans: Find existing plans based on various criteria.
Update Plans: Modify plan details.
Remove Plans: Delete plans from the system.

**AddOn Microservice**
The AddOn Microservice is responsible for managing extra add-ons that customers can subscribe to. It provides the following capabilities through REST APIs:

Add Add-Ons: Allows the addition of new add-ons.
Select and Remove Add-Ons: Customers can select add-ons and remove them from their subscriptions.


**Synchronous Communication**
The solution establishes synchronous communication between the Customer and Plan Microservices. This ensures that customers can only subscribe to plans that are available in the Plan Microservice's database, enhancing data consistency and system reliability.

This repository showcases the implementation of these microservices in a real-world scenario, providing a foundation for building scalable and modular applications using a microservices architecture.

Feel free to explore each microservice's codebase for more details on their implementation and functionalities.

---------------------------------------------------------------------------

#Problem Statement

Singtel wants to launch prepaid customer portal. For that one of our product owners created below user stories
User Story 1: Customer should be able to search for available plans.
Example data: Plan name: “Singtel-Basic”, cost: “10 SGD”, details: “100 SMS, 500 calls, 5 GB”.
User Story 2: Customer should be able to top up with selected plan.
User Story 3: Customer should be able to search for add on features.
 	feature 1: data:10 GB, cost: 5 SGD
feature 2: 100 SMS, cost: 1 SGD
feature 3: data 100 GB, cost:20 SGD
User Story 4: Customer should be able to top-up their selected add-ons with their existing plan.
User Story 5: Customer should be able to remove their addon feature.


Description:
Please note that above is the basic requirement and you can have your own imagination on creating the sample data. 
There is no right or wrong approach only thing you need to provide justification on your solution if anyone asks.
Acceptance Criteria:
Each user story contains each API endpoints and make sure you should follow below steps,
1.	Please provide API contract details. It can be swagger or postman or any other document.
2.	API must use minimum of 3 to 4 HttpMethods (GET/POST/PUT/DELETE/PATCH/HEAD/etc.,)
3.	API must be protected you can use any security mechanism.
4.	Project must keep readme.md file to explain the project.
5.	You can use any Database.
Good to have:
6.	Need to have integration test using mockmvc.
7.	Make sure 80% code coverage you can use jacacco plugin in your pom file.
Expected to use, Spring Boot 3, Maven, Java 17
