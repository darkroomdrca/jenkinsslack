#!/usr/bin/env groovy
// vars/YourStepName.groovy

def notifySlack(String buildStatus = 'STARTED') {
    // Build status of null means success.
    buildStatus = buildStatus ?: 'SUCCESS'

    def color

    if (buildStatus == 'STARTED') {
        color = '#D4DADF'
    } else if (buildStatus == 'SUCCESS') {
        color = '#BDFFC3'
    } else if (buildStatus == 'UNSTABLE') {
        color = '#FFFE89'
    } else {
        color = '#FF9FA1'
    }

    def msg = "${buildStatus}: `${env.JOB_NAME}` #${env.BUILD_NUMBER}:\n${env.BUILD_URL}"

    slackSend(teamDomain: "techverito", channel: "#gocd-build-notifications", tokenCredentialId: "32065985-0e36-4265-bdd8-8fc1e942f4f4", color: color, message: msg)
}
/*
def start() {
   slackSend (teamDomain: "techverito", channel: "#gocd-build-notifications", tokenCredentialId: "32065985-0e36-4265-bdd8-8fc1e942f4f4",color: "good", 
            message: "Started ${env.JOB_NAME} #${env.BUILD_NUMBER} by ${currentBuild.getBuildCauses()[0].userId} (<${env.BUILD_URL}|Open>)")
}

def status() {
   slackSend (teamDomain: "techverito", channel: "#gocd-build-notifications", tokenCredentialId: "32065985-0e36-4265-bdd8-8fc1e942f4f4",color: "good", 
            message: "${currentBuild.currentResult} ${env.JOB_NAME} #${env.BUILD_NUMBER} by ${currentBuild.getBuildCauses()[0].userId} (<${env.BUILD_URL}|Open>)")
}



def update() {
   if 
   slackSend (teamDomain: "techverito", channel: "#gocd-build-notifications", tokenCredentialId: "32065985-0e36-4265-bdd8-8fc1e942f4f4",color: "good", 
            message: "Started ${env.JOB_NAME} #${env.BUILD_NUMBER} by ${currentBuild.getBuildCauses()[0].userId} (<${env.BUILD_URL}|Open>)")
}



def notifyBuild(String buildStatus = 'STARTED') {
  // build status of null means successful
  //buildStatus = buildStatus ?: 'SUCCESS'

  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}] by ${currentBuild.getBuildCauses()[0].userId}'"
  def summary = "${subject} (${env.BUILD_URL})"
  def details = """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
    <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""

  // Override default values based on build status
  if (buildStatus == 'STARTED') {
    color = 'YELLOW'
    colorCode = '#FFFF00'
  } else if (buildStatus == 'SUCCESS') {
    color = 'GREEN'
    colorCode = '#00FF00'
  } else {
    color = 'RED'
    colorCode = '#FF0000'
  }
  
  
  slackSend (teamDomain: "techverito", 
            channel: "#gocd-build-notifications",
            tokenCredentialId: "32065985-0e36-4265-bdd8-8fc1e942f4f4", 
            color: colorCode, message: summary)
  
}
*/
