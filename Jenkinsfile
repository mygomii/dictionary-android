pipeline {
  agent any

  environment {
    SLACK_WEBHOOK_URL = credentials('SLACK_WEBHOOK_URL')
  }

  options {
    skipDefaultCheckout()
    timeout(time: 15, unit: 'MINUTES')
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        sh './gradlew clean assembleRelease'
      }
    }
  }

  post {
    success {
      script {
        def message = """
✅ *PR 빌드 성공*
• *Job:* ${env.JOB_NAME} #${env.BUILD_NUMBER}
• *Branch:* ${env.GIT_BRANCH}
🔗 <${env.BUILD_URL}|빌드 결과 보기>
"""
        sendSlack(message, 'good')
      }
    }
    failure {
      script {
        def message = """
❌ *PR 빌드 실패*
• *Job:* ${env.JOB_NAME} #${env.BUILD_NUMBER}
• *Branch:* ${env.GIT_BRANCH}
🔗 <${env.BUILD_URL}|빌드 결과 보기>
"""
        sendSlack(message, 'danger')
      }
    }
  }
}

// Slack 메시지 전송 함수
def sendSlack(String text, String color) {
  def payload = [
    attachments: [[
      color: color,
      text : text
    ]]
  ]
  def payloadJson = groovy.json.JsonOutput.toJson(payload)

  sh """
    curl -X POST -H 'Content-type: application/json' \
    --data '${payloadJson}' \
    ${SLACK_WEBHOOK_URL}
  """
}