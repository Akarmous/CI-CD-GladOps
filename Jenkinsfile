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
	 
	   
	    
        stage('Testing maven') {
		    steps {
		    sh """mvn -version"""
	        }
	    }
	    stage('Build Artifact - Maven') {
                     steps {
                     sh "mvn clean package -DskipTests=true"
                     archive 'target/*.jar'
                }
            }
	           
    }
}
