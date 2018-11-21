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
                    }
                }
            }
        }
        stage('Publish Test Results') {
            junit '**/TEST-*.xml'
            androidLint pattern: '**/lint-results-*.xml'
        }
    }
    post {
        failure {
            // notify team of the failure
            mail to: 'randy.webster@globant.com', subject: 'Jenkins Build Failure', body: "Build ${env.BUILD_NUMBER} failed; ${env.BUILD_URL}"
        }
    }
}
