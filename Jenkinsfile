pipeline {
	agent any
	tools {
		maven 'MAVEN_HOME'
	}
	options {
        	ansiColor('xterm')
	}
	stages {
		
		stage('GIT ') {
		    steps {
					echo "\033[34m*********Stage GIT Started*********\033[0m";
			echo 'Pulliing ...';
			git branch: 'abdessalem', credentialsId: '47d8419e-8cc7-442a-954a-c5590c279e70', url: 'https://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@github.com/Akarmous/CI-CD-GladOps.git';
					echo "\033[42m\033[97m*********GIT pulling finished with SUCCESS *********\033[0m"
		    }
		}
		stage('BUILD') {
			steps {
				script {
					try {
						echo "\033[34m*********Stage BUILD Started*********\033[0m";
						sh 'mvn -B -DskipTests clean package';
						echo "\033[42m\033[97m*********Project BUILD finished with SUCCESS *********\033[0m"
						currentBuild.result = 'SUCCESS'
					} catch (any) {
						echo "\033[31m*********BUILD finished with FAILURE *********\033[0m" ;
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
				echo "\033[42m\033[97m*********SonarQube analysis finished with SUCCESS *********\033[0m"
            	}
        	}
		}
		stage("NEXUS") {
			steps {
				script {
					try {
						echo "\033[34m*********Stage NEXUS Started*********\033[0m";
						sh 'mvn clean deploy -DskipTests'
						echo "\033[42m\033[97m*********NEXUS deployement finished with SUCCESS *********\033[0m"
					} catch(any) {
						echo "\033[31m*********NEXUS deployement finished with FAILURE *********\033[0m" ;
						throw any
					} finally{
						echo "\033[34m*********Mail Sending*********\033[0m";
						emailext body: """${currentBuild.currentResult}: stage "NEXUS" build n°${env.BUILD_NUMBER}  
						More info at: ${env.BUILD_URL}""", 
		    			to: 'abdeslem.bc@gmail.com',
		    			subject: """ Jenkins stage Build ${currentBuild.currentResult}: Stage "${env.STAGE_NAME}" """
					}
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
		stage('Back Image Build') {
		    steps {
				echo "\033[34m*********Building Back Image started*********\033[0m";
			    sh 'docker build -t ${DockerHubUsername}/achat .';
				echo "\033[42m\033[97m*********Image Building finished with SUCCESS *********\033[0m"
		    }
		}
		stage('Front Image Build ') {
		    steps {
				echo "\033[34m*********Building Front Image started*********\033[0m";
			    sh '''cd crud-tuto-front
			    docker build -t ${DockerHubUsername}/achatfront .''';
				echo "\033[42m\033[97m*********Image Building finished with SUCCESS *********\033[0m"
		    }
		}
		stage('DockerHub Push') {
			steps {
				echo "\033[34m*********Pushing Front&back Image started*********\033[0m";
				sh '''docker login -u ${DockerHubUsername} -p ${DockerHubPassword} 
				docker push ${DockerHubUsername}/achat
				docker push ${DockerHubUsername}/achatfront''';
				echo "\033[42m\033[97m*********Image Pushing finished with SUCCESS *********\033[0m"
            }
        }
		stage("DockerCompose") {
			 steps {
				echo "\033[34m*********Starting application*********\033[0m";
				sh 'docker-compose up -d';
				echo "\033[42m\033[97m*********Apllication Is Started *********\033[0m"
			}
		}
	}
	post {
    	always {
    		step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'abdeslem.bc@gmail.com', sendToIndividuals: true])
		}
	}
}