package serveur;

import serveur.DAO.ProduitDAO;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServeurInventaire extends UnicastRemoteObject implements InterfaceInventaire {
    private ProduitDAO produitDAO;

    protected ServeurInventaire() throws RemoteException {
        produitDAO = new ProduitDAO();
    }

    public void ajouterProduit(String nom, String categorie, int quantite, double prix) throws RemoteException {
        produitDAO.ajouterProduit(nom, categorie, quantite, prix);
    }

    public void supprimerProduit(int id) throws RemoteException {
        produitDAO.supprimerProduit(id);
    }

    public List<String> rechercherProduits(String categorie) throws RemoteException {
        return produitDAO.rechercherProduits(categorie);
    }

    public static void main(String[] args) {
        try {
            Naming.rebind("rmi://localhost:1099/inventaire", new ServeurInventaire());
            System.out.println("Serveur RMI démarré...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}