package Product.Data;

import Product.Models.Product;
import Product.Util.CSVUtil;

import java.util.List;

public class Repository {
    public List<Product> getProduct() {
        if (DBConfig.connectToDatabase()) {
            List<Product> allProducts = DBConfig.getProducts();
            if (allProducts != null && !allProducts.isEmpty()) {
                return allProducts;
            }
        }

        List<Product> allProducts = CSVUtil.readCSVFromFile("/Users/mohammed/Documents/SuperDupermarket/src/Product/SuperDupermarkt.csv");
        if (allProducts != null && !allProducts.isEmpty()) {
            return allProducts;
        }

        return ProductData.getProducts();
    }
}
