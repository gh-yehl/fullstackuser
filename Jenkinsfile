pipeline {
    agent any

    stages {
        stage('Download SourceCode') {
            steps {
                echo 'Download SourceCode from GitHub..'
            }
        }

        stage('Maven Build SourceCode') {
            steps {
                echo 'Maven Building..'
            }
        }
        stage('Junit Test') {
            steps {
                echo 'Junit Testing..'
            }
        }
        stage('Deploy To Docker') {
            steps {
                echo 'Deploying to Docker....'
                print 'cmd /c dir d:\\workspace'.execute().text
            }
        }
    }
}