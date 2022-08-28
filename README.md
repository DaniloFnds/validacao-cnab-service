### Software Installation Prerequisites
  * Install Docker
  * Install Postgres
    * Docker: docker run --name postgres -e POSTGRES_PASSWORD=pass -d postgres
    * Create database named: staging_service
    * Create schema named: staging_service
  * Install RabbitMQ
    * Docker: docker run -d --hostname my-rabbit -e RABBITMQ_DEFAULT_USER=pass -e RABBITMQ_DEFAULT_PASS=pass --name rabbit -p 15672:15672 -p 5672:5672 -p 25676:25676 rabbitmq:3-management
  * Install Gradle

### Environment Configuration

  * Clone the respository [Infra-Config](https://github.com/DaniloFnds/infra-config)
    * Copy all file to root directory .gradle 
  * Clone the repository [Commons-lib](https://github.com/DaniloFnds/commons-lib)
    * Build the project to generate commons libs to other projects
  * Clone the repository [Schema-Events](https://github.com/DaniloFnds/schema-events)
    * Build the project to generate Schemes
  * Thre is an environment file that you need to put on to start up with spring boot(Intellj is needed)
  

