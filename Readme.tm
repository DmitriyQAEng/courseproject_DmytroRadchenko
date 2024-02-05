Course Project  Dmytro Radchenko
=================================================================================================================================================================================
Project for Testing Kanboard

Technologies and libraries such as testNG, Selenide, Rest Assured, and Allure are used.

=================================================================================================================================================================================


Installation and Running Instructions:

Clone the repository:

git clone https://github.com/DmitriyQAEng/courseproject_DmytroRadchenko.git

Ensure that Docker is installed on your machine.

Download and save the docker-compose.yml file from here.

Execute the following command to start Kanboard using Docker:

docker-compose up

After the launch, find the administrator password in the terminal where you executed the docker-compose up command.

Running the Project Locally

Open Kanboard in your web browser.

Use the following credentials to log in:

Login: admin
Password: admin
For API tests, use the API key found in Kanboard settings (Settings -> API).

Run the automated test:

./mvnw test  -Dsuite=UITest.xml
./mvnw test  -Dsuite=FullTest.xml
./mvnw test  -Dsuite=ApiTest.xml


=================================================================================================================================================================================

Running the Allure Report

To generate and view Allure reports, use the following commands:

Generate the report:

./mvnw  allure:report

Generates an HTML report in the target/site/allure-maven-plugin/index.html directory.

Open the report in the browser:

 /mvnw  mvn allure:serve

Launches a local server and opens the report in the browser.

=================================================================================================================================================================================

Testing Information

Kanboard: http://localhost/login or http://127.0.0.1/login

Login: admin
Password: admin
API key for API tests: Located in settings -> API
Jenkins: http://localhost:8080 (should redirect to http://localhost:8080/login?from=%2F)

Administrator password: Found in the terminal where you executed the docker-compose up command.

=================================================================================================================================================================================