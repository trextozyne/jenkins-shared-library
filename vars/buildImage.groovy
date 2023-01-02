#!/usr/bin/env groovy

import com.example.Docker

def call(String imgName) {
    def docker = new Docker(this).buildDockerImage(imgName)
    return docker
}
