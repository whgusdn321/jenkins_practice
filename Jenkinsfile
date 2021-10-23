pipeline {
  parameters {
    string(name: 'IMAGE_NAME', defaultValue: 'hello')
    string(name: 'CONTAINER_NAME', defaultValue: 'hello')
  }
  agent { 
    label 'hello'
  }
  tools {
    jdk 'JDK-8'
  }
  stages {
    stage('Build Jar') {
      steps {
        sh "./gradlew bootRun"
      }
    }

        
    stage('Run Docker Compose') {
      steps {
        sh """
          docker-compose down --volumes
          sudo docker-compose up
        """
      }
    }
  }
}
