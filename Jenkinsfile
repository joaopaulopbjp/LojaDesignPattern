pipeline {
    agent any
    tools {
        maven 'Maven 3.8.6'
        jdk 'jdk11'
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            steps {
                sh 'java --version'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=java-design-pattern -Dsonar.host.url=http://localhost:9000 -Dsonar.login=cbd731cb3523e683a02c23819b2f388175830346'
                }
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}