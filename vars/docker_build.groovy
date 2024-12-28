def call(String image, String tag){
  docker build -t "${image}":"${tag}"
}
