pipeline {
  agent any

  environment {
    SLACK_WEBHOOK_URL = credentials('SLACK_WEBHOOK_URL')
  }

  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/mygomii/dictionary-android.git'
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
      script {
        slackNotify("✅ 빌드 성공", "good")
      }
    }
    failure {
      script {
        slackNotify("❌ 빌드 실패", "danger")
      }
    }
  }
}

def slackNotify(String message, String color) {
  sh """
    curl -X POST -H 'Content-type: application/json' --data '{
      "attachments": [
        {
          "color": "${color}",
          "text": "${message}"
        }
      ]
    }' ${SLACK_WEBHOOK_URL}
  """
}