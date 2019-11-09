
def jenkins_home_path = System.getenv("JENKINS_HOME") + "\\package"

pipeline {
    agent any

    //def env = System.getenv()
    //def jenkins_home_path = env['JENKINS_HOME']
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
                echo '${jenkins_home_path}'
                //print 'cmd /c d:\\testgroovy.bat'.execute()
                //print 'cmd /c git clone https://github.com/gh-yehl/fullstackuser.git d:\\new'.execute()
                print "cmd /c git clone git@github.com:gh-yehl/fullstackuser.git ${jenkins_home_path}".execute()
                //["git", "clone", "git@github.com:gh-yehl/fullstackuser.git","${jenkins_home_path}"].execute()
                echo 'Deploying to Docker Done!'

            }
        }
    }
}