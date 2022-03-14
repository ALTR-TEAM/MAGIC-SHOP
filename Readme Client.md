                                                                    ------ Création de la partie Client - MAGIC-SHOP -------- By Ariih/Didier dans la Branch Ariih

------ Récupération du Projet MAGIC-SHOP ------

Récupération du Templates + Admin de la branch Master , sur GitBash via un Git clone + code du Repository . 

Ajout du Folder "MAGIC-SHOP" sur STS ( SpringBoot FrameWork) .

Création d'une nouvelle BD sur PHPMyAdmin "magic-shop" .
  
(Modification de l'en-tête de l'index.html en ajoutant le Thymeleaf : xmlns:th="http://www.thymeleaf.org" ) 





------ Création des folders ( controller , dao , model , Repository ) pour la partie "Client" ------


1/ Création de la classe " ClientController.java " dans le package "controller" (Voir Code).

======= L'objectif du controller est d'appliquer des méthodes et les méthodes des fonctions déclarer dans la classe "ClientsImp.java".====== 

Ajout de l'annotation "@Controller" au dessus du constructeur . // Equiavalent d'une Servlet 
Ajout de l'annotation "@Autowired" en dessous du constructeur et au dessus de la déclaraction du variable global "ClientsImp cltimp".

Création d'un RequestMapping ==> @RequestMapping ("/Client") // Pour indiquer la route vers laquelle notre page sera rediriger

Création d'un public String Client sous le @RequestMapping ==>    @RequestMapping ("/Client")
                                                                   public String Client()

A l'intérieur du () du public String Client , nous allons mettre nos attribut avec un =@RequestParam" pour récuperer les valeurs des fonctions:

Exemple : ( @RequestParam(name="nom",required=false) String nom)

Nous allons également mettre un "Model mod" et un "HttpSession session" :

Model mod : C’est un objet de type "Model" dans le paramètre de la fonction qui return la page.html ou on va afficher la valeur récupérer par la @RequestParam ().
HttpSession session : Les sessions HTTP sont principalement utilisées pour gérer l'état conversationnel avec les utilisateurs de vos applications Web entre les requêtes HTTP .

======= L'objectif ici est de faire la partie de l'inscription d'un client=======

Créer un bouton qui nous renvoie le modal d'inscription .
Instancier la classe "Clients" .
Setter les valeurs des champs du formulaire .
Utiliser la fonction Add() de la classe "ClientsImp".
Setter une session user + son nom .
Faire le Add() avec un mod.addAttribute .
Faire un mod.addAttribute pour le btn .
Return et redirigée ce controller vers la page "index.html".

(Voir Code)

======= L'objectif ici est de faire la partie de la connexion d'un client======= (Voir Code)

Créer un bouton qui nous renvoie le modal de Connexion . 
Faire un mod.addAttribute pour le btn , l'email et le mdp. 


======= L'objectif ici est de faire la partie de l'Authentification d'un client======= (Voir Code)

Dans cette partie , nous allons vérifier si l'email et/ou le mdp est connu de la base de données .

Si l'email , n'est pas connu de la BD renvoyer un message d'erreur .
Si le mail est connu de la BD , mais que le mdp n'est pas associé avec le mail existant saisie , renvoyer un message d'erreur " Le mdp pour le mail xxxxx@xxx.xxx est invalide.

Puis , nous allons redirigé ses message d'erreur sur la page index , aprés le click sur le boutton "Se connecter" 


2/ Création de la classe " ClientsImp.java " dans le package "dao" (Voir Code).

Ajout des Fonctions du CRUD : 

- Fonction d'Ajout d'un Client
- Fonction d'Affichage d'un Client
- Fonction de Suppresion via l'ID d'un Client
- Fonction de Modification d'un Client
- Fonction d'Authentification d'un Client

3/ Création de la classe " Clients.java " dans le package "model" (Voir Code).

Ajout de l'annotation "@Entity" au dessus de "public class Clients" afin de pouvoir générer une table "Clients" sur PHPMyAdmin.

Ajout des Attributs dans le constructeur en private :

private int id avec l'annotation "@Id" et "@GeneratedValue(strategy = GenerationType.IDENTITY)" au dessus , afin de générer une clé primaire "PrimaryKey" et une auto-incrémentation pour l'Id .
private String email avec l'annotation "@Column" (import de type javax.persistence) au dessus , afin que la colonne "email" sois "Unique" , car il ne peux avoir qu'un email pour un client .
Générer les Getters & Setters .

3/ Création de la classe interface " ClientsInterface.java " dans le package "Repository" (Voir Code).

Nous allons ici , faire une extension du CRUDRepository : CrudRepository <Clients, Integer>

La seule fonction utilisé dans l'interface est la fonction d'Authentification par son Mail :

Clients findByEmail(String email)

Cette fonction remplace le select * from Client where email quand peux trouver dans MySQL.

 


    


   




