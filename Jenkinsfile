pipeline {
    agent any

    //def env = System.getenv()
    //def jenkins_home_path = env['JENKINS_HOME']
    stages {
        stage('Download SourceCode') {
            steps {
                echo 'remove timeout...'
                echo 'Remove Original SourceCode and Packages'
                sh 'rm -rf /application/jenkins/deploy/*'
                echo 'Download SourceCode from GitHub..'
                sh 'git clone git@github.com:gh-yehl/fullstackuser.git "${JENKINS_FOLDER}/deploy"'
                echo  'git clone git@github.com:gh-yehl/fullstackuser.git "${JENKINS_FOLDER}/deploy"'
                echo "Source Code Download Completed"
            }
        }

        stage('Maven Build SourceCode') {
            steps {
                echo 'Maven Packaging SourceCode..'
                //sh '"${JENKINS_FOLDER}/deploy"/mvn package'
                echo 'Package SourceCode Completed'
            }
        }
        stage('Junit Test') {
            steps {
                echo 'Junit Testing..'
            }
        }
        stage('Deploy To Docker') {

            steps {
                echo 'Stop Users Container in Docker...'
                echo 'Deploying to Docker....'

                //print 'cmd /c d:\\testgroovy.bat'.execute()
                //print 'cmd /c git clone https://github.com/gh-yehl/fullstackuser.git d:\\new'.execute()
                //print "cmd /c git clone git@github.com:gh-yehl/fullstackuser.git ${jenkins_home_path}".execute()
                echo 'Deploying to Docker Done!'

            }
        }
    }
}