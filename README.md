# Microservices ( Spring Boot / Cloud )

![Architecture diagram of all services](/ArchDiagram.png)

## Functional requirements and technologies used

|Requirement| Technologies|
|-----------|-------------|
|Centralized Config | K8 Config Maps|
|Naming and discovery | K8 Services |
| Metrics | Prometheus and Dynatrace|
| Tracing | Micrometer and ZipKin|
| Logging | Centralized logging , Logback, ELK - Elastic search , Logstash and Kibana |
| Messaging| RabbitMQ|
| Database | H2|
| API Gateway | Spring API gateway|
