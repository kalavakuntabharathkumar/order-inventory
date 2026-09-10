pipeline {
 agent any
 stages {
  stage('Test'){steps{sh 'for d in user-service inventory-service order-service notification-service; do (cd $d && mvn test); done'}}
  stage('Build'){steps{sh 'docker compose build'}}
  stage('Deploy'){steps{echo 'Deploy to dev/staging/production using the configured Jenkins agents.'}}
 }
}
