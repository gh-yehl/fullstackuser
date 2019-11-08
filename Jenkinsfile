pipeline {
    agent any

    stages {
        stage('Download SourceCode') {
                    steps {
                        echo 'Download from GitHub..'
                    }
                }
        stage('Build SourceCode') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy To Docker') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}