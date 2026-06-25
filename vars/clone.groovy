def call(String url, String branch)
{
  echo "This is cloning code"
  git url: "${url}", branch:"${branch}"
  echo "Code cloning successful"
                
}
