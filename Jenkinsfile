pipeline {
  parameters {
    string(name: 'IMAGE_NAME', defaultValue: 'hello')
    string(name: 'CONTAINER_NAME', defaultValue: 'hello')
  }
  agent { 
    label 'p3'
  }
  tools {
    jdk 'jdk8'
  }
  stages {
    stage('stop deamons') {
      steps {
        dir("productreview") {
          sh "./gradlew --stop"
        }        
      }
    }
    
    stage('Clean Jar') {
      steps {
        dir("productreview") {
          sh "./gradlew clean"
        }        
      }
    }
    
    stage('Boot Jar') {
      steps {
        dir("productreview") {
          sh "./gradlew bootJar"
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
