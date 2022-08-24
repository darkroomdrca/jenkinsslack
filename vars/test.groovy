#!/usr/bin/env groovy
// vars/YourStepName.groovy

def start() {
   slackSend (teamDomain: "techverito", channel: "#gocd-build-notifications", tokenCredentialId: "32065985-0e36-4265-bdd8-8fc1e942f4f4",color: "good", 
            message: "Started ${env.JOB_NAME} #${env.BUILD_NUMBER} by ${currentBuild.getBuildCauses()[0].userId} (<${env.BUILD_URL}|Open>)")
}

def success() {
   slackSend (teamDomain: "techverito", channel: "#gocd-build-notifications", tokenCredentialId: "32065985-0e36-4265-bdd8-8fc1e942f4f4",color: "good", 
            message: "Success ${env.JOB_NAME} #${env.BUILD_NUMBER} by ${currentBuild.getBuildCauses()[0].userId} (<${env.BUILD_URL}|Open>)")
}

def Fail() {
   slackSend (teamDomain: "techverito", channel: "#gocd-build-notifications", tokenCredentialId: "32065985-0e36-4265-bdd8-8fc1e942f4f4",color: "good", 
            message: "Failed ${env.JOB_NAME} #${env.BUILD_NUMBER} by ${currentBuild.getBuildCauses()[0].userId} (<${env.BUILD_URL}|Open>)")
}
