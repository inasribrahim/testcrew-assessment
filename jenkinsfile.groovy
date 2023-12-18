pipeline{

    agent any

    stages{
        stage("Purge Docker date"){
            steps{
                bat("docker system prune -a --volumes -f")
                bat(" echo delete all image")
            }
        }

        stage("Start with container "){
            steps{
                bat("docker compose up -d --no-color --wait")
               bat(" echo run docker compose file ")

            }
        }

         stage("Docker compose state "){
            steps{
                bat("docker compose ps ")
            }
        }
        
        stage("Test Selenium Grid"){
            steps{
                bat(''' 
                    curl http://localhost:4444/ui/index.html#/
                    echo http://localhost:4444/ui/index.html#/sessions
                ''')
            }
        }

        stage("run testing on container image"){
            steps{
                bat(''' 
                    mvn clean test
                ''')
            }
        }
    }

}
