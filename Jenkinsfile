pipeline {
    agent {
        docker {
            image 'randr0id/android-docker'
            args '-v $HOME/.gradle'
        }
    }
    options {
        // stop the build early in case of compile or test failures
        skipStagesAfterUnstable()
    }
    stages {
        stage('Test') {
            steps {
                parallel {
                    stage('Unit Test') {
                        steps {
                            sh './gradlew unitTest'
                            junit '**/TEST-*.xml'
                        }
                        post {
                            always {
                                junit '**/TEST-*.xml'
                            }
                        }
                    }
                    stage('Lint Test') {
                        steps {
                            sh './gradlew lintRelease'
                            androidLint pattern: '**/lint-results-*.xml'
                        }
                        post {
                            always {
                                androidLint pattern: '**/lint-results-*.xml'
                            }
                        }
                    }
                }
            }
        }
    }
}