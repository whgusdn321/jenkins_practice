pipeline {
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
          docker-compose up -d
        """
      }
    }
  }
}
