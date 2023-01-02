#!/usr/bin/env groovy

def call(String imgName) {
    echo 'bilding docker image...'
    withCredentials([usernamePassword(credentialsId: '	Dockerhub-repo',passwordVariable: 'PASSWD', usernameVariable: 'USER')]) {
        sh "docker build -t $imgName ."
        sh 'echo $PASSWD | docker login -u $USER --password-stdin'
        sh "docker push ${imgName}"
    }
}
