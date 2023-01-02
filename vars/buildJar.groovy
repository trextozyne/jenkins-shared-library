#!/usr/bin/env groovy
import com.example.Package

def call() {
    return new Package(this).buildJarFile()
}