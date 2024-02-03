pipeline {
    agent any
    options {
        timeout(time: 1, unit: 'HOURS')
    }
    triggers {
        cron('0 18 * * *')
    }
    parameters {
         string(name: 'suite', description: 'Enter the name of the Test Suite', defaultValue: 'FullTest')
         string(name: 'baseUrl', description: 'Validate Application URL', defaultValue: 'http://localhost')
    }
    environment {
        mailRecipients = 'djdmonqa@gmail.com'
    }
    tools {
        jdk 'JDK'
        maven 'Maven'
    }
    stages {
        stage("Run Tests") {
            steps {
                script {
                    sh "./mvnw test"
                }
            }
        }
        stage("Publish Allure Report") {
            steps {
                allure([includeProperties: false,
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
}
