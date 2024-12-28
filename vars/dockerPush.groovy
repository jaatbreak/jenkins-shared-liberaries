def dockerPush(String image, String tag) {
    withCredentials([usernamePassword(credentialsId: 'dockerhub_secret', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh """
            docker login -u '${DOCKER_USERNAME}' -p '${DOCKER_PASSWORD}'
            docker push ${DOCKER_USERNAME}/${image}:${tag}
        """
    }
}
