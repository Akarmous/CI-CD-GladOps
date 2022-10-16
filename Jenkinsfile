pipeline {
    agent any
    tools {
    	maven 'M2_HOME'
    }
    
        stage('Checkout GIT ') {
            steps {
                echo 'Pulling ...';
                git branch: 'Wassim', url: 'https://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@github.com/Akarmous/CI-CD-GladOps.git'            }
        }
	    
	    stage('COMPILE') {
      		steps {
        		sh 'mvn compile'
      		}
    	}
	    stage('BUILD') {
      		steps {
        		sh 'mvn -B -DskipTests clean package'
      		}
    	}
	    
        stage('MVN TEST') {
		    steps {
		    sh """mvn -version"""
	        }
	    }
	    
        stage("build & SonarQube analysis") {
            steps {
              withSonarQubeEnv('SonarQube') {
                sh 'mvn clean -DskipTests package sonar:sonar'
              }
            }
          }
        
        
    }
}
