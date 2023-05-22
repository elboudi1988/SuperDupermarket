package Product.Util;

import Product.Models.Allgemein;
import Product.Models.Kaese;
import Product.Models.Product;
import Product.Models.Wein;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    public  static List<Product> readCSVFromFile(String path){

        List<Product> produktList = new ArrayList<>();

        String line = "";
        String splitBy = ";";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] productData = line.split(splitBy);

                String bezeichnung = productData[0];
                int qualitaet = Integer.parseInt(productData[1]);
                int newQuality = Integer.parseInt(productData[1]);
                LocalDate lieferTag= LocalDate.parse(productData[2],formatter);
                String verfallsdatum = productData[3];
                LocalDate date = null;
                if (verfallsdatum.length()>0)
                {
                    date = LocalDate.parse(verfallsdatum,formatter);
                }
                

                double preis = Double.parseDouble(productData[4]);
                double newPrice = Double.parseDouble(productData[4]);
                String typ = productData[6];
          
                if(typ.contains("Käse")){
                    produktList.add(new Kaese(bezeichnung,newQuality, qualitaet,lieferTag, date,newPrice,preis,typ));
                } else if (typ.contains("Wein")){
                    produktList.add(new Wein(bezeichnung,newQuality, qualitaet,lieferTag, date,newPrice,preis,typ));
                } else {
                    produktList.add(new Allgemein(bezeichnung,newQuality, qualitaet,lieferTag, date,newPrice,preis,typ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return produktList;
    }

}
