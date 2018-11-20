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
                        junit '**/TEST-*.xml'
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
}
