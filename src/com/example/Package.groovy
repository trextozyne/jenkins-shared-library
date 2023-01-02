#!/usr/bin/env groovy

package com.example

class Package implements Serializable {
    def script

    Package(script) {
        this.script = script
    }

    def buildJarFile() {
        script.echo "building the application for branch $script.BRANCH_NAME "
        script.sh 'mvn package'
    }
}
