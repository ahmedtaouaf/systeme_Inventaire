package client;

import serveur.InterfaceInventaire;

import java.rmi.Naming;
import java.util.Scanner;

public class ClientInventaire {
    public static void main(String[] args) {
        try {
            InterfaceInventaire inventaire = (InterfaceInventaire) Naming.lookup("rmi://localhost:1099/inventaire");

            Scanner scanner = new Scanner(System.in);
            int choix;

            do {
                System.out.println("\n--- Menu Gestion d'Inventaire ---");
                System.out.println("1. Ajouter un produit");
                System.out.println("2. Rechercher un produit");
                System.out.println("3. Modifier un produit");
                System.out.println("4. Supprimer un produit");
                System.out.println("5. Quitter");
                System.out.print("Votre choix : ");
                choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        ajouterProduit(inventaire, scanner);
                        break;
                    case 2:
                        rechercherProduit(inventaire, scanner);
                        break;
                    /*case 3:
                        modifierProduit(inventaire, scanner);
                        break;*/
                    case 4:
                        supprimerProduit(inventaire, scanner);
                        break;
                    case 5:
                        System.out.println("Merci d'avoir utilisé l'application !");
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }
            } while (choix != 5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ajouterProduit(InterfaceInventaire inventaire, Scanner scanner) {
        try {
            System.out.print("Nom du produit : ");
            String nom = scanner.nextLine();

            System.out.print("Catégorie : ");
            String categorie = scanner.nextLine();

            System.out.print("Quantité : ");
            int quantite = scanner.nextInt();

            System.out.print("Prix : ");
            double prix = scanner.nextDouble();
            scanner.nextLine();

            inventaire.ajouterProduit(nom, categorie, quantite, prix);
            System.out.println("Produit ajouté avec succès !");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout du produit : " + e.getMessage());
        }
    }

    private static void rechercherProduit(InterfaceInventaire inventaire, Scanner scanner) {
        try {
            System.out.print("Nom ou catégorie à rechercher : ");
            String recherche = scanner.nextLine();

            var produits = inventaire.rechercherProduits(recherche);
            if (produits.isEmpty()) {
                System.out.println("Aucun produit trouvé.");
            } else {
                produits.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de la recherche : " + e.getMessage());
        }
    }

    /*private static void modifierProduit(InterfaceInventaire inventaire, Scanner scanner) {
        try {
            System.out.print("ID du produit à modifier : ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            System.out.print("Nouveau nom du produit : ");
            String nom = scanner.nextLine();

            System.out.print("Nouvelle catégorie : ");
            String categorie = scanner.nextLine();

            System.out.print("Nouvelle quantité : ");
            int quantite = scanner.nextInt();

            System.out.print("Nouveau prix : ");
            double prix = scanner.nextDouble();
            scanner.nextLine(); // Consommer la ligne restante

            inventaire.(id, nom, categorie, quantite, prix);
            System.out.println("Produit modifié avec succès !");
        } catch (Exception e) {
            System.err.println("Erreur lors de la modification du produit : " + e.getMessage());
        }
    }*/

    private static void supprimerProduit(InterfaceInventaire inventaire, Scanner scanner) {
        try {
            System.out.print("ID du produit à supprimer : ");
            int id = scanner.nextInt();
            scanner.nextLine();

            inventaire.supprimerProduit(id);
            System.out.println("Produit supprimé avec succès !");
        } catch (Exception e) {
            System.err.println("Erreur lors de la suppression du produit : " + e.getMessage());
        }
    }
}

