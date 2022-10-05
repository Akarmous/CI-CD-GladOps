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
            steps {
                withSonarQubeEnv('http://192.168.1.18:9000') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
            }
        }
    }
}
