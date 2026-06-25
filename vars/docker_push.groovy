def call(String ProjectName, String ImageTag, String DockerHubUser) {

    withCredentials([
        usernamePassword(
            credentialsId: 'dockerHubCred',
            usernameVariable: 'dockerHubUser',
            passwordVariable: 'dockerHubPass'
        )
    ]) {

        sh """
        echo "\$dockerHubPass" | docker login -u "${DockerHubUser}" --password-stdin
        docker push ${DockerHubUser}/${ProjectName}:${ImageTag}
        """
    }
}
