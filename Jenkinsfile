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
		    git branch: 'Ahmed', credentialsId: 'jenkins-ahmed-ci', url: 'https://github.com/Akarmous/CI-CD-GladOps.git';
            }
        }
	      
	      
	stage('Testing maven') {
		steps {
		sh """mvn -version"""
	      }
	}
	
}
}
