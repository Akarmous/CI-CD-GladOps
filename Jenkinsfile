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
        stage('SonarQube analysis') {
         environment {
                SCANNER_HOME = tool 'sonar*'
            }
        steps{
        withSonarQubeEnv('sonarqube-8.9.7')
    }
        }
}
