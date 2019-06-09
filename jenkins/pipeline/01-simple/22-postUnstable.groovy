pipeline {
  agent none

  stages {
    stage("Hello") {
      steps {
        echo "hello"
        // need to use script block to assign value
        script {
          currentBuild.result = "UNSTABLE"
        }
      }
    }
  }
  post {
    always {
      echo "I ALWAYS run first"
    }
    changed {
      echo "CHANGED is run second"
    }
    aborted {
      echo "ABORTED"
    }
    success {
      echo "SUCCESS"
    }
    unstable {
      echo "UNSTABLE runs after ALWAYS"
    }
    failure {
      echo "FAILURE"
    }
  }
}
