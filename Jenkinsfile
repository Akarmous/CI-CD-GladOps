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
                git branch: 'main',
                url : 'https://github.com/Akarmous/CI-CD-GladOps.git';
            }
        }
    }
}
