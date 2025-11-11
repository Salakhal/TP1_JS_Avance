import java.sql.*;

public class ExoJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/atelier";
        String user = "root";
        String password = ""; // si tu as un mot de passe, mets-le ici

        try {
            // Charger le driver JDBC
            Class.forName("com.mysql.jdbc.Driver");

            // Ouvrir la connexion
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // Supprimer/créer la table
            stmt.executeUpdate("DROP TABLE IF EXISTS DevData");
            stmt.executeUpdate(
                "CREATE TABLE DevData (" +
                "Developpeurs VARCHAR(32), " +
                "Jour CHAR(11), " +
                "NbScripts INTEGER)"
            );

            // Insertion de données
            stmt.executeUpdate("INSERT INTO DevData VALUES ('ALAMI', 'Lundi', 1)");
            stmt.executeUpdate("INSERT INTO DevData VALUES ('WAFI', 'Lundi', 2)");
            stmt.executeUpdate("INSERT INTO DevData VALUES ('SLAMI', 'Mardi', 9)");

            // a) Max scripts par jour
            ResultSet rs1 = stmt.executeQuery(
                "SELECT Developpeurs, Jour, MAX(NbScripts) FROM DevData GROUP BY Jour");
            System.out.println("Max scripts par jour :");
            while (rs1.next()) {
                System.out.println(rs1.getString(1) + " | " + rs1.getString(2) + " | " + rs1.getInt(3));
            }

            // b) Classement
            ResultSet rs2 = stmt.executeQuery(
                "SELECT Developpeurs, SUM(NbScripts) AS Total " +
                "FROM DevData GROUP BY Developpeurs ORDER BY Total DESC");
            System.out.println("\nClassement des développeurs :");
            while (rs2.next()) {
                System.out.println(rs2.getString(1) + " | " + rs2.getInt(2));
            }

            // c) Total semaine
            ResultSet rs3 = stmt.executeQuery("SELECT SUM(NbScripts) FROM DevData");
            if (rs3.next()) {
                System.out.println("\nTotal scripts semaine : " + rs3.getInt(1));
            }

            // d) Total pour un développeur donné
            PreparedStatement ps = conn.prepareStatement(
                "SELECT SUM(NbScripts) FROM DevData WHERE Developpeurs = ?");
            ps.setString(1, "ALAMI");
            ResultSet rs4 = ps.executeQuery();
            if (rs4.next()) {
                System.out.println("\nTotal scripts pour ALAMI : " + rs4.getInt(1));
            }

            // Fermer
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
