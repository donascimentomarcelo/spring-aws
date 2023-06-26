pipeline {
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }
        stage('Unit Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker system prune -a -f'
                sh "docker container prune -a -f"
                sh "docker image prune -a -f"
                sh "docker network prune -a -f"
                sh "docker volume prune -a -f"
                sh './gradlew docker'
            }
        }
        stage('Push Docker image') {
            environment {
                DOCKER_HUB_LOGIN = credentials('docker-hub')
            }
            steps {
                sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                sh './gradlew dockerPush'
            }
        }
        stage('Deploy to AWS') {
            environment {
                DOCKER_HUB_LOGIN = credentials('docker-hub')
            }
            steps {
                withAWS(credentials: 'aws-credentials', region: env.AWS_REGION) {
                    sh './gradlew awsCfnMigrateStack awsCfnWaitStackComplete -PsubnetId=$SUBNET_ID -PdockerHubUsername=$DOCKER_HUB_LOGIN_USR -Pregion=$AWS_REGION --info --debug'
//                     sh './gradlew awsCfnMigrateStack awsCfnWaitStackComplete -PsubnetId=$SUBNET_ID -PdockerHubUsername=$DOCKER_HUB_LOGIN_USR -Pregion=$AWS_REGION --stacktrace'
                }
            }
        }
        stage('Cleaning up') {
          steps{
            sh "donascimentomarcelo/spring-aws:0.0.1-SNAPSHOT"
            sh "docker container prune -a -f"
            sh "docker image prune -a -f"
            sh "docker network prune -a -f"
            sh "docker volume prune -a -f"
          }
        }
    }
}