pipeline {
    agent any
    tools {
    	maven 'M2_HOME'
    }
    stages {
      
        stage('Git') {
            steps {
                echo 'Pulliing ...';
                git branch: 'Ahmed', credentialsId: 'jenkins-ahmed-ci', url: 'https://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@github.com/Akarmous/CI-CD-GladOps.git'            }
        }
	stage('Compile') {
      		steps {
        		sh 'mvn compile'
      		}
    	}
		stage('Unit tests') {
      		steps {
        		sh 'mvn test'
      		}
    	}    
	    stage('Build') {
      		steps {
        		sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
      		}
    	}
	   
	    
        stage('SonarQube quality tests') {
		    steps {
		    sh "mvn sonar:sonar -Dsonar.projectKey=jenkins-ahmed -Dsonar.host.url=http://192.168.1.18:9000 -Dsonar.login=c3c260fec661be0c76af7f2bbc2e029ccab74278"
	        }
	    }
	stage('Deploy to NEXUS') {
			steps {
				sh'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
			}
		}
	   
	           
    }
}
