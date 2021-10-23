pipeline {
  parameters {
    string(name: 'IMAGE_NAME', defaultValue: 'hello')
    string(name: 'CONTAINER_NAME', defaultValue: 'hello')
  }
  agent { 
    label 'master'
  }
  tools {
    jdk 'JDK'
    gradle 'gradle'
    dockerTool 'docker'
  }
  stages {
    stage('Build Jar') {
      steps {
        sh "./productreview/gradlew bootJar"
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
