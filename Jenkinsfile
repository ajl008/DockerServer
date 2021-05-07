pipeline {
    agent any
    stages {
        stage('Test') { 
            agent {
                docker {image 'maven:3.8.1-openjdk-11'}
            }
            steps {
                sh 'mvn test' 
            }
        }
        stage('Build') {
            agent {
                docker {image 'maven:3.8.1-openjdk-11'}
            }
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Deploy') { 
            steps {
                sh 'docker build -t dockerserver .'
                sh 'docker kill $(docker ps -q)'
                sh 'docker rm $(docker ps -a -q)'
                sh 'docker run -d -p 5555:8000 dockerserver'
            }
        }
    }
}
