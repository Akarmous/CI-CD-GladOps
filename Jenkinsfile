pipeline {

agent any

stages {



stage('Testing pass - 1') {
steps {
sh 'exit 0'
}
}

stage('SonarQube test') {
			steps {
				sh "mvn sonar:sonar -Dsonar.projectKey=projetci -Dsonar.host.url=http://192.168.1.18:9000 -Dsonar.login=e7a84d5e31598a022de5e137d8420ac5187e548e"
			}
	 

		}


}  

}
