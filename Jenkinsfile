pipeline {
    agent any
    environment {
        GARGS="GRADLE=gradle"
    }
    stages {
        stage("Lint") {
            steps {
                sh("make lint $GARGS")
            }
        }
        stage("Build") {
            steps {
                sh("make compile $GARGS")
            }
        }
        stage("Test") {
            steps {
                sh("make compile test $GARGS")
                junit 'build/test-results/test/*.xml'
            }
        }
        stage("Package") {
            steps {
                sh("make package $GARGS")
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            }
        }
    }
}