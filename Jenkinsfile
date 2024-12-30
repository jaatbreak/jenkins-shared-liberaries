@Library('shared') _
pipeline {
    agent any
    stages {
        stage('Clone Code') {
            steps {
                script {
                    clone('https://github.com/jaatbreak/server_monitor_web.git', 'main')
                }
            }
        }
        stage('Build Image') {
            steps {
                script {
                    dockerBuild("monitor_server", "latest") // Example build
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    dockerPush("monitor_server", "latest", "amansingh12")
                }
            }
        }
        stage('deploy container'){
            steps{
                script{
                       // Call the shared library function
                    dockerrun(80, 5000, 'monitor_server:latest')
                }
            }
        }
    }
}
