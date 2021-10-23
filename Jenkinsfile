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
  }
  stages {
    stage('Build Jar') {
      steps {
        dir("productreview") {
          sh "./gradlew clean ./gradlew bootJar"
        }        
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
