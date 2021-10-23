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
    stage('stop deamons') {
      steps {
        dir("productreview") {
          sh "gradle --stop"
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
