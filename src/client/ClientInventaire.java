package client;

import serveur.InterfaceInventaire;

import java.rmi.Naming;

public class ClientInventaire {
    public static void main(String[] args) {
        try {
            InterfaceInventaire serveur = (InterfaceInventaire) Naming.lookup("rmi://localhost:1099/inventaire");
            serveur.ajouterProduit("Produit1", "Catégorie1", 10, 99.99);
            System.out.println("Produit ajouté avec succès.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
