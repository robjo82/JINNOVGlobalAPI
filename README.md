# JINNOV Global Management Service

## Contexte et introduction

### Qu'est-ce que JINNOV ?

JINNOV est la Junior-Entreprise de l'INSA Hauts-de-France, une école d'ingénieur située à Valenciennes. Nous nous spécialisons dans plusieurs domaines, notamment la protection des données, la digitalisation, l'énergétique du bâtiement et la conception mécanique. Notre zone d'action se concentre principalement sur la région du Grand Hainaut. 

### Composition du service

- **JINNOV Global API** : L'API responsable de la gestion des données.
- **JINNOV Management Platform** : La plateforme front-end qui permet aux membres d'accéder aux informations.
- **JINNOV Global Management Service** : L'ensemble intégré des deux.

### La problématique

Les Junior-Entreprises sont des associations à but non lucratif qui opèrent comme des entreprises. Cela signifie qu'elles nécessitent des outils de gestion d'entreprise sans disposer des ressources financières conséquentes. De plus, les membres ont une durée d'engagement limitée à trois ans, ce qui complique la continuité des projets.

## Objectif du projet

JINNOV Global Management Service vise à centraliser la gestion de toutes les activités de JINNOV. Initialement, l'accent est mis sur la gestion des missions, et il est prévu de s'étendre à d'autres domaines tels que le recrutement, la formation, la stratégie, la gestion des ressources humaines, etc.

## Fonctionnalités 

### JINNOV Global API

- **Opérations CRUD** : La première version de l'API se concentrera sur des opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) basiques sur une base de données Firebase.
- **Automatisation et intégration** : L'API aura la capacité de s'intégrer avec des services externes comme Slack, Monday, Google Workspace, etc. Ceci permettra des automatisations plus avancées, y compris la génération automatique de documents commerciaux.
- **Gestion des droits** : Un système innovant qui associe à chaque champ de chaque table un niveau de criticité. Les utilisateurs obtiennent des autorisations en fonction de leur rôle et peuvent avoir des accès temporaires spécifiques.

## Conception

### Endpoints

/api/v1/...

**Initialize Firebase** : _provisoire, doit être supprimé en production_

- `POST /initialize` : Créer une nouvelle base de données Firebase (toutes les tables et tous les champs sont créés au moins une fois) `(v1.0-0)`
- `GET /all` : Récupérer toutes les données de la base de données Firebase `(v1.0-1)`

**Studies**

- `POST /studies` : Créer une étude `(v1.0-7)`
- `GET /studies?access=READ` : Récupérer toutes les études auxquelles l'utilisateur a accès en lecture `(v1.0-8)`
- `GET /studies?access=WRITE` : Récupérer toutes les études auxquelles l'utilisateur a accès en écriture `(v1.0-8)`
- `GET /studies/{id}` : Récupérer une étude `(v1.0-9)`
- `PUT /studies/{id}` : Mettre à jour une étude `(v1.0-10)`
- `DELETE /studies/{id}` : Supprimer une étude `(v1.0-11)`
- `GET /studies/{id}/interactions/fetch` : Récupérer toutes les interactions d'une étude `(v1.1-1)`

**Documents**

- `GET /studies/{id}/documents` : Récupérer tous les documents d'une étude `(v1.5-7)`
- `GET /studies/{id}/documents/{documentId}` : Récupérer un document d'une étude `(v1.5-8)`
- `POST /studies/{id}/documents` : Créer un document dans une étude `(v1.5-9)`
- `PUT /studies/{id}/documents/{documentId}` : Mettre à jour un document d'une étude `(v1.5-10)`
- `DELETE /studies/{id}/documents/{documentId}` : Supprimer un document d'une étude `(v1.5-11)`

**Meetings**

- `GET /studies/{id}/meetings` : Récupérer toutes les réunions d'une étude `(v1.5-12)`
- `GET /studies/{id}/meetings/fetch` : Récupérer toutes les réunions d'une étude `(v1.6-1)`
- `GET /studies/{id}/meetings/{meetingId}` : Récupérer une réunion d'une étude `(v1.5-13)`
- `POST /studies/{id}/meetings` : Créer une réunion dans une étude `(v1.5-14)`
- `PUT /studies/{id}/meetings/{meetingId}` : Mettre à jour une réunion d'une étude `(v1.5-15)`
- `DELETE /studies/{id}/meetings/{meetingId}` : Supprimer une réunion d'une étude `(v1.5-16)`

