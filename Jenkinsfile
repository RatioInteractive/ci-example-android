pipeline {
    agent {
        label 'android'
    }

    options {
        // stop the build early in case of compile or test failures
        skipStagesAfterUnstable()
    }

    stages {
        stage('Test') {
            parallel {
                stage('Unit Test') {
                    steps {
                        sh './gradlew clean unitTest'
                    }
                }

                stage('Lint Test') {
                    steps {
                        sh './gradlew clean lintRelease'
                        androidLint pattern: '**/lint-results-*.xml'
                    }
                }
            }
        }
    }

    post {
        always {
            junit '**/TEST-*.xml'
        }

        failure {
            // notify team of the failure
            mail to: 'randy.webster@globant.com', subject: "${env.JOB_NAME} Failed", charset: 'UTF-8', mimeType: 'text/html', body: "Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br><br> ${env.BUILD_URL}"
        }
    }
}
