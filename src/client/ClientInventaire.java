package client;

import serveur.InterfaceInventaire;

import java.rmi.Naming;
import java.util.Scanner;

public class ClientInventaire {
    public static void main(String[] args) {
        try {
            // Connexion au serveur RMI
            InterfaceInventaire inventaire = (InterfaceInventaire) Naming.lookup("rmi://localhost:1099/inventaire");

            Scanner scanner = new Scanner(System.in);
            int choix;

            do {
                System.out.println("\n--- Menu Gestion d'Inventaire ---");
                System.out.println("1. Ajouter un produit");
                System.out.println("2. Rechercher un produit");
                System.out.println("3. Modifier un produit");
                System.out.println("4. Supprimer un produit");
                System.out.println("5. Afficher tous les produits");
                System.out.println("6. Quitter");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine(); // Consommer la ligne restante

                switch (choix) {
                    case 1:
                        ajouterProduit(inventaire, scanner);
                        break;
                    case 2:
                        rechercherProduit(inventaire, scanner);
                        break;
                    case 3:
                        modifierProduit(inventaire, scanner);
                        break;
                    case 4:
                        supprimerProduit(inventaire, scanner);
                        break;
                    case 5:
                        afficherProduits(inventaire);
                        break;
                    case 6:
                        System.out.println("Merci d'avoir utilise l'application !");
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez reessayer.");
                }
            } while (choix != 6);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ajouterProduit(InterfaceInventaire inventaire, Scanner scanner) {
        try {
            System.out.print("Nom du produit : ");
            String nom = scanner.nextLine();

            System.out.print("Categorie : ");
            String categorie = scanner.nextLine();

            System.out.print("Quantite : ");
            int quantite = scanner.nextInt();

            System.out.print("Prix : ");
            double prix = scanner.nextDouble();
            scanner.nextLine(); // Consommer la ligne restante

            inventaire.ajouterProduit(nom, categorie, quantite, prix);
            System.out.println("Produit ajoute avec succes !");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout du produit : " + e.getMessage());
        }
    }

    private static void rechercherProduit(InterfaceInventaire inventaire, Scanner scanner) {
        try {
            System.out.print("Nom ou categorie a rechercher : ");
            String recherche = scanner.nextLine();

            var produits = inventaire.rechercherProduits(recherche);
            if (produits.isEmpty()) {
                System.out.println("Aucun produit trouve.");
            } else {
                produits.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
        }
    }

    private static void modifierProduit(InterfaceInventaire inventaire, Scanner scanner) {
        try {
            System.out.print("ID du produit a modifier : ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            System.out.print("Nouveau nom du produit : ");
            String nom = scanner.nextLine();

            System.out.print("Nouvelle categorie : ");
            String categorie = scanner.nextLine();

            System.out.print("Nouvelle quantite : ");
            int quantite = scanner.nextInt();

            System.out.print("Nouveau prix : ");
            double prix = scanner.nextDouble();
            scanner.nextLine(); // Consommer la ligne restante

            inventaire.modifierProduit(id, nom, categorie, quantite, prix);
            System.out.println("Produit modifie avec succes !");
        } catch (Exception e) {
            System.err.println("Erreur lors de la modification du produit : " + e.getMessage());
        }
    }

    private static void supprimerProduit(InterfaceInventaire inventaire, Scanner scanner) {
        try {
            System.out.print("ID du produit a supprimer : ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            inventaire.supprimerProduit(id);
            System.out.println("Produit supprime avec succes !");
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression du produit : " + e.getMessage());
        }
    }

    private static void afficherProduits(InterfaceInventaire inventaire) {
        try {
            var produits = inventaire.afficherProduits();
            if (produits.isEmpty()) {
                System.out.println("Aucun produit dans l'inventaire.");
            } else {
                System.out.println("\n--- Liste des Produits ---");
                produits.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'affichage des produits : " + e.getMessage());
        }
    }
}
