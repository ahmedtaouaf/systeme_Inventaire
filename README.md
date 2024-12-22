# Système de Gestion d'Inventaire avec Accès Distant Via (RMI)

Ce projet est une application client-serveur pour la gestion d'un inventaire, développée en Java en utilisant **RMI** (Remote Method Invocation) pour la communication à distance et **JDBC** pour les interactions avec une base de données MySQL.

---

## Fonctionnalités principales
- **Ajout de produits** : Ajouter un produit avec ses détails (nom, catégorie, quantité, prix).
- **Recherche de produits** : Rechercher des produits par nom ou catégorie.
- **Modification de produits** : Mettre à jour les informations d'un produit existant.
- **Suppression de produits** : Supprimer un produit de l'inventaire.
- **Affichage de l'inventaire** : Visualiser tous les produits enregistrés.

---

## Prérequis
Avant d'exécuter le projet, assurez-vous d'avoir :
- **Java JDK 8** ou une version ultérieure.
- **MySQL Server** pour gérer la base de données.
- Un IDE (IntelliJ IDEA, Eclipse, etc.) ou un terminal avec les outils nécessaires pour compiler et exécuter des programmes Java.
- **RMI Registry** (intégré avec Java).

---

## Étapes d'installation et d'exécution

### 1. Installer MySQL
- Téléchargez et installez MySQL depuis [le site officiel de MySQL](https://www.mysql.com/downloads/).
- Une fois installé, ouvrez le terminal MySQL et créez une base de données pour le projet en exécutant la commande suivante :
  ```sql
  CREATE DATABASE inventaire;
  ```

### 2. Configurer la base de données
- Créez une table pour stocker les informations des produits dans la base de données `inventaire` :
  ```sql
  CREATE TABLE produits (
      id INT AUTO_INCREMENT PRIMARY KEY,
      nom VARCHAR(255) NOT NULL,
      categorie VARCHAR(255) NOT NULL,
      quantite INT NOT NULL,
      prix DECIMAL(10, 2) NOT NULL
  );
  ```
- Cette table permettra de stocker les informations nécessaires pour la gestion de l'inventaire.

### 3. Télécharger et configurer le projet
- Clonez ou téléchargez le code source du projet depuis le dépôt GitHub :
  ```bash
  git clone https://github.com/votre-repo/inventaire.git
  ```
- Importez le projet dans votre IDE préféré.

### 4. Configurer le fichier de connexion JDBC
- Dans le fichier `JDBCUtil.java`, modifiez les paramètres de connexion si nécessaire :
  ```java
  private static final String URL = "jdbc:mysql://localhost:3306/inventaire";
  private static final String USER = "root";
  private static final String PASSWORD = "";
  ```

### 5. Compilation du code
- Naviguez dans le répertoire principal du projet et exécutez la commande suivante dans votre terminal pour compiler le code :
  ```bash
  javac -d out src/client/ClientInventaire.java src/serveur/ServeurInventaire.java \
  src/serveur/InterfaceInventaire.java src/serveur/DAO/ProduitDAO.java \
  src/serveur/DAO/JDBCUtil.java
  ```
- L'option `-d out` crée un dossier `out` pour stocker les fichiers `.class` compilés.

### 6. Démarrage du Registre RMI
- Avant de lancer le serveur, démarrez le registre RMI avec la commande suivante dans un terminal :
  ```bash
  start rmiregistry
  ```
- Exécutez ensuite la classe `ServeurInventaire` pour démarrer le serveur RMI avec la commande suivante :
  ```bash
  java -cp .;../lib/mysql-connector-j-8.0.31.jar serveur.ServeurInventaire
  ```
- Le serveur attendra les connexions des clients sur `rmi://localhost:1099/inventaire`.

### 7. Lancement du client
- Exécutez la classe `ClientInventaire` pour démarrer l'application cliente et interagir avec le serveur :
  ```bash
  java client.ClientInventaire
  ```
- Vous pourrez interagir avec le serveur à travers un menu de gestion des produits.
