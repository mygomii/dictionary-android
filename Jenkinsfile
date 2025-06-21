pipeline {
    agent any

    environment {
        SLACK_CREDENTIAL_ID = 'SLACK_WEBHOOK_URL'
    }

    stages {
        stage('Build') {
            steps {
                sh './gradlew clean assembleRelease'
            }
        }
    }

    post {
        success {
            node {
                withCredentials([string(credentialsId: "${env.SLACK_CREDENTIAL_ID}", variable: 'WEBHOOK')]) {
                    sh '''
                    curl -X POST -H 'Content-type: application/json' \
                    --data '{"text":"✅ 빌드 성공 - ${JOB_NAME} #${BUILD_NUMBER}"}' $WEBHOOK
                    '''
                }
            }
        }
        failure {
            node {
                withCredentials([string(credentialsId: "${env.SLACK_CREDENTIAL_ID}", variable: 'WEBHOOK')]) {
                    sh '''
                    curl -X POST -H 'Content-type: application/json' \
                    --data '{"text":"❌ 빌드 실패 - ${JOB_NAME} #${BUILD_NUMBER}"}' $WEBHOOK
                    '''
                }
            }
        }
    }
}