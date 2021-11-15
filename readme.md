## Steps to Configure

* Run the database.sql file
    * mysql -u root -p --> Enter your user and password
    * source ./src/assets/database.sql

* Open the project in any IDE
* Run : ***mvn exec:java -Dexec.mainClass="com.demo.Application.App"***

* Add User
    * default role is CUSTOMER
    * you have to change the role manually
        * Eg: update users set role = "role" where id = "id";


* Table Details
    * User Table
    * Field  | Type | 
            ------ | ----
      id  | varchar
      name  | varchar
      email  | varchar
      walletPrice  | number
      password | varchar
      role | varchar

    * Property Table
    * Field  | Type | 
              ------ | ----
      id  | varchar
      name  | varchar
      price  | number
      description  | varchar
      vendorID | varchar (User)
      role | varchar

    * Order Table
    * Field  | Type | 
          ------ | ----
      id  | varchar
      buyer  | varchar
      product  | varchar
      quantity  | number
      createdAt | datetime