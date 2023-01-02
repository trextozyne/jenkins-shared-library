#!/usr/bin/env groovy

def call() {
    echo 'bilding docker image...'
    withCredentials([usernamePassword(credentialsId: '	Dockerhub-repo',passwordVariable: 'PASSWD', usernameVariable: 'USER')]) {
        sh 'docker build -t trex1987/my-repo:jma-2.0 .'
        sh 'echo $PASSWD | docker login -u $USER --password-stdin'
        sh 'docker push trex1987/my-repo:jma-2.0'
    }
}
