pipeline {

    agent any

    tools { 
        maven 'apache-maven-3.5.4' 
        jdk 'Zulu_JDK_8.0.181' 
    }

    parameters { 
        choice(
            name: 'environment', 
            choices: ['none', 'dev', 'tint', 'fint'], 
            description: ''
        ) 
    }

    stages {

        stage ('Initialize') {
            steps {
                bat 'echo PATH = %PATH%'
            }
        }

        stage ('Build') {

            steps {
                bat 'mvn -f flexapp-calendar-parent/pom.xml compile'
            }

        }

        stage ('Test') {

            steps {
                bat 'mvn -f flexapp-calendar-parent/pom.xml test' 
            }

            post {
                success {
                    junit '**/target/surefire-reports/**/*.xml' 
                }
            }
        }

        stage ('Package') {

            steps {
                bat 'mvn -f flexapp-calendar-parent/pom.xml package -Ppackage -PSKIP.INTEGRATION.TEST -DskipTests'
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
