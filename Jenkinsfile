pipeline
{
  agent any

  stages
  {
    stage("build")
    {
      steps
      {
        withMaven {
         bat "mvn clean install"
        }
      }
    }
  }
}
