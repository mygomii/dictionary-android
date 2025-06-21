pipeline {
  agent any

  environment {
    SLACK_WEBHOOK_URL = credentials('SLACK_WEBHOOK_URL')
  }

  stages {
    stage('Build') {
      steps {
        sh './gradlew clean build'
      }
    }
  }

  post {
    success {
      script {
        def msg = "✅ 빌드 성공 — 브랜치 `${env.GIT_BRANCH}`, 작성자 `${env.BUILD_USER_ID}`"
        def payload = """
        {
          "attachments": [
            {
              "color": "good",
              "text": "$msg"
            }
          ]
        }
        """
        sh "curl -X POST -H 'Content-type: application/json' --data '$payload' $SLACK_WEBHOOK_URL"
      }
    }
    failure {
      script {
        def msg = "❌ 빌드 실패 — 브랜치 `${env.GIT_BRANCH}`, 작성자 `${env.BUILD_USER_ID}`"
        def payload = """
        {
          "attachments": [
            {
              "color": "danger",
              "text": "$msg"
            }
          ]
        }
        """
        sh "curl -X POST -H 'Content-type: application/json' --data '$payload' $SLACK_WEBHOOK_URL"
      }
    }
  }
}