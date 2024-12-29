pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }

        stage('Clone') {
            steps {
                git branch: 'main1', 
                    credentialsId: 'aj', // Replace 'aj' with the correct Jenkins credentials ID
                    url: 'git@github.com:Ajay1672/new-Project-01-JAN-2024.git'
            }
        }

        stage('Clean') {
            steps {
                bat 'mvn clean' // Replace with 'sh' if running on Linux
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package' // Replace with 'sh' if running on Linux
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonumonu') { // Ensure 'sonumonu' is correctly configured in Jenkins
                    bat """
                        mvn sonar:sonar ^
                          -Dsonar.projectKey=Docker-Jenkins-Java-Application ^
                          -Dsonar.host.url=http://localhost:9000
                    """
                }
            }
        }

        stage('Quality Gate') {
            steps {
                script {
                    def qualityGate = waitForQualityGate() // Requires Jenkins SonarQube plugin
                    if (qualityGate.status != 'OK') {
                        error "Quality Gate check failed: ${qualityGate.status}"
                    } else {
                        echo "Quality Gate passed successfully!"
                    }
                }
            }
        }
    }
}
