# Microservice tervezési minták Spring Clouddal megvalósítva Kubernetes környezetben 

## Architektúra

![Architektúra](architektura-abra.png)

## Employees megnyitása, futtatása

```shell
git clone https://github.com/Training360/javax-spcl-2023-11-06
```

* Projekt átmásolása saját könyvtárba, megnyitás IDEA-val

```shell
docker run -d -e POSTGRES_DB=employees -e POSTGRES_USER=employees -e POSTGRES_PASSWORD=employees -p 5432:5432  --name employees-postgres postgres
```

Swagger: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

## Course service megnyitása, futtatása

```shell
docker run -d -e POSTGRES_DB=course -e POSTGRES_USER=course -e POSTGRES_PASSWORD=course -p 5434:5432  --name course-postgres postgres
```

## CQRS

```shell
docker run -d -e "discovery.type=single-node" -e xpack.security.enabled=false -p 9200:9200 -p 9300:9300 --name elasticsearch elasticsearch:8.6.1
```
