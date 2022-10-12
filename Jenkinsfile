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
                git branch: 'Wassim', url: 'https://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@github.com/Akarmous/CI-CD-GladOps.git'            }
        }
	    
	    stage('compiler') {
      		steps {
        		sh 'mvn compile'
      		}
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
	    
        stage("build & SonarQube analysis") {
            steps {
              withSonarQubeEnv('My SonarQube Server') {
                sh 'mvn clean -DskipTests package sonar:sonar'
              }
            }
          }
        
        
    }
}
