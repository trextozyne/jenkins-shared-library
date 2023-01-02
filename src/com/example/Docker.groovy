#!/usr/bin/env groovy

package com.example

class Docker implements Serializable { //supports saving state of excecution if pipeline is paused and resumed
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imgName) {
        script.echo 'bilding docker image...'
        script.sh "docker build -t $imgName ."

    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: '	Dockerhub-repo', passwordVariable: 'PASSWD', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASSWD | docker login -u $script.USER --password-stdin"
        }
    }

    def dockerPush(String imgName) {
        script.sh "docker push ${imgName}"
    }
}
