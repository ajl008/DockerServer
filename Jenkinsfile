pipeline {
    agent {
                docker {image 'maven:3.8.1-openjdk-11'}
            }
    stages {
        stage('Test') { 
            steps {
                sh 'mvn test' 
            }
        }
        stage('Build') {
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
                sh 'docker run -p 3333:8080 dockerserver'
            }
        }
    }
}
