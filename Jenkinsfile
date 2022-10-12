pipeline {
    agent any
    tools {
    	maven 'M2_HOME'
    }
    stages {
        stage('Show date') {
            steps {
                sh """date"""
            }
        }
        stage('Checkout GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'Ahmed', credentialsId: 'jenkins-ahmed-ci', url: 'https://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@github.com/Akarmous/CI-CD-GladOps.git'            }
        }
	  
	stage('Build') {
      	    steps {
                sh 'mvn -B -DskipTests clean package'
      		  }
    	}
	    

	    
        stage('Testing maven') {
		    steps {
		    sh """mvn -version"""
	        }
	    }
	           
    }
}
