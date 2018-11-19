pipeline {
    agent {
        //label 'android'
        docker {
            image 'randr0id/android-docker'
            label 'android'
        }
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
                        sh './gradlew unitTest'
                        junit '**/TEST-*.xml'
                    }
                }
                stage('Lint Test') {
                    steps {
                        sh './gradlew lintRelease'
                        androidLint pattern: '**/lint-results-*.xml'
                    }
                }
            }
        }
    }
}