**Attendees**

- `POST /studies/{id}/meetings/{meetingId}/attendees` : Ajouter un participant à une réunion `(v1.5-17)`
- `DELETE /studies/{id}/meetings/{meetingId}/attendees/{attendeeId}` : Supprimer un participant d'une réunion `(v1.5-18)`
- `POST /studies/{id}/meetings/{meetingId}/attendees/{attendeeId}/presence` : Marquer un participant comme présent à une réunion `(v1.5-19)`

**Phases**

- `GET /studies/{id}/phases` : Récupérer toutes les phases d'une étude `(v1.5-1)`
- `GET /studies/{id}/phases/{phaseId}` : Récupérer une phase d'une étude `(v1.5-2)`
- `POST /studies/{id}/phases` : Ajouter une phase à une étude `(v1.5-3)`
- `PUT /studies/{id}/phases/{phaseId}` : Mettre à jour une phase d'une étude `(v1.5-4)`
- `DELETE /studies/{id}/phases/{phaseId}` : Supprimer une phase d'une étude `(v1.5-5)`
- `GET /studies/{id}/phases/{phaseId}/subphases` : Récupérer toutes les sous-phases d'une phase `(v1.5-6)`

**Users**

- `GET /users` : Récupérer tous les utilisateurs `(v1.0-3)`
- `GET /users/{id}` : Récupérer un utilisateur `(v1.0-4)`
- `POST /users` : Créer un utilisateur `(v1.0-2)`
- `PUT /users/{id}` : Mettre à jour un utilisateur `(v1.0-5)`
- `POST /users/{id}/deactivate` : Désactiver un utilisateur `(v1.7-11)`
- `POST /users/{id}/activate` : Activer un utilisateur `(v1.7-12)`
- `DELETE /users/{id}` : Supprimer un utilisateur `(v1.0-6)`
- `GET /users/{id}/roles` : Récupérer tous les rôles d'un utilisateur `(v1.7-8)`
- `POST /users/{id}/roles/{roleId}` : Ajouter un rôle à un utilisateur `(v1.7-9)`
- `DELETE /users/{id}/roles/{roleId}` : Supprimer un rôle d'un utilisateur `(v1.7-10)`

**Autorisations temporaires**

- `GET /users/{id}/temporary-permissions` : Récupérer toutes les autorisations temporaires d'un utilisateur `(v1.0-12)`
- `POST /users/{id}/temporary-permissions` : Attribuer une autorisation temporaire pour un utilisateur `(v1.0-13)`
- `PUT /users/{id}/temporary-permissions/{permissionId}/extend` : Prolonger une autorisation temporaire pour un utilisateur `(v1.0-14)`
- `DELETE /users/{id}/temporary-permissions/{permissionId}` : Révoquer une autorisation temporaire pour un utilisateur `(v1.0-15)`

**Rôles**

- `GET /roles` : Récupérer tous les rôles `(v1.7-1)`
- `POST /roles` : Créer un rôle `(v1.7-2)`
- `PUT /roles/{id}` : Mettre à jour un rôle `(v1.7-3)`
- `DELETE /roles/{id}` : Supprimer un rôle `(v1.7-4)`

**Autorisations**

- `GET roles/{id}/permissions` : Récupérer toutes les permissions d'un rôle `(v1.7-5)`
- `POST roles/{id}/permissions` : Ajouter une permission à un rôle `(v1.7-6)`
- `DELETE roles/{id}/permissions/{permissionId}` : Supprimer une permission d'un rôle `(v1.7-7)`

**Contacts**

- `GET /contacts?access=READ` : Récupérer tous les contacts auxquels l'utilisateur a accès en lecture `(v1.0-17)`
- `GET /contacts?access=WRITE` : Récupérer tous les contacts auxquels l'utilisateur a accès en écriture `(v1.0-17)`
- `GET /contacts/{id}` : Récupérer un contact `(v1.0-18)`
- `POST /contacts` : Créer un contact `(v1.0-16)`
- `PUT /contacts/{id}` : Mettre à jour un contact `(v1.0-19)`
- `DELETE /contacts/{id}` : Supprimer un contact `(v1.0-20)`
- `POST /contacts/{id}/newsletters` : Inscrire le contact à la newsletter `(v1.4-1)`
- `DELETE /contacts/{id}/newsletters` : Désinscrire le contact de la newsletter `(v1.4-2)`

**Entreprises**

- `GET /companies` : Récupérer toutes les entreprises `(v1.0-22)`
- `GET /companies/{id}` : Récupérer une entreprise `(v1.0-23)`
- `POST /companies` : Créer une entreprise `(v1.0-21)`
- `PUT /companies/{id}` : Mettre à jour une entreprise `(v1.0-24)`
- `DELETE /companies/{id}` : Supprimer une entreprise `(v1.0-25)`
- `GET /companies/{id}/contacts` : Récupérer tous les contacts d'une entreprise `(v1.8-2)`
- `POST /companies/{id}/contacts` : Ajouter un contact à une entreprise `(v1.8-1)`
- `DELETE /companies/{id}/contacts/{contactId}` : Supprimer un contact d'une entreprise `(v1.8-3)`
- `GET /companies/{id}/performances/last` : Récupérer les performances de l'entreprise pour la dernière saisie `(v1.8-4)`
- `GET /companies/{id}/performances/history` : Récupérer l'historique des performances de l'entreprise `(v1.8-5)`
- `POST /companies/{id}/performances` : Ajouter une saisie de performance à l'entreprise `(v1.8-6)`

**Secteur d'activité**

- `GET /sectors` : Récupérer tous les secteurs d'activité `(v1.8-7)`
- `POST /sectors` : Créer un secteur d'activité `(v1.8-8)`
- `DELETE /sectors/{id}` : Supprimer un secteur d'activité `(v1.8-9)`

**Prestations**

- `GET /services` : Récupérer toutes les prestations `(v1.2-2)`
- `GET /services/{id}` : Récupérer une prestation `(v1.2-3)`
- `POST /services` : Créer une prestation `(v1.2-1)`
- `PUT /services/{id}` : Mettre à jour une prestation `(v1.2-4)`
- `DELETE /services/{id}` : Supprimer une prestation `(v1.2-5)`
- `GET /services/{id}/commercial-referents`: Récupérer tous les référents commerciaux d'une prestation `(v1.2-6)`
- `POST /services/{id}/commercial-referents`: Ajouter un référent commercial à une prestation `(v1.2-7)`
- `DELETE /services/{id}/commercial-referents/{userId}`: Supprimer un référent commercial d'une prestation `(v1.2-8)`
- `GET /services/{id}/technical-referents`: Récupérer tous les référents techniques d'une prestation `(v1.2-9)`
- `POST /services/{id}/technical-referents`: Ajouter un référent technique à une prestation `(v1.2-10)`
- `DELETE /services/{id}/technical-referents/{userId}`: Supprimer un référent technique d'une prestation `(v1.2-11)`

**Resources**

- `GET /resources` : Récupérer toutes les ressources (en prévision des audits) `(v1.3-1)`


### Comment contribuer ?

Le projet est majoritairement développé par des étudiants ayant des niveaux de compétence variés en programmation. Le projet est conçu pour être très documenté, permettant ainsi à un novice en programmation de contribuer efficacement.

Toutes les contributions sont les bienvenues, qu'il s'agisse de commentaires sur le code, de signalement de bugs ou de propositions de nouvelles fonctionnalités.

### Tests et qualité du code

Aucun test unitaire n'est écrit en raison de la nature du projet et des contributeurs. Cependant, Sonar est utilisé pour maintenir la qualité du code.

### Déploiement

Durant la phase de développement, une version sera déployée via Heroku à l'adresse [ici](https://jinnov-global-api-0b536d4bf6fb.herokuapp.com/).

## Informations supplémentaires

- Le développement est majoritairement effectué par des membres actifs qui sont des débutants ou des personnes ayant un niveau d'expérience intermédiaire en programmation.
- Le projet est conçu pour être fortement documenté, permettant ainsi à une personne débutante en programmation de contribuer efficacement.