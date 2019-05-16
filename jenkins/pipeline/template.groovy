pipeline {
  //agent any 
  agent {label 'agent1'}
  
  options {
    buildDiscarder(logRotator(numToKeepStr: '12'))
    timestamps() 
    retry(2)
  }

  parameters {
    string(name: 'hobby', description: 'favorite hobby', defaultValue: 'reading')
    string(name: 'mysleep', description: 'delay seconds', defaultValue: '10')
  }

  stages {
    stage('Build') { 
      steps {
        echo "build 1"
        echo "my hobby: " + params.hobby
        sh "echo my hobby with sh: ${hobby}"
        echo "build 2"
        sh "sleep ${mysleep}"
      }
    }
    stage('Test') { 
      steps {
        echo "test 1"
        // error "fail the test"
        echo("test 2") // function format with ()
      }
    }
    stage('Deploy') { 
      steps {
        echo "deploy 1"
        echo "deploy 2"
      }
    }
  }
  post {
    always {
      echo "always executed"
      /*
      mail to: "jason_yang490@yahoo.com",
           subject: "testing email from Jenkins",
           body: "mail body"
      */
    }
    success {
      echo "executed when success"
    }
    failure {
      echo "executed when failed"
    }
  }
}
