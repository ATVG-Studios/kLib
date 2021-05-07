pipeline {
    agent any
    tools {
        gradle "Gradle 7.0"
    }
    stages {
        stage("Lint") {
            steps {
                sh("gradle lintKotlin")
            }
        }
        stage("Build") {
            steps {
                sh("gradle build")
            }
        }
        stage("Test") {
            steps {
                sh("gradle test")
                junit 'build/test-results/test/*.xml'
            }
        }
        stage("Package") {
            steps {
                sh("gradle shadowJar jar sourceJar")
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            }
        }
    }
    post {
        always {

        }
        success{

        }
        failure {

        }
        cleanup{
            deleteDir()
        }
    }
}