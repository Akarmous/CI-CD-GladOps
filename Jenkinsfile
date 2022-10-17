pipeline {
    agent any
    tools {
    	maven 'MAVEN_HOME'
    }
    stages {
        stage('Show date') {
            steps {
		    ansiColor('vga'){
			    sh """date""" ;
			    emailext body: "${currentBuild.currentResult}: stage ${env.STAGE_NAME} build ${env.BUILD_NUMBER} More info at: ${env.BUILD_URL}", 
			    to: 'abdeslem.bc@gmail.com',
			    subject: "Jenkins Build ${currentBuild.currentResult}: Stage ${env.STAGE_NAME}" 
		    }
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
			 script {
				 try {
					 sh 'mvn -B -DskipTests clean package';
					currentBuild.result = 'SUCCESS'
				} catch (any) {
					currentBuild.result = 'FAILURE'
					throw any
				} finally {
					step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'abdeslem.bc@gmail.com', sendToIndividuals: true])
				}
			}
		}
	    }
	    
        stage('Testing maven') {
	  	steps {
			sh """mvn -version"""
	        }
	    }
	    
        stage("SonarQube analysis") {
            steps {
            	withSonarQubeEnv('My SonarQube Server') {
	            sh 'mvn clean -DskipTests package sonar:sonar'
              }
            }
          }
          
        stage("NEXUS") {
		steps {
			ansiColor('vga'){
			sh 'mvn clean deploy -DskipTests'
			}}
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
	    stage('Email Build Status'){
                steps{
			emailext body: "${currentBuild.currentResult}: Stage ${env.STAGE_NAME} build ${env.BUILD_NUMBER} More info at: ${env.BUILD_URL}", 
			    to: 'abdeslem.bc@gmail.com',
			    subject: "Jenkins Build ${currentBuild.currentResult}: Stage ${env.STAGE_NAME}" 
                }
            }
        
    }
	post {
    		always {
    		step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'abdo.est@live.fr', sendToIndividuals: true])
		}
	}
}
