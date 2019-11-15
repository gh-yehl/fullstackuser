pipeline {
    agent any

    //def env = System.getenv()
    //def jenkins_home_path = env['JENKINS_HOME']
    stages {
        stage('Download SourceCode') {
            steps {
                echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   Remove Original SourceCode and Packages    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
                sh 'rm -rf /application/jenkins/deploy'
                sh 'mkdir -p /application/jenkins/deploy'
                echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   Download SourceCode from GitHub  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
                sh 'git clone git@github.com:gh-yehl/fullstackuser.git "${JENKINS_FOLDER}/deploy"'
                echo "Source Code Download Completed!!!"
            }
        }

        stage('Maven Build SourceCode') {
            steps {
                echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  Maven Packaging SourceCode   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
                sh 'mvn -f "${JENKINS_FOLDER}/deploy"/pom.xml package'
                echo 'Package SourceCode Completed'
            }
        }
        stage('Junit Test') {
            steps {
                echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   Junit test   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
            }
        }
        stage('Deploy To Docker') {

            steps {
                echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   Stop Users Container in Docker   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
                sh 'docker stop users'
                echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   Deploying to Docker   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'

                //print 'cmd /c d:\\testgroovy.bat'.execute()
                //print 'cmd /c git clone https://github.com/gh-yehl/fullstackuser.git d:\\new'.execute()
                //print "cmd /c git clone git@github.com:gh-yehl/fullstackuser.git ${jenkins_home_path}".execute()
                echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   Deploying to Docker Done   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'

            }
        }
    }
}