def call(String project, String imageTag, String dockerHubUser) {
    withCredentials([usernamePassword(credentialsId: 'dockerhub_secret', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubPass')]) {
        sh """
            docker login -u ${dockerHubUser} --password-stdin ${dockerHubPass}
            docker push ${dockerHubUser}/${project}:${imageTag}
        """
    }
}
