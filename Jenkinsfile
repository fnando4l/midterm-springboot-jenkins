pipeline {
    agent any
    options { timestamps(); skipDefaultCheckout(true) }
    stages {
        stage('Checkout') { steps { checkout scm } }
        stage('Test') { steps { sh 'mvn -B clean test' } }
        stage('Build Fat JAR') {
            steps {
                sh 'mvn -B package -DskipTests'
                sh 'jar tf target/devops-demo-1.0.0.jar | grep BOOT-INF/lib'
            }
        }
        stage('Archive') {
            steps { archiveArtifacts artifacts: 'target/devops-demo-1.0.0.jar', fingerprint: true }
        }
    }
    post { always { junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: true } }
}
