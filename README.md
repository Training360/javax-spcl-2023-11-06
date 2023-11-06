# Microservice tervezési minták Spring Clouddal megvalósítva Kubernetes környezetben 

## Architektúra

![Architektúra](architektura-abra.png)

## Employees megnyitása

```shell
git clone https://github.com/Training360/javax-spcl-2023-11-06
```

* Projekt átmásolása saját könyvtárba, megnyitás IDEA-val

```shell
docker run -d -e POSTGRES_DB=employees -e POSTGRES_USER=employees -e POSTGRES_PASSWORD=employees -p 5432:5432  --name employees-postgres postgres
```

Swagger: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)