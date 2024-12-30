def call(Integer Hport, Integer Cport, String image) {
    sh """
    docker run -dit -p ${Hport}:${Cport} ${image}
    """
}
