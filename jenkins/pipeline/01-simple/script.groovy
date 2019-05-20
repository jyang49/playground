pipeline {
  agent any

  stages {
    stage("Hello") {
      steps {
        echo "hello"
        // need to use script block to assign value
        script {
          hobby = 'reading and study'
          sh 'echo $hobby'
        }
      }
    }
  }
}
