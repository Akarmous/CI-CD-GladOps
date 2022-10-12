pipeline {
    agent any
    tools {
    	maven 'MAVEN_HOME'
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
                git branch: 'abdessalem', credentialsId: '47d8419e-8cc7-442a-954a-c5590c279e70', url: 'https://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@github.com/Akarmous/CI-CD-GladOps.git';
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
          
        stage("NEXUS") {
			steps {
				sh 'mvn deploy -DskipTests'
              }
            }
          }  
        stage ("Tests unitaires") {
            steps {
                echo "*********test started*********"
                sh 'mvn test';
                echo "*********test finished*********"
                echo "*********Verification started*********"
                sh 'mvn verify'
                echo "*********verification finished*********"

            }
        }
        
    }
}
