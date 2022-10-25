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
					}
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
					}
				}
			}
    	}
		stage('Image') {
		    steps {
			    sh 'docker build -t ${DockerHubUsername}/achat .'
		    }
		}
		stage('DockerHub ') {
            steps {
		    sh '''docker login -u ${DockerHubUsername} -p ${DockerHubPassword} 
		    docker push ${DockerHubUsername}/achat '''
            }
        }
		stage("DockerCompose") {
			 steps {
			 sh 'docker-compose up -d'
			}
		}
	}
}
