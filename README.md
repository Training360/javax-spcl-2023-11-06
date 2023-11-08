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

## Kafka indítása

```shell
cd kafka
docker compose up -d
```

Üzenet küldése:

```shell
docker exec -it kafka-kafka-1 kafka-console-producer.sh --bootstrap-server localhost:9092 --topic uppercase-in-0
```

## Career service

```shell
docker run -d -e POSTGRES_DB=career -e POSTGRES_USER=career -e POSTGRES_PASSWORD=career -p 5435:5432  --name career-postgres postgres
```

## Keycloak

```shell
docker run -d -e KEYCLOAK_USER=root -e KEYCLOAK_PASSWORD=root -p 8089:8080 --name keycloak jboss/keycloak
```

Keycloak elérés: `http://localhost:8089/`

* Létre kell hozni egy Realm-et (`Mentoring`)
* Létre kell hozni egy klienst, amihez meg kell adni annak azonosítóját, <br /> és hogy milyen url-en érhető el (`employee-service`)
* Létre kell hozni egy klienst, amihez meg kell adni annak azonosítóját, <br /> és hogy milyen url-en érhető el (`frontend-service`)
* Létre kell hozni a szerepköröket (`employee_admin`)
* Létre kell hozni egy felhasználót (a _Email Verified_ legyen _On_ értéken, hogy be lehessen vele jelentkezni), 
  beállítani a jelszavát (a _Temporary_ értéke legyen _Off_, hogy ne kelljen jelszót módosítani), <br /> valamint hozzáadni a szerepkört (`johndoe`)


Client Scopes/roles/Mappers/realm roles/Add to ID token

http://localhost:8089/auth/realms/Mentoring/.well-known/openid-configuration