def call(String project, String imageTag, String dockerHubUser) {
    withCredentials([usernamePassword(credentialsId: 'dockerhub_secret', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh """
            echo "${DOCKER_PASS}" | docker login -u "${DOCKER_USER}" --password-stdin
            docker build -t ${dockerHubUser}/${project}:${imageTag} .
            docker push ${dockerHubUser}/${project}:${imageTag}
        """
    }
}
