package serveur.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {
    private Connection connection;

    public ProduitDAO() {
        connection = JDBCUtil.getConnection();
    }

    public void ajouterProduit(String nom, String categorie, int quantite, double prix) {
        try {
            String query = "INSERT INTO produits (nom, categorie, quantite, prix) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, nom);
            stmt.setString(2, categorie);
            stmt.setInt(3, quantite);
            stmt.setDouble(4, prix);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerProduit(int id) {
        try {
            String query = "DELETE FROM produits WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> rechercherProduits(String categorie) {
        List<String> produits = new ArrayList<>();
        try {
            String query = "SELECT nom FROM produits WHERE categorie = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, categorie);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                produits.add(rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    public List<String> afficherProduits() {
        List<String> produits = new ArrayList<>();
        try (Connection conn = JDBCUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM produits")) {

            while (rs.next()) {
                produits.add("ID: " + rs.getInt("id") +
                        ", Nom: " + rs.getString("nom") +
                        ", Catégorie: " + rs.getString("categorie") +
                        ", Quantité: " + rs.getInt("quantite") +
                        ", Prix: " + rs.getDouble("prix"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produits;
    }
    public void modifierProduit(int id, String nom, String categorie, int quantite, double prix) {
        String sql = "UPDATE produits SET nom = ?, categorie = ?, quantite = ?, prix = ? WHERE id = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);
            stmt.setString(2, categorie);
            stmt.setInt(3, quantite);
            stmt.setDouble(4, prix);
            stmt.setInt(5, id);

            stmt.executeUpdate();
            System.out.println("Produit mis à jour avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
