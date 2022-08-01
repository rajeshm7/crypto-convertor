pipeline {
    agent any
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/rajeshm7/crypto-convertor']]])
                sh './mvnw clean install'
            }
        }
        stage('Run tests'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/rajeshm7/crypto-convertor']]])
                sh './mvnw test'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t 7rajesh7/crypto-convertor .'
                }
            }
        }
        stage('Push Image to Docker Hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'docker-hub-password', variable: 'dockerhubpassword')]) {
                        sh 'docker login -u 7rajesh7 -p ${dockerhubpassword}'
                        sh 'docker push 7rajesh7/crypto-convertor'
                    }
                }
            }
        }
        stage('Deploy to k8s'){
            steps{
                script{
                    echo "This step should be deploying the docker image to Kubernetes. Since I don't have AWS account, I didnt add it."
                }
            }
        }
    }
}