pipeline {

    agent any
    stages {

        stage('Checkout Codebase'){
            steps{
                cleanWs()
                checkout scm: [$class: 'GitSCM', branches: [[name: '*/main']],userRemoteConfigs:
                [[credentialsId: 'github-ssh-key-1', url: 'git@github.com:Bastur/595Test2.git']]]
            }
        }

        stage('Build'){
            steps{
                sh "chmod a+rwxrwxrwx ./HelloWorld"
                dir("./HelloWorld"){
                    sh "pwd"
                }
                
                sh "ls -all"
                sh "chmod +x -R ./HelloWorld/src"
                sh 'mkdir ./HelloWorld/lib'
                sh 'cd lib/ ; wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.0/junit-platform-console-standalone-1.7.0-all.jar'
                sh 'cd HelloWorld/src ; javac -cp "../lib/junit-platform-console-standalone-1.7.0-all.jar" HelloWorldTest.java HelloWorld.java'
            }
        }

        stage('Test'){
            steps{
                sh 'cd HelloWorld/src/ ; java -jar ../lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class HelloWorldTest'
                junit 'src/reports/*-jupiter.xml'
            }
        }

        stage('Deploy'){
            steps{
                sh 'cd src/ ; java HelloWorld' 
            }
        }
    }

}
