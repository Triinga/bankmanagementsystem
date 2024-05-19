# Bank Management System


This project is a console application designed to manage a bank system with multiple user accounts and handle various transactions like transfers, withdrawals, and deposits. This application supports both flat fee and percent fee transactions and provides functionalities to check account balances and view transaction history.
Additionally, Spring Boot is utilized specifically for providing RESTful endpoints, enabling functionalities such as creating account and viewing the list of accounts. 
## Features
- Create a bank
- Create user account
- Perform transactions (transfers, withdrawals, deposits) with either flat or percent fees
- View list of accounts and transaction history for each account
- Check total transaction fee amount and transfer amount for the bank

## Requirements
- Java 17 or higher
- Maven
- H2 Database
- Spring Boot 3.2.5

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Triinga/bankmanagementsystem.git
   ```
   ```bash
   cd bankmanagementsystem
   ```
   Build the project using Maven:
    ```bash
    mvn clean install
    ```
## Running the Console Application
1. Open your IDE (e.g., IntelliJ IDEA, Eclipse) or a terminal.
2. Navigate to the com.tringa.bankmanagementsystem.ConsoleApplication package.
3. Run the Main class. 

1. First you are prompted to create a bank
  <img width="202" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/c9796dfa-9222-4f22-8d89-3569ef889326">
  
2. Then you can continue on other features as Account creation
  <img width="254" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/187275f2-cb37-429e-97bc-4bb33084551c">
  
3. Depositing money
  <img width="250" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/4e8821ce-7c1d-4851-9f74-e68f3a13ae8b">

4. transaction fee
  <img width="269" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/2b8a112b-929c-4d89-880e-5f8c95b1846b">
    
5. Withdrawing money 
  <img width="250" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/c4353a9f-c286-4635-92b1-18d2bdf33a67">
  
6. Transfering money 
  <img width="275" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/642332ed-b523-40bb-af64-d1c90bc87aca">
  
7. Transactions list 
  <img width="335" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/cea91d53-ab13-45a7-bbc7-4036eeb284ac">
  
8. Checking account balance 
  <img width="251" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/d83a6a05-afb7-46fb-ba1e-a0a280ab42ca">
  
9. Viewing list of accounts 
  <img width="281" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/e5373988-4537-450e-9c0a-9e5d6f2214a2">
  
10. transfer amount
  <img width="279" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/b6031f10-7243-42db-85e6-5cc0d9b2f12f">

11. exit
  <img width="173" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/49f20b35-e255-4e10-8051-b276a65efcee">


## Running Spring Boot application

To run the Spring Boot application and access the RESTful web service for managing accounts, use the following command:

```bash
mvn spring-boot:run
```
The application will start on http://localhost:8080

### Accessing using browser
After starting the application, you can access the endpoints using a web browser by navigating to http://localhost:8080/accounts.
<img width="960" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/48bebe5b-b24e-4aa0-b523-64f07e7073ed">

### Endpoint to retrieve all accounts.
  <img width="628" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/e15aaf3b-dc64-4d80-81a0-1b5a953d1f70">
  
### Endpoint to retrieve a specific account by its ID.
  <img width="643" alt="image" src="https://github.com/Triinga/bankmanagementsystem/assets/97124034/eb721bf3-04f1-4462-9c57-5d16bf2b62fa">

## Additional notes 

Ensure you have the H2 database configured correctly in `application.properties`:

```properties
spring.datasource.url=jdbc:h2:file:~/bankDB  
spring.datasource.username=sa  
spring.datasource.password=  
spring.datasource.driver-class-name=org.h2.Driver  
spring.jpa.hibernate.ddl-auto=update  
