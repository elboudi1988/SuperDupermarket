package Product.Data;

import Product.Models.Allgemein;
import Product.Models.Kaese;
import Product.Models.Product;
import Product.Models.Wein;

import java.sql.*;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DBConfig {
    private static Connection connection;

    public static boolean connectToDatabase() {
        String url = "jdbc:sqlserver://localhost:1433;encrypt=false;databaseName=SuperDuperMarktDB;user=sa;password=";
        try {
            connection = DriverManager.getConnection(url);
            createTable();
            return true;
        } catch (com.microsoft.sqlserver.jdbc.SQLServerException e) {
            System.out.println("Es konnte keine Verbindung zur Datenbank hergestellt werden. ");
            return false;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void createTable() {
        try {
            DatabaseMetaData dbm = connection.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "produkte", null);
            if (tables.next()) {
                System.out.println("Table 'produkte' already exists!");
            }
            else {
                Statement stmt = connection.createStatement();
                String sqlCreate = "CREATE TABLE produkte "
                        + "(Bezeichnung VARCHAR(255), "
                        + " Qualitaet INTEGER, "
                        + " LieferTag DATE, "
                        + " Verfallsdatum DATE, "
                        + " Preis FLOAT,"
                        + " typ VARCHAR(255))";

                stmt.execute(sqlCreate);
                System.out.println("Table created!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> getProducts() {
        List<Product> produkte = new ArrayList<>();
        String sql = "SELECT * FROM produkte";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String bezeichnung = rs.getString("Bezeichnung");
                int newQuality = rs.getInt("Qualitaet");
                int qualitaet = rs.getInt("Qualitaet");
                LocalDate lieferTag = rs.getDate("LieferTag").toLocalDate();
                LocalDate verfallsdatum = rs.getDate("Verfallsdatum") != null ? rs.getDate("Verfallsdatum").toLocalDate() : null;
                double newPrice = rs.getDouble("Preis");
                double preis = rs.getDouble("Preis");
                String typ=rs.getString("typ");
                if (typ.contains("Käse")) {
                    Product product = new Kaese(bezeichnung, newQuality,qualitaet, lieferTag, verfallsdatum,newPrice, preis,typ);
                    produkte.add(product);
                } else if (typ.contains("Wein")) {
                    Product product = new Wein(bezeichnung, newQuality,qualitaet, lieferTag, verfallsdatum,newPrice,preis,typ);
                    produkte.add(product);
                }else{
                    Product product = new Allgemein(bezeichnung, newQuality,qualitaet, lieferTag, verfallsdatum,newPrice,preis,typ);
                    produkte.add(product);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produkte;
    }



    private static boolean doesProductExist(String bezeichnung) {
        String sql = "SELECT * FROM produkte WHERE Bezeichnung = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, bezeichnung);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void importDataFromCsv(String csvPath) {
        String insertSql = "INSERT INTO Produkte (Bezeichnung, Qualitaet, LieferTag, Verfallsdatum, Preis,typ) VALUES (?, ?, ?, ?, ?,?)";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(csvPath));
             PreparedStatement pstmt = connection.prepareStatement(insertSql)) {

            String line;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yy");

            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String bezeichnung = data[0];
                if (!doesProductExist(bezeichnung)) {
                    int qualitaet = Integer.parseInt(data[1]);
                    LocalDate lieferTag = LocalDate.parse(data[2], dtf);
                    LocalDate verfallsdatum = data[3].isEmpty() ? null : LocalDate.parse(data[3], dtf);
                    double preis = Double.parseDouble(data[4]);
                    String typ = data[6];
                    pstmt.setString(1, bezeichnung);
                    pstmt.setInt(2, qualitaet);
                    pstmt.setDate(3, java.sql.Date.valueOf(lieferTag));
                    if (verfallsdatum != null) {
                        pstmt.setDate(4, java.sql.Date.valueOf(verfallsdatum));
                    } else {
                        pstmt.setNull(4, Types.DATE);
                    }
                    pstmt.setDouble(5, preis);
                    pstmt.setString(6, typ);

                    pstmt.executeUpdate();
                    System.out.println("Data imported successfully!");
                } else {
                    System.out.println("Product already exists in the database. Skipping this entry.");
                }
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

}
