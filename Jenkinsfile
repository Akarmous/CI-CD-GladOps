pipeline {
    agent any
    tools {
    	maven 'M2_HOME'
    }
    
	stages {
	stage('Checkout GIT ') {
            steps {
                echo 'Pulling ...';
                git branch: 'Wassim', url: 'https://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@github.com/Akarmous/CI-CD-GladOps.git'            
	    }
        }
	    
	 /* stage('COMPILE') {
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
	    } */
	    
       /* stage("SonarQube Analysis") {
            steps {
              withSonarQubeEnv('SonarQube') {
                sh 'mvn clean -DskipTests package sonar:sonar'
              }
            }
          }
	stage("NEXUS") {
        	steps {
		 sh 'mvn clean -DskipTests deploy'
              }
        }
	stage("TEST JUNIT"){
		steps{
		 sh'mvn test'
		}
		
	}*/
		
 /*    stage('Docker BUILD backend') {
      		steps {
        		sh '''docker build -t wabes/achatbackend:latest .
			docker login --username wabes --password 5Arctic-%2022
			docker push wabes/achatbackend:latest'''
      		}
    	} */
		/*stage('Docker BUILD front') {
      		steps {
        		sh '''cd crud-tuto-front
			docker build -t wabes/achatfront .
			docker login --username wabes --password 5Arctic-%2022
			docker push wabes/achatfront'''
      		}
    	}*/
	/*stage('Dockerfile') {
      		steps {
        		sh '''docker run -t wabes/achatfront .'''
      		}
    	}*/
		/*stage('Docker Build and Push') {
       steps {
         withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
           
           sh 'docker build -t wabes/achatbackend:latest .'
           sh 'docker push wabes/achatbackend:latest'
         }
       }
     }*/
		
		stage('Docker COMPOSE') {
      		steps {
        		sh 'docker-compose up'
      		}
    	}
		
             
    }
}
