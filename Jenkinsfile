pipeline {
    agent any

    environment {
        GRADLE_OPTS = "-Dorg.gradle.jvmargs=-Xmx2g"
    }

    options {
        timestamps()
    }

    parameters {
        string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'Branch to build')
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean assembleDebug'
            }
        }
    }

    post {
        success {
            slackNotify("✅ 빌드 성공 (${env.JOB_NAME} #${env.BUILD_NUMBER})", "good")
        }

        failure {
            slackNotify("❌ 빌드 실패 (${env.JOB_NAME} #${env.BUILD_NUMBER})", "danger")
        }
    }
}

def slackNotify(String message, String color) {
    withCredentials([string(credentialsId: 'SLACK_WEBHOOK_URL', variable: 'WEBHOOK')]) {
        sh """
        curl -X POST -H 'Content-type: application/json' --data '{
          "attachments": [
            {
              "color": "${color}",
              "text": "${message}",
              "footer": "Jenkins",
              "ts": $(date +%s)
            }
          ]
        }' $WEBHOOK
        """
    }
}