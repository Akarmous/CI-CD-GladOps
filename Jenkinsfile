pipeline {

agent any

stages {



stage('Testing pass - 1') {
steps {
sh 'exit 0'
}
}


stage('Build Artifact - Maven') {
steps {
sh "mvn clean package -DskipTests=true"
archive 'target/*.jar'
}
}


}  

}
