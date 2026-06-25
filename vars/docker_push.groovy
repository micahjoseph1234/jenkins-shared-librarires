def call(String Project, String ImageTag, String dockerhubuser) {

    withCredentials([
        usernamePassword(
            credentialsId: 'dockerHubCred',
            passwordVariable: 'dockerHubPass',
            usernameVariable: 'dockerHubUser'
        )
    ]) {

        sh """
        echo "\$dockerHubPass" | docker login -u "${dockerhubuser}" --password-stdin
        docker push ${dockerhubuser}/${Project}:${ImageTag}
        """
    }
}
