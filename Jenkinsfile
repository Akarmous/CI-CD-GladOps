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
        stage('Testing SonarQube') {
		    steps {
		    sh "mvn sonar:sonar -Dsonar.projectKey=jenkins-ahmed -Dsonar.host.url=http://192.168.1.18:9000 -Dsonar.login=c3c260fec661be0c76af7f2bbc2e029ccab74278"
	        }
	    }
	stage('Nexus') {
			steps {
				//sh 'mvn clean deploy -DskipTests'
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			}
		}
	   
	           
    }
}
