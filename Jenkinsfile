pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'jdk17'
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
                    sh 'mvn sonar:sonar -Dsonar.projectKey=java-design-pattern -Dsonar.host.url=http://192.168.0.17:9000 -Dsonar.login=cbd731cb3523e683a02c23819b2f388175830346 -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco-aggregate-all/jacoco.xml'
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