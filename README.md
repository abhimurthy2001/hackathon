#MakeMyTrip Automation Project

This project is a Maven-based Java project that uses Selenium WebDriver, TestNG, and Extent Reports to test the functionality of the website  'MakeMyTrip'.

The project consists of the following test cases:

* Open the website and click on 'Cabs' and verify if it is redirected to the cabs page.

* Enter the details like 'From'-- Delhi 'To'-- Manali and date and time as 6:30 am and click on search and then get the lowest price of the cab available.

* Click on Giftcards and select any giftcard and fill the sender's details and enter wrong email and capture the alert message.

* Go to hotels page and verify if it is redirected to hotels page and then capture the number of adults.

#Prerequisites. To run this project, you need to have the following software installed on your system:
 
* Java 8 or higher
 
* Maven 3.9+ requires JDK 8 or above
 
* Selenium Server 4.17.0
 
* Jenkins.war
 
#Dependencies The project uses the following dependencies:
 
* selenium-java 4.15.0
 
* webdrivermanager 5.6.2
 
* commons-io 2.13.0
 
* apache.poi 5.2.2
 
* poi-ooxml 5.2.2
 
* log4j-api 2.22.1
 
* log4j-core 2.22.1
 
* extentreports 5.1.1
 
* testng 7.8.0
 
#Plugins The project uses the following plugins to run the project through pom.xml:
 
* maven-compiler-plugin 3.12.1
 
* maven-surefire-plugin 3.2.5
 
#How to run You can run the project in different ways:
 
* Using the pom.xml file: Right-click on the pom.xml file and select 'Run as Maven test'.
 
* Using main.xml: Right-click on the main.xml file and select 'Run as TestNG Suite'.
 
* Using the command prompt: Navigate to the project directory and execute the command 'mvn test'.
 
* Using the batch file: Double-click on the run.bat file in the project directory.
 
* Using the Selenium Grid: Start the hub and node servers using the commands 'java -jar selenium-server.jar hub' and 'java -jar selenium-server.jar node -hub http://localhost:4444/grid/register' respectively, and then run the project as mentioned above.
 
* Using Jenkins: Deploy the jenkins.war file on a web server and access the Jenkins dashboard. Create a new job and configure it to use the project's GitHub repository and the pom.xml file. Build the job and view the test results and reports.
 
#Reports 
The project generates Extent Reports in the test-output folder. The reports contain the test execution details, screenshots, and logs. You can view the reports by opening the index.html file in a browser.
 
#Logs
The logs folder contains automation.log file. This file records the output of the test cases and the errors encountered during the testing process.
 
#GitHub 
The project code is available on GitHub. You can clone, fork, or download the repository using git commands or the GitHub web interface.
 
#Author
K Abhishek
