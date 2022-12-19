# BankingApp

Last project with Ironhack, this project consist in a simulation of a simple REST API banking application backend!

## Requirements and Instructions
# LAST PROJECT

Midterm projects are to completed individually. You may not collaborate with classmates on this assignment. Should you need assistance, you should reach out to your instructional staff.

This project is designed to be challenging and should be completed as thoroughly as possible.

In this project, you will be building a banking system. You should meet all of the requirements below:

## Requirements
The system must have 4 types of accounts: StudentChecking, Checking, Savings, and CreditCard.

## Checking
Checking Accounts should have:
- A balance
- A secretKey
- A PrimaryOwner
- An optional SecondaryOwner
- A minimumBalance
- A penaltyFee
- A monthlyMaintenanceFee
- A creationDate
- A status (FROZEN, ACTIVE)


## StudentChecking
Student Checking Accounts are identical to Checking Accounts except that they do NOT have:
- A monthlyMaintenanceFee
- A minimumBalance


## Savings
Savings are identical to Checking accounts except that they:
- Do NOT have a monthlyMaintenanceFee
- Do have an interestRate

## CreditCard
CreditCard Accounts have:
- A balance
- A PrimaryOwner
- An optional SecondaryOwner
- A creditLimit
- An interestRate
- A penaltyFee

### The system must have 3 types of Users: Admins and AccountHolders.

## AccountHolders
The AccountHolders should be able to access their own accounts and only their accounts when passing the correct credentials using Basic Auth. AccountHolders have:
- A name
- Date of birth
- A primaryAddress (which should be a separate address class)
- An optional mailingAddress

## Admins
- Admins only have a name

## ThirdParty
- The ThirdParty Accounts have a hashed key and a name.


### Admins can create new accounts. When creating a new account they can create Checking, Savings, or CreditCard Accounts.

## Savings
- Savings accounts have a default interest rate of 0.0025
- Savings accounts may be instantiated with an interest rate other than the default, with a maximum interest rate of 0.5
- Savings accounts should have a default minimumBalance of 1000
- Savings accounts may be instantiated with a minimum balance of less than 1000 but no lower than 100

## CreditCards
- CreditCard accounts have a default creditLimit of 100
- CreditCards may be instantiated with a creditLimit higher than 100 but not higher than 100000
- CreditCards have a default interestRate of 0.2
- CreditCards may be instantiated with an interestRate less than 0.2 but not lower than 0.1

## CheckingAccounts
- When creating a new Checking account, if the primaryOwner is less than 24, a StudentChecking account should be created otherwise a regular Checking Account should be created.
- Checking accounts should have a minimumBalance of 250 and a monthlyMaintenanceFee of 12
- Interest and Fees should be applied appropriately

## PenaltyFee
- The penaltyFee for all accounts should be 40.
- If any account drops below the minimumBalance, the penaltyFee should be deducted from the balance automatically

## InterestRate
- Interest on savings accounts is added to the account annually at the rate of specified interestRate per year. That means that if I have 1000000 in a savings account  with a 0.01 interest rate, 1% of 1 Million is added to my account after 1 year. When a savings account balance is accessed, you must determine if it has been 1 year or more since either the account was created or since interest was added to the account, and add the appropriate interest to the balance if necessary.
- Interest on credit cards is added to the balance monthly. If you have a 12% interest rate (0.12) then 1% interest will be added to the account monthly. When the balance of a credit card is accessed, check to determine if it has been 1 month or more since the account was created or since interested was added, and if so, add the appropriate interest to the balance.


## Account Access
Admins
- Admins should be able to access the balance for any account and to modify it.

## AccountHolders
- AccountHolders should be able to access their own account balance
- Account holders should be able to transfer money from any of their accounts to any other account (regardless of owner). The transfer should only be processed if the account has sufficient funds. The user must provide the Primary or Secondary owner name and the id of the account that should receive the transfer.

## Third-Party Users
- There must be a way for third-party users to receive and send money to other accounts.
- Third-party users must be added to the database by an admin.
- In order to receive and send money, Third-Party Users must provide their hashed key in the header of the HTTP request. They also must provide the amount, the Account id and the account secret key.

## Extra features (bonus)
- Fraud Detection
- The application must recognize patterns that indicate fraud and Freeze the account status when potential fraud is detected.
- Patterns that indicate fraud include:
- Transactions made in 24 hours total to more than 150% of the customers highest daily total transactions in any other 24 hour period.
- More than 2 transactions occurring on a single account within a 1 second period.
 
## Technical Requirements
- Include a Java/Spring Boot backend.
- Everything should be stored in MySQL database tables.
- Include at least 1 GET, POST, PUT/PATCH, and DELETE route.
- Include authentication with Spring Security.
- Include unit and integration tests.
- Include robust error handling.
- You must use the Money class for all currency and BigDecimal for any other decimal or large number math.
- Deliverables
- A working REST API, built by you that runs on a local server.
- The URL of the GitHub repository for your app.
- A simplified class diagram representing your project structure should be added to the repo.
- Adequate and complete documentation in the README.md file.


Good luck and have fun!

# HTTP Requests Postman
Interaction with the application is possible through HTTP requests.

## GET Accounts
POST: localhost:8080/accounts/1
Output data:
![getAccount](https://user-images.githubusercontent.com/92159714/208536282-2244366a-51a3-4b82-949d-e046f139d8ff.jpg)
![getAccount1](https://user-images.githubusercontent.com/92159714/208536280-938c909a-3203-4634-bd9b-b720d4bbe086.jpg)
![getAccount2](https://user-images.githubusercontent.com/92159714/208536285-b7d2bde0-d330-424e-97d8-391598f68a3c.jpg)
![getAccount3](https://user-images.githubusercontent.com/92159714/208536288-eb222a1b-8946-4d7e-8c16-d81e045e7fae.jpg)
![getAccount4](https://user-images.githubusercontent.com/92159714/208536290-04845d9a-4a0f-4b59-bd16-9827fc700dda.jpg)
![getAccount5](https://user-images.githubusercontent.com/92159714/208536292-2f3cad36-7059-4a39-b65f-f0c3c88d0d70.jpg)
![getAccount6](https://user-images.githubusercontent.com/92159714/208536294-7ba6c2f0-c824-42c5-bd3a-d7a846b9b409.jpg)


## GET AccountHolder
### POST: localhost:8080/accountHolder/1
![getAccountHolder](https://user-images.githubusercontent.com/92159714/208536370-b72ac340-cd60-4ca8-9987-3d5ec8eb7783.jpg)

### Output data:

![getAccountHolder1](https://user-images.githubusercontent.com/92159714/208536373-a0cd2b68-7cb2-4c68-a1fd-926718c595a6.jpg)


## GET Users
### POST: localhost:8080/users
![getUsers](https://user-images.githubusercontent.com/92159714/208536405-2365b7a1-b91c-4339-b15d-3221069f24f8.jpg)

### Output data:

![getUsers1](https://user-images.githubusercontent.com/92159714/208536408-fc423717-1fe0-48b3-8bce-503c0cea2aef.jpg)
![getUsers2](https://user-images.githubusercontent.com/92159714/208536410-2142897d-7bb6-4960-a871-56b7bf7092d0.jpg)
![getUsers3](https://user-images.githubusercontent.com/92159714/208536403-82fb47c5-fd93-469c-9381-3c6a2fb616fa.jpg)


## POST ThirdParty
### POST: localhost:8080/thirdParty

### Data: {
    "username": "Pol",
    "password": "343",
    "haskey": "345",
    "name": "Pol"
}

![postThirdParty](https://user-images.githubusercontent.com/92159714/208536810-01090f5e-3a4b-4ac1-a038-4497287295cd.jpg)

### Output data:

![postThirdParty1](https://user-images.githubusercontent.com/92159714/208536809-d628bd90-b2c2-45d5-aa37-ac27e7b5897d.jpg)


## POST AccountHolder
### POST: localhost:8080/accountHolder

### Data: {
   "username": "Aini",
    "password": "1223",
    "dateOfBirth": "1995-06-13",
    "primaryAddress": {
        "streetName": "Calle Viladomat",
        "streetNum": "123",
        "city": "Barcelona"
    }
}

![postAccountHolder](https://user-images.githubusercontent.com/92159714/208536468-6e3c0482-4625-420d-b221-37cae4bc3016.jpg)

### Output data:

![postAccountHolder1](https://user-images.githubusercontent.com/92159714/208536467-4c6f5641-b3f0-4367-b6b6-40e720644863.jpg)


## POST Admin
### POST: localhost:8080/admin

### Data: {
    "username": "Aure",
    "password": "1234",
    "name": "Aure"
}

![postAdmin](https://user-images.githubusercontent.com/92159714/208536545-6eac3b6d-9138-4263-835e-3064cbe0ba19.jpg)

### Output data:

![postAdmin1](https://user-images.githubusercontent.com/92159714/208536548-42d06e4f-6807-48d8-afcf-904592ba4789.jpg)


## POST CreateChecking
### POST: localhost:8080/createChecking

### Data:  {
    "balance":"500",
    "penaltyFee": "5",
    "primaryOwner": 1,
    "secondaryOwner": null,
    "interestedRate": "6",
    "minimumBalance": "7"
}

![postCreateChecking](https://user-images.githubusercontent.com/92159714/208536602-d81f00ec-7162-4a51-b417-33d915e8f467.jpg)

### Output data:

![postCreateChecking1](https://user-images.githubusercontent.com/92159714/208536603-c4ac5c02-17af-4333-bb97-b9f4c2c82d14.jpg)
![postCreateChecking2](https://user-images.githubusercontent.com/92159714/208536596-deda35e6-2f78-4388-a4c1-26bbb0812f53.jpg)

## POST CreateCreditCard
### POST: localhost:8080/createCreditCard

### Data:  {
    "balance":"500",
    "penaltyFee": "5",
    "primaryOwner": 1,
    "secondaryOwner": null,
    "interestedRate": "6",
    "minimumBalance": "7"
}

![postCreateCreditCard](https://user-images.githubusercontent.com/92159714/208536641-36bf57c8-1a98-4bf7-b37a-16f030c91e29.jpg)
![postCreateCreditCard1](https://user-images.githubusercontent.com/92159714/208536643-bc9dff6a-13d5-43de-828c-794a93d59668.jpg)

### Output data:

![postCreateCreditCard2](https://user-images.githubusercontent.com/92159714/208536647-167dfc9b-b2e0-4645-9597-6bdd6c3d40b7.jpg)
![postCreateCreditCard3](https://user-images.githubusercontent.com/92159714/208536636-6689bca9-4ae4-4fc7-bd0e-3c3b5ff7fa73.jpg)

## POST CreateStudentsChecking
### POST: localhost:8080/createStudentsChecking

### Data:  {
    "balance":"500",
    "penaltyFee": "5",
    "primaryOwner": 1,
    "secondaryOwner": null,
    "interestedRate": "6",
    "minimumBalance": "7"
}

![postCreateStudentsChecking](https://user-images.githubusercontent.com/92159714/208536769-3835add2-e179-4e9d-ad74-6a27425e58cc.jpg)
![postCreateStudentsChecking1](https://user-images.githubusercontent.com/92159714/208536770-037518f7-420c-4a6d-a751-53059f8adb10.jpg)

### Output data:

![postCreateStudentsChecking2](https://user-images.githubusercontent.com/92159714/208536773-ec3f1cb0-636c-4668-bb59-e509cf4ec329.jpg)
![postCreateStudentsChecking3](https://user-images.githubusercontent.com/92159714/208536765-0e8bf5cc-4058-4194-aa98-42a55c4e4d79.jpg)


## GET CreateSavings
### POST: localhost:8080/createSavings

### Data:  {
    "balance":"500",
    "penaltyFee": "5",
    "primaryOwner": 1,
    "secondaryOwner": null,
    "interestedRate": "6",
    "minimumBalance": "7"
}

![createSavings](https://user-images.githubusercontent.com/92159714/208536111-b49b77d5-f029-45e5-b0ee-3834f3815aec.jpg)
![createSavings1](https://user-images.githubusercontent.com/92159714/208536113-4724c5da-ece3-4298-93b9-509025cf6d05.jpg)

### Output data:

![createSavings2](https://user-images.githubusercontent.com/92159714/208536105-cb4d4ba8-d717-4838-aea3-0929894e3fd5.jpg)
![createSavings3](https://user-images.githubusercontent.com/92159714/208536110-90eeafa8-0349-4a1a-9dcc-1845e5310d15.jpg)

## PATCH Transfer
### POST: localhost:8080/transfer

Data: {
    "amount": "445",
    "sendingMoneyId": 1,
    "receivingMoneyId": 2
}

![patchTransfer](https://user-images.githubusercontent.com/92159714/208536448-b1db06c0-f8fe-4d35-8f16-02259680c6e6.jpg)

### Output data:

![patchTransfer1](https://user-images.githubusercontent.com/92159714/208536446-a9c235ce-be50-4216-81c0-2c3caaf3fd51.jpg)


## PUT ChangeStatus
### POST: localhost:8080/changeStatus?status=FROZEN&id=1

### Data: 
![putChangeStatus](https://user-images.githubusercontent.com/92159714/208536842-3a1ddbae-75d1-4515-af08-28e71c492c4b.jpg)
![putChangeStatus1](https://user-images.githubusercontent.com/92159714/208536843-300869ae-2bcf-40ef-a0d1-71f4d5e206f4.jpg)

### Output data:

![putChangeStatus2](https://user-images.githubusercontent.com/92159714/208536845-80daa4cc-ee27-42b4-9db6-ea7dc818fd58.jpg)
![putChangeStatus3](https://user-images.githubusercontent.com/92159714/208536840-b2aa22d2-8f17-4a41-9ea6-31bcde3f828b.jpg)

## DELETE Account
### POST: localhost:8080/deleteAccount/2
### Data: 
![deleteAccount](https://user-images.githubusercontent.com/92159714/208536180-83757e4e-79d2-40a7-8ba9-58bdd47ec2f0.jpg)

### Output data:

![deleteAccount1](https://user-images.githubusercontent.com/92159714/208536182-6747f46b-3272-4cd6-88be-3ae00e438c38.jpg)
![deleteAccount2](https://user-images.githubusercontent.com/92159714/208536177-cdaa2e09-be1d-46e9-a32d-9a7daf8797af.jpg)

## Class diagram:

![Bank System](https://user-images.githubusercontent.com/92159714/197336169-08a89049-4d60-4369-974f-d3ed8b3083f6.jpg)


# What can be improved here:
Add more test coverage
Add Login/register
minimumBalance, monthlyMaintenanceFee, Interest and Fees should be applied appropriately and implemented
Do the extra bonus

## <img src="http://37.media.tumblr.com/44d4fb34d7d9a0407c8fd5520e2c3123/tumblr_nago0vkGOD1tbhv9ro1_500.gif" width="40"> If you've made it until here and can read this, I want you to know that you are awesome, have a really nice day! 
# See ya <3 <img src="https://c.tenor.com/p2Fs2DoSLWYAAAAC/hello-cute.gif" width="40">
