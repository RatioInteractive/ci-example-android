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
                sh './gradlew unitTest'
                junit '**/TEST-*.xml'
            }
        }
    }
}