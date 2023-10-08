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