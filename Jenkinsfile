pipeline
{
  agent any
  parameters{
    choice(name:'VERSION', choices:['1.1.0','1.2.0'], description:'')
    booleanParam(name:'executeTests', defaultValue: true, description:'')
  }
  stages
  {

    stage("build")
    {
      steps
      {
        echo "building the application"
      }
    }
    stage("test")
    {
      when{
        expression{
          params.executeTests
        }
      }
      steps
      {
        echo "testing the application version ${params.VERSION}"
      }
    }
    stage("deploy")
    {
      steps
      {
        echo "deploying the application"
      }
    }
  }
}
