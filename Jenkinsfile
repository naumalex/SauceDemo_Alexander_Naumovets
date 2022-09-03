 pipeline {
     agent any

     tools {
         // Install the Maven version configured as "M3" and add it to the path.
         maven "m3"
     }

     parameters {
        gitParameter (branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH')

        suite (
        defaultValue: 'regression',
        name: 'SUITE_NAME',
        choices: ['regression', 'smoke', 'negative'],
        trim: true)
      }

   stages {
         stage('Run tests') {
             steps {
                 // Get some code from a GitHub repository
                 git branch: "${params.BRANCH}", url: 'https://github.com/naumalex/SauceDemo_Alexander_Naumovets.git'

                 // Run Maven on a Unix agent.
                bat "mvn -Dmaven.test.failure.ignore=true -DsuiteXmlfile={params.SUITE_NAME}.xml clean test"

                 // To run Maven on a Windows agent, use
                 // bat "mvn -Dmaven.test.failure.ignore=true clean package"
             }

             post {
                 // If Maven was able to run the tests, even if some of the test
                 // failed, record the test results and archive the jar file.
                 success {
                     junit '**/target/surefire-reports/TEST-*.xml'
                 }
             }
         }
         stage('Generate Allure report') {
             steps {
                  script {
                     allure([
                      includeProperties: false,
                      jdk: '',
                      properties: [],
                      reportBuildPolicy: 'ALWAYS',
                      results: [[path: 'target/allure-results']]
                      ])
                 }
             }
         }

     }
 }