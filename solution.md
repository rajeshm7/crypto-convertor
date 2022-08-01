# Requirements
The goal of this project is to implement a JAVA web application 
to fetch the current localized price of a cryptocurrency.


1. I have created Login functionality using spring security feature which 
allows user to login and use the cryptocurrency price calculator 
and also allows them to look at their conversion history.


2. The user can select the logout by clicking the "logout" button
in the landing page(index) and conversion history page.


3. If the "IP address" field is empty in search, I have created a
utility method "getClientIp" to get the IP address of the client(incoming request).


4. I have assumed that getting the user country(location) from IP address is ideally done
using a third-party service. So, here I have just hardcoded the logic
like if the "IP address" starts with 1 then the country is "Germany",
IP starts with 2 then the country is "United Kingdom",
IP starts with 3 then the country is "United States",
IP starts with 4 then the country is "Japan"
IP starts with 5 then the country is "Japan"
If unable to find country using IP address, then default country is "Germany"


5. The user can see the conversion history by clicking
"Click here to see your Conversion History" in the top left corner
of the landing page.


6. The user can come back to the Cryto price calculator page, by clicking
"Click here to navigate to Convertor" in the top left corner
in the conversion history page.


7. I have created Dockerfile to package the application as container.


8. I have created deploymentservice.yaml for Kubernetes.


9. I have created Jenkinsfile for CI/CD process. The jenkins
file will have the pipeline stages.

   
10. Tech stack used for this application is given below,
    1. Spring boot - for developing this application in JAVA
    2. Maven - as a dependency management and build tool.
    3. H2 / MySQL - for Database
    4. H2 database - used for unit test cases.
    5. Junit5 and Mockito - for testing.
    6. Thymeleaf - for frontend
    7. Docker - To package applications into containers
    8. Kubernetes - For container orchestration
    9. Jenkins - For CI/CD
    


# Dependencies
* [Java 11](https://www.oracle.com/java/technologies/downloads/#java11)  
* [Maven 3](http://maven.apache.org/download.cgi)  
* The remaining dependencies will be supplied by Maven.  


# How to Run the application
1. Download the project  from github : https://github.com/rajeshm7/crypto-convertor
~~~~
crypto-convertor

1. Download project as a Zip

or

2. git clone git@github.com:rajeshm7/crypto-convertor.git
~~~~

2. Go to application folder  
~~~~
cd crypto-convertor
~~~~


3. Configure MySql url, username and password in application.properties
or you can skip this step to use H2 in-memory database which I have already configured.
~~~~
spring.datasource.url=jdbc:mysql://localhost:3306/currency_convertor_db
spring.datasource.username=root
spring.datasource.password=mysqlpassword
~~~~


4. Create "movie_db" schema/database in Mysql, if u are using 
any other database other than H2.
You can skip this step to use H2 in-memory database
~~~~
CREATE SCHEMA currency_convertor_db
~~~~


5. Install the application dependencies  
~~~~
./mvnw clean install
~~~~


6. Run the application  
~~~~
./mvnw spring-boot:run
~~~~


7. The API will be reachable on [http://localhost:8081](http://localhost:8081)


8. Run the test cases
~~~~
./mvnw test
~~~~


# How to test the application
1. Once the application is started, go to http://localhost:8081


3. Now the application will direct to 'login' page.


3. Login with any of the below credentials
   1. username: admin , password: admin
   2. username: user , password: password
   3. username: test , password: password
   

4. After successful login, application will redirect to
the landing page.


5. The landing page has "Cryptocurrency price calculator".
The user can select the cryptocurrency from the dropdown
and enter the IP Address(optional) and click submit.


6. Based on the input, the price will be calculated and displayed
with the currency symbol.


7. The user can click to check their conversion history by clicking
"Click here to see your Conversion History" in the top left corner
of the landing page.


8. The user can come back to the Cryto price calculator page, by clicking
"Click here to navigate to Convertor" in the top left corner
of the conversion history page.


9. The user can logout by clicking "logout" button on the right
side top corner.


10. The user can re-login after logging out.