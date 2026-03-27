pipeline {
    agent any
    tools {
        maven "Maven 3.9.11"
        jdk 'Eclipse Temurin 23'
    }
    stages {
        stage('Build & compile') {
            steps {
                echo 'Starting build...'
                sh 'mvn clean compile test-compile -U'
                stash name: 'compiled-classes', includes: 'target/**'
            }
        }
        stage('Meta-Tests') {
            steps {
                echo 'Running meta-tests...'
                unstash 'compiled-classes'
                sh 'mvn test -DsuiteXmlFile=src/meta-test/resources/testng-meta.xml'
            }
        }
        stage("UI-Tests") {
            steps {
                echo 'Running main ui-tests'
                unstash 'compiled-classes'
                sh 'mvn test -DsuiteXmlFile=src/test/resources/testng-main.xml'
            }
        }
    }
    post {
        always {
            script {
                echo 'Пайплайн завершен.'
                // Здесь можно использовать sh, allure и т.д.
            }
        }
    }

}