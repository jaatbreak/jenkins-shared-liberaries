def call(String project, String imageTag, String dockerHubUser) {
    withCredentials([usernamePassword(credentialsId: 'dockerhubCred', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubPass')]) {
        sh """
            docker login -u ${dockerHubUser} -p ${dockerHubPass}
            docker push ${dockerHubUser}/${project}:${imageTag}
        """
    }
}
