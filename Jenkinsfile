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
		stage('Docker Image Build ') {
		    steps {
			    sh 'docker build -t ${DockerHubUsername}/achat .'
		    }
		}
		stage("DockerCompose") {
			 steps {
			 sh 'docker-compose up'
			}
		}
	}
}
