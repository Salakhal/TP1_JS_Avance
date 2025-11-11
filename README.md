# TP 1 : JDBC

 ## Activité 1 : Suivi des Scripts des Développeurs
## Objectifs
- Maîtriser la connexion JDBC à MySQL
- Manipuler une table SQL depuis Java
- Utiliser `Statement` et `PreparedStatement`
- Réaliser des requêtes de sélection et d’agrégation (`SUM`, `MAX`, `GROUP BY`, `ORDER BY`)

## Contexte
Chaque développeur réalise quotidiennement un certain nombre de scripts.  
L’objectif de ce TP est d’automatiser le suivi de cette production en stockant les informations dans une base MySQL, puis en extrayant diverses statistiques grâce à un programme Java.

---
##  Exemple d’exécution (image)
 
Voici un exemple de l'exécution du programme (screenshot) :

<img width="669" height="377" alt="image" src="https://github.com/user-attachments/assets/87811158-0313-4c41-845f-35b53ccc92ce" />


## Activité 2 : Gestion des Machines et Employés (Architecture en Couches)

##  Objectifs
- Comprendre l’architecture en couches (**DAO ↔ Service ↔ Présentation**)
- Implémenter un utilitaire de connexion JDBC **thread-safe (Singleton)**
- Concevoir et manipuler des entités Java (`Employe`, `Machine`) avec relation objet
- Implémenter une interface **générique DAO (CRUD)**
- Utiliser `PreparedStatement` et `try-with-resources` pour la sécurité
- Encapsuler la logique métier dans les classes Service
- Tester le tout via des programmes `main()` de démonstration

---
##  Exemple d’exécution (image)
 
Voici un exemple de l'exécution du programme (screenshot) :

<img width="637" height="208" alt="image" src="https://github.com/user-attachments/assets/de717685-46ee-4a56-9f44-a85ff7af0887" />


