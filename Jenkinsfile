pipeline {
  agent any

  environment {
    SLACK_WEBHOOK_URL = credentials('SLACK_WEBHOOK_URL')
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
      node {
        script {
          sendSlack("✅ 빌드 성공 - ${env.JOB_NAME} #${env.BUILD_NUMBER}", "good")
        }
      }
    }
    failure {
      node {
        script {
          sendSlack("❌ 빌드 실패 - ${env.JOB_NAME} #${env.BUILD_NUMBER}", "danger")
        }
      }
    }
  }
}

def sendSlack(String msg, String color) {
  def payload = [
    attachments: [[
      color: color,
      text : msg + "\n🔗 <${env.BUILD_URL}|자세히 보기>"
    ]]
  ]
  def json = groovy.json.JsonOutput.toJson(payload)

  sh """
    curl -X POST -H 'Content-type: application/json' \
    --data '${json}' \
    ${SLACK_WEBHOOK_URL}
  """
}