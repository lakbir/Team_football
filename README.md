# Team football

## Pré-requis

  - Java 8 ou +
  - Maven
  - Git

## Les technologies utilisées

  - Java
  - Spring Boot
  - JPA / Hibernate / Spring Data
  - H2 database
  - Lombok
  - Spring Doc
  
## Installation du projet

- Pour récupérer le projet du git il suffit d'exécuter la commande `git clone https://github.com/lakbir/Team_football.git` dans votre workspace locale.

## Structure du projet
![Structure](img/project.PNG)

## Démmarage du projet

Après la récupération du projet et pour le démarrer, il suffit de se positionner dans le racine du projet, et dans l'invite de commandes exécuter les commandes maven suivantes dans l'ordre : 
  - `mvn clean`
  - `mvn install`
  - `mvn spring-boot:run`
le projet est démmaré dans le port 8081

## DB

Après le démmarage du projet, vous-pouvez accéder à la base de données utilisée via [ce lien](http://localhost:8081/h2-console/)
![Connexion database](img/database_connexion.JPG)

Pour se connecter à la base de données : 
 - Driver Class:	`org.h2.Driver`
 - JDBC URL: `jdbc:h2:mem:football_team`
 - User Name: `sa`
 - Password: ``
![database](img/database_H2.JPG)

## Documentation API

Pour accéder à l'architucture et la structure d'API ils suffit de cliquer sur [ce lien](http://localhost:8081/v3/api-docs)
![database](img/database_H2.JPG)

## Documentation & Schémas des méthodes REST

Pour accéder à la documentation et les schémas des méthodes REST via [ce lien](http://localhost:8081/swagger-ui/index.html)
![swagger](img/swagger.PNG)

## Test API

