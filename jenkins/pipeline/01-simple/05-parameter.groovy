pipeline {
  agent any 

  parameters {
    string(name: 'hobby', description: 'favorite hobby', defaultValue: 'reading')
    booleanParam(name: 'study', description: 'study on weekend', defaultValue: true)
  }

  stages {
    stage('show string parameter') { 
      steps {
        echo params.hobby
      }
    }
    stage('show boolean parameter') { 
      steps {
        echo params.study
      }
    }
  }
}
