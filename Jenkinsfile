pipeline {
    agent {
        label 'android'
    }

    stages {
        stage('Test') {
            when {
                anyOf {
                    branch 'master'
                    changeRequest()
                }
            }
            parallel {
                stage('Unit Test') {
                    steps {
                        sh './gradlew --info clean unitTest'
                    }
                    post {
                        always { junit '**/TEST-*.xml' }
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
        stage('Merge Build') {
            when { changeRequest() }
            steps {
                sh './gradlew clean assembleRelease'
            }
        }
        stage('Release Build') {
            when { branch 'master' }
            steps {
                sh "./gradlew clean assembleRelease -PbuildNumber=${env.BUILD_NUMBER}"
                archiveArtifacts '**/*release.apk'
            }
        }
    }

    /*post {
        failure {
            // notify team of the failure
            //mail to: 'somebody@liveperson.com', subject: "${env.JOB_NAME} Failed", charset: 'UTF-8', mimeType: 'text/html', body: "Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br><br> ${env.BUILD_URL}"
        }
    }*/
}
