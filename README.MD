# Payment Service
A spring boot project for creating Payment Method and Payment Plan

# Application Features

- Create Payment Method and Plan(s)
- Update Payment Method and Payment Plan(s)
- Delete Payment Method
- Get All Payment Methods
- Get Specific Payment Method
- Filter Payment Method on the basis of name

## Backend
### Technology:

- Spring Boot 2.7.4
- Java Version 8
- H2
- Maven 3.8.6


### Endpoints
 Endpoint              | Method | Usage                                       
-----------------------| ------ |---------------------------------------------
/api/v1.0/configuration/payment-methods        | POST | Create a payment Method.                    
/api/v1.0/configuration/payment-methods/{id}   | POST | Fetch Payment Method by Payment Method id.  
/api/v1.0/configuration/payment-methods/{id}  | PUT | Update Payment Method                       
/api/v1.0/configuration/payment-methods/{id}   | GET | Delete a payment method
/api/v1.0/configuration/payment-method?name=Credit+Card   | GET | Search by Name
/api/v1.0/configuration/payment-method?id={paymentPlanId}   | GET | Search by Payment Plan Id.


### How to Run the application

1. Build the application using maven using below command. 
   1. > mvn clean install.
2. Run the application using command 
   1. > java PaymentMethodService-0.0.1-SNAPSHOT.jar
3. The applcation will start at port 8080.

