pipeline {
      agent any
	      tools {
		maven 'M2_HOME'
		        }

          stages {

	        stage('Checkout GIT ') {
                 steps {
                    echo 'Pulliing ...';
		            git branch: 'ALA', credentialsId: 'test-jenkins-github', url: 'https://github.com/Akarmous/CI-CD-GladOps.git';
                        }
                 }
/*

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


	        stage('SonarQube analysis') {
		        steps {
		        withSonarQubeEnv(installationName: 'sq1') {
		        sh 'mvn clean clean -DskipTests package sonar:sonar'
	                  }
	                }
	            }


            stage('JUnit/Mockito'){
                steps {
                sh 'mvn test'
                echo """Bravo! tous les tests sont pris en charge"""
                      }
                }


             stage("NEXUS") {
        	    steps {
		        sh 'mvn clean deploy -DskipTests'
                      }
                }
*/

             /*stage("DockerBuild") {
                steps {
                sh '''cd crud-tuto-front
                docker build -t alakrms/achatfront .'''
                }
                }

             stage("DockerLogin") {
                steps {
                sh 'docker login --username alakrms --password Azerty789+'
                }
                }

              stage("DockerPush") {
                 steps {
                 sh 'docker push alakrms/achatfront'
                }
                }*/

              stage("Docker-Compose") {
                 steps {
                 sh 'docker-compose up'
                }
                }







          }
      }
