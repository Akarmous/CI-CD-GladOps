pipeline {
	agent any
	tools {
		maven 'MAVEN_HOME'
		}
	options {
        ansiColor('xterm')
    }
	stages {
		/*stage('Show date') {
            steps {
		    	ansiColor('vga'){
			    	sh """date""" ;
			    	emailext body: """${currentBuild.currentResult}: stage "${env.STAGE_NAME}" build n°${env.BUILD_NUMBER}  
					More info at: ${env.BUILD_URL}""", 
			    	to: 'abdeslem.bc@gmail.com',
			    	subject: """ Jenkins stage Build ${currentBuild.currentResult}: Stage "${env.STAGE_NAME}" """ 
		    	}
	    	}
        }*/
        stage('GIT ') {
            steps {
				echo "\033[34m*********Stage GIT Started*********\033[0m";
            	echo 'Pulliing ...';
                git branch: 'abdessalem', credentialsId: '47d8419e-8cc7-442a-954a-c5590c279e70', url: 'https://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@github.com/Akarmous/CI-CD-GladOps.git';
            }
        }
		stage('BUILD') {
			steps {
				script {
					try {
						echo "\033[34m*********Stage BUILD Started*********\033[0m";
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
		stage("SonarQube") {
    		steps {
				echo "\033[34m*********Stage SonarQube Started*********\033[0m";
	        	withSonarQubeEnv('My SonarQube Server') {
					sh 'mvn clean -DskipTests package sonar:sonar'
            	}
        	}
		}	    
    	stage("NEXUS") {
			steps {
				echo "\033[34m*********Stage NEXUS Started*********\033[0m";
				ansiColor('vga'){
					sh 'mvn clean deploy -DskipTests'
				}
			}
    	}
    	stage ("JUNIT / MOCKITO") {
	    	steps {
				script {
					try {
						echo "\033[34m*********Stage JUNIT/MOCKITO Started*********\033[0m";						
						sh 'mvn test';
						sh 'mvn verify';
						echo "\033[42m\033[97m*********Test finished with SUCCESS *********\033[0m"
					}catch (any) {
						echo "\033[31m*********Test finished with FAILURE *********\033[0m" ;
						throw any
					} finally {
						echo "\033[34m*********Mail Sending*********\033[0m";
						emailext body: """${currentBuild.currentResult}: stage "JUNIT / MOCKITO" build n°${env.BUILD_NUMBER}  
						More info at: ${env.BUILD_URL}""", 
		    			to: 'abdeslem.bc@gmail.com',
		    			subject: """ Jenkins stage Build ${currentBuild.currentResult}: Stage "${env.STAGE_NAME}" """ 
					} 
				}          	
			}
    	}
	}
	post {
    	always {
    		step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'abdeslem.bc@gmail.com', sendToIndividuals: true])
		}
	}
}