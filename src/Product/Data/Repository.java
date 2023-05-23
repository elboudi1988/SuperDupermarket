package Product.Data;

import Product.Models.Product;
import Product.Util.CSVUtil;

import java.util.List;

public class Repository {

    String projectDirectory = System.getProperty("user.dir");
    String relativePath = "src/Product/SuperDupermarkt.csv";
    String csvFilePath = projectDirectory + "/" + relativePath;

    public List<Product> getProduct() {
        try {
            // Falls keine Verbindung zur Datenbank hergestellt werden konnte,
            // kann es einige Sekunden dauern,
            // bis das Programm die Daten aus der CSV-Datei abruft.
            if (DBConfig.connectToDatabase()) {
                List<Product> allProducts = DBConfig.getProducts();
                if (allProducts != null && !allProducts.isEmpty()) {
                    return allProducts;
                }
            }

            List<Product> allProducts = CSVUtil.readCSVFromFile(csvFilePath);
            if (allProducts != null && !allProducts.isEmpty()) {
                return allProducts;
            }


        } catch (Exception ex) {
            System.out.println("Meesage");
        }
        return ProductData.getProducts();
    }


}
