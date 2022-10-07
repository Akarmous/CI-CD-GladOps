pipeline {
      agent any
	tools {
		maven 'M2_HOME'}
      stages {
        stage('Hello') {
	          steps {
		          echo 'Hello world'
	           }
		}
	      
	      stage('Checkout GIT ') {
            steps {
                echo 'Pulliing ...';
		    git branch: 'main', credentialsId: 'test-jenkins-github', url: 'https://github.com/Akarmous/CI-CD-GladOps.git'
            }
        }
	      
	      
	stage('Testing maven') {
		steps {
		sh """mvn -version"""
	      }
	}
	stage('Scan') {
		steps {
		withSonarQubeEnv(installationName: 'sq1') {
		sh 'mvn clean package sonar:sonar'
	      }
	}
	}
}
}
