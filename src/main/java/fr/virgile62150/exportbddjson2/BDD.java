package fr.virgile62150.exportbddjson2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BDD {
    Connection conn = null;

    public BDD() {

    }

    public ArrayList<Commentaire> getCommentaires() {
        ArrayList<Commentaire> comms = new ArrayList<>();
        try {
            // Établissement de la connexion
            conn = DriverManager.getConnection("jdbc:mysql://192.168.1.5:3306/offroad_limited", "javaUser", "Offroad");
            // Création d'une instance de Statement
            Statement stmt = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            // Exécution d'une requête SQL
            ResultSet rs = stmt.executeQuery("SELECT * FROM commentaire LIMIT 500");
            // Boucle sur les résultats de la requête
            while (rs.next()) {
                // faut aussi récup les hashtag mappés sur le comm
                List<Hashtag> liste_hashtag = new ArrayList<>();

                ResultSet rsHT = stmt2.executeQuery("SELECT hashtag.hashtag FROM hashtag JOIN hashtagcomm ON hashtag.idHashtag = hashtagcomm.idHashtag WHERE hashtagcomm.idCommentaire = " + rs.getInt("idCommentaire"));
                while (rsHT.next()) {
                    Hashtag ht = new Hashtag(rsHT.getString("hashtag"));
                    liste_hashtag.add(ht);
                }

                // Génération commentaire
                Commentaire c = new Commentaire(
                        rs.getString("texteCommentaire"),
                        rs.getInt("pointGeo"),
                        rs.getInt("dossard"),
                        rs.getString("dateHeureCommentaire"),
                        rs.getString("auteur"),
                        rs.getInt("course"),
                        liste_hashtag
                );

                comms.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion : " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            // Fermeture de la connexion
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + ex.getMessage());
            }
        }
        return comms;
    }
}
