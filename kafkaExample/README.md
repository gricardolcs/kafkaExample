# Docker Compose + Kafka + Spring Boot

## Environment

Ejecutar desde el root del proyecti:
- `docker-compose up` to initialize Kafka and Zookeeper
- `mvn package` to build the applications


## Levantar Spring-boot applicaciones

- Inicializar `producer`
````bash
$ cd producer
$ mvn spring-boot:run
````
**Note:** EL `producer` escucha y acepta peticiones en `http://localhost:8080/email`


- Inicializar  `consumer`
````bash
$ cd consumer
$ mvn spring-boot:run
````
**Note:** EL `consumer`  no tiene endpoint, se conecta a  Kafka y escucha los  eventos.


## Testing 

Con`consumer` y `producer` la appliccion esta corriendo, testing  con Kafka:
````bash
$ curl -d "{'fecha': '10/1/2022', 'idEmail': '100', 'email': 'Foo@Bar.com', 'value': 'Testing appliacion'}" \
-H "Content-Type: application/json" \
-X POST http://127.0.0.1:8080/email
````

Si todo trabaja bien aparecera asi:
````
2021-07-07 06:23:26.433  INFO 2336 --- [ad | producer-1] b.c.d.producer.config.KafkaConfig        : ACK from ProducerListener message: {'fecha': '10/1/2022', 'idEmail': '100', 'email': 'Foo@Bar.com', 'value': 'Testing appliacion'} offset:  0
````
algo asi `consumer` application's console:
````
2021-07-07 06:23:26.490  INFO 3996 --- [ntainer#0-0-C-1] b.c.d.consumer.kafka.KafkaConsumer       : Order: {'fecha': '10/1/2022', 'idEmail': '100', 'email': 'Foo@Bar.com', 'value': 'Testing appliacion'}
````


## Cleaning Up
 
<ol>
<li>Stop the containers using the following command:</li>
  <code>docker-compose down</code>
<li>Delete all containers using the following command:</li>
  <code>docker rm -f $(docker ps -a -q)</code>
</ol> 
