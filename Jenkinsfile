pipeline {

    agent any

    triggers {
             pollSCM('* * * * *')
     }

    tools { 
        maven 'apache-maven-3.6.0'
        jdk 'jdk1.8.0_191'
    }



    environment {
        PAYARA_HOME='C:\\rsachin\\sysprograms\\payara41'
    }


    parameters { 
        choice(
            name: 'Environments',
            choices: ['none', 'dev', 'tint', 'fint'], 
            description: 'Please choose environment..........2'
        )

        choice(
            name: 'Build Type',
            choices: ['Snapshot', 'Release'],
            description: 'Choose between Build Type'
        )
    }

    stages {

        stage ('Initializeee') {
            steps {
                script {
                    echo 'Please WORK'
                    sh 'mvn clean package'
                }
            }
        }

        stage ('Build') {

            steps {
                script {
                    echo 'Please compile'
                }
            }
        }

        stage ('Test') {

            steps {
                script {
                    echo 'Please test'
                }
            }

            post {
                success {
                    junit '**/target/surefire-reports/**/*.xml' 
                }
            }
        }

        stage ('Package') {

            steps {
                script {
                    echo 'Please package -DskipTests'
                }
            }

        }

        stage ('Deployment') {

            when {
                // Only say hello if a "greeting" is requested
                expression { params.environment != 'none' }
            }

            steps {

                script {

                    if (params.environment == "dev") {
                        echo "Deploying to dev..."
                    } else if (params.environment == "tint") {
                        echo "Deploying to tint..."
                    } else if (params.environment == "fint") {
                        echo "Deploying to fint..."
                    } else {
                        echo "Not deploying."
                    }

                }

            }

        }

    }
}
