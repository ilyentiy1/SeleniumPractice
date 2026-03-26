pipeline {
    agent any
    tools {
        maven "Maven 3.9.11"
    }
    docker {
        image 'maven:3.9-eclipse-temurin-23'
    }
    stages {
        stage('Build & compile') {
            steps {
                echo 'Starting build...'
                sh 'mvn clean compile test-compile'
                stash name: 'compiled-classes', includes: 'target/**'
            }
        }
        stage('Meta-Tests') {
            steps {
                echo 'Running meta-tests...'
                unstash 'compiled-classes'
                sh 'mvn test -Dgroups=meta -Dsurefire.skipAfterFailureCount=1'
            }
        }
        stage("UI-Tests") {
            steps {
                echo 'Running main ui-tests'
                unstash 'compiled-classes'
                sh 'mvn test -Dgroups=main'
            }
        }
    }

}