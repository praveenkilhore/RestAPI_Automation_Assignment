pipeline
{
  agent any

  stages
  {
    stage("build")
    {
      steps
      {
        sh 'mvn -Dmaven.test.failure.ignore=true install'
      }
    }
  }
}
