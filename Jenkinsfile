pipeline {

    agent any

    triggers {
             pollSCM('* * * * *')
     }

    tools { 
        maven 'apache-maven-3.5.4' 
        jdk 'Zulu_JDK_8.0.181' 
    }



    environment {
        PAYARA_HOME='C:\\rsachin\\sysprograms\\payara41'
    }


    parameters { 
        choice(
            name: 'Environments',
            choices: ['none', 'dev', 'tint', 'fint'], 
            description: 'Please choose environment'
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
                bat '%PATH%'
                bat '%JAVA_HOME%'
                bat '%PAYARA_HOME%'
            }
        }

        stage ('Build') {

            steps {
                bat 'mvn compile'
            }
        }

        stage ('Test') {

            steps {
                bat 'mvn test' 
            }

            post {
                success {
                    junit '**/target/surefire-reports/**/*.xml' 
                }
            }
        }

        stage ('Package') {

            steps {
                bat 'mvn package -DskipTests'
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
