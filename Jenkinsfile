pipeline {
    agent any 
    stages {
        stage('Show date') {
            steps {
                sh """date"""
            }
        }
        stage('Checkout GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'abdessalem',
                url : 'https://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@github.com/Akarmous/CI-CD-GladOps.git';
            }
        }
        stage("build & SonarQube analysis") {
            agent any
            steps {                
              def mvnHome = tool name: 'Apache Maven 3.6.0', type: 'maven'
              sh "${mvnHome}/bin/mvn -B -DskipTests clean package sonar:sonar"
              }
          }
        
    }
}
