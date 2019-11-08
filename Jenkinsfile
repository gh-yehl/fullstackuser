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
                echo '%JENKINS_HOME%\\package'
                //print 'cmd /c d:\\testgroovy.bat'.execute()
                //print 'cmd /c git clone https://github.com/gh-yehl/fullstackuser.git d:\\new'.execute()
                print 'git clone git@github.com:gh-yehl/fullstackuser.git d:\\new'.execute()
                echo 'Deploying to Docker Done!'
            }
        }
    }
}