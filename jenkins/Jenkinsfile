pipeline {
    agent any
    stages {
        agent {
            docker {image 'maven:3.8.1-openjdk-11'}
        }
        stage('Test') { 
            steps {
                sh 'mvn test' 
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Docker build') { 
            steps {
                sh 'docker build -t dockerserver .'
            }
        }
        stage('Docker run') {
            steps {
                sh 'docker run -t -i -p 3333:8080 dockerserver'
            }
        }
    }
}
