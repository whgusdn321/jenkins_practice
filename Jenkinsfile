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
      
    stage('Clean boot Jar') {
      steps {
        dir("productreview") {
          sh "./gradlew clean bootJar"
        }        
      }
    }
        
    stage('Run Docker Compose') {
      steps {
        sh """
          docker-compose down
          docker-compose up -d
        """
      }
    }
  }
}
