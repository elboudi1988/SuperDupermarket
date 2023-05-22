package Product.Data;
import Product.Models.*;
import jdk.dynalink.beans.StaticClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
public class ProductData {
    static List<Product> produkte = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");


    public  ProductData() {
        produkte.add(new Kaese("Gouda", 50,50,LocalDate.parse("08.05.23",formatter),LocalDate.parse("16.08.23",formatter), 2.5,2.5,"Käse"));
        produkte.add(new Allgemein("Reis", 80,80, LocalDate.parse("08.05.23",formatter),null, 1.5,1.5,"Allgemein"));
        produkte.add(new Allgemein("Eier", 90,80,LocalDate.parse("08.05.23",formatter), LocalDate.parse("23.05.23",formatter), 3.0,3.0,"Allgemein"));
        produkte.add(new Wein("Rotwein", 20,20, LocalDate.parse("08.05.23",formatter),null, 8.0,8.0,"Wein"));
        produkte.add(new Wein("Weißwein", 25,25, LocalDate.parse("08.05.23",formatter),null, 7.5,7.5,"Wein"));
        produkte.add(new Kaese("Camembert", 35,35,LocalDate.parse("08.05.23",formatter), LocalDate.parse("24.05.23",formatter), 3.5,3.5,"Käse"));
    }
    public static List<Product> getProducts() {
        return produkte;
    }

}
