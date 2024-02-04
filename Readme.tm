<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Individual Project Mykola Dudko</title>
<style>
/* CSS styles for the project information */
body {
    font-family: Arial, sans-serif;
    line-height: 1.6;
    margin: 20px;
}

.container {
    max-width: 800px;
    margin: 0 auto;
}

h1 {
    color: #333;
}

h2 {
    color: #555;
}

p {
    color: #666;
}

code {
    background-color: #f4f4f4;
    padding: 5px 10px;
    border-radius: 5px;
    font-family: monospace;
}
</style>
</head>
<body>

<div class="container">
    <h1>Individual Project Dmytro Radchenko</h1>
    <h2>Project for Testing Kanboard 12</h2>
    <p>The project is created for automated testing of project management software – Kanboard. Technologies and libraries such as testNG, Selenide, Rest Assured, and Allure are used.</p>

    <h2>Tools and Libraries</h2>
    <p>Your project utilizes the following tools and libraries:</p>
    <ul>
        <li>Kanboard</li>
    </ul>

    <h2>Installation and Running Instructions</h2>
    <p>Clone the repository:</p>
    <code>git clone git@github.com:Yroslavadudko/individualProjectMykolaDudko.git</code>
    <p>Ensure that Docker is installed on your machine.</p>
    <p>Download and save the docker-compose.yml file from <a href="#">here</a>.</p>
    <p>Execute the following command to start Kanboard using Docker:</p>
    <code>docker-compose up</code>
    <p>After the launch, find the administrator password in the terminal where you executed the <code>docker-compose up</code> command.</p>

    <h2>Running the Project Locally</h2>
    <p>Open Kanboard in your web browser.</p>
    <p>Use the following credentials to log in:</p>
    <ul>
        <li>Login: admin</li>
        <li>Password: admin</li>
    </ul>
    <p>For API tests, use the API key found in Kanboard settings (Settings -> API).</p>
    <p>Run the automated test:</p>
    <code>mvn clean test</code>
    <p>To choose which tests you want to execute, edit the configuration file.</p>

    <h2>Running the Allure Report</h2>
    <p>To generate and view Allure reports, use the following commands:</p>
    <p>Generate the report:</p>
    <code>mvn allure:report</code>
    <p>Generates an HTML report in the <code>target/site/allure-maven/index.html</code> directory.</p>
    <p>Open the report in the browser:</p>
    <code>mvn allure:serve</code>
    <p>Launches a local server and opens the report in the browser.</p>

    <h2>Testing Information</h2>
    <p>Kanboard: <a href="http://localhost/login">http://localhost/login</a> or <a href="http://127.0.0.1/login">http://127.0.0.1/login</a></p>
    <p>Login: admin</p>
    <p>Password: admin</p>
    <p>API key for API tests: Located in settings -> API</p>
    <p>Jenkins: <a href="http://localhost:8080">http://localhost:8080</a> (should redirect to <a href="http://localhost:8080/login?from=%2F">http://localhost:8080/login?from=%2F</a>)</p>
    <p>Administrator password: Found in the terminal where you executed the <code>docker-compose up</code> command.</p>
</div>

</body>
</html>
