package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InterfaceInventaire extends Remote {
    void ajouterProduit(String nom, String categorie, int quantite, double prix) throws RemoteException;
    void supprimerProduit(int id) throws RemoteException;
    List<String> rechercherProduits(String categorie) throws RemoteException;
    List<String> afficherProduits() throws RemoteException;
    void modifierProduit(int id, String nom, String categorie, int quantite, double prix) throws RemoteException;




}
