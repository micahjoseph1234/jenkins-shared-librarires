def call(String Project, String ImageTag, String dockerhubuser) {

    withCredentials([
        usernamePassword(
            credentialsId: 'dockerHubCred',
            passwordVariable: 'dockerHubPass',
            usernameVariable: 'dockerHubUser'
        )
    ]) {

        sh '''
        echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
        '''
    }

    sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
