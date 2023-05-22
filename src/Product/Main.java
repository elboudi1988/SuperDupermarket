package Product;

import Product.Data.Repository;
import Product.Models.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new Repository().getProduct();

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println("Produkte des Sortiments und deren Startwerte");
        System.out.println("---------------------------------------------");
        System.out.printf("%-15s %-10s %-10s%n", "Name", "Qualität", "Preis");
        System.out.println("---------------------------------------------");

        for (Product produkt : productList) {
            System.out.printf("%-15s %-10d %,-10.2f€%n",
                    produkt.getBezeichnung(),
                    produkt.getQualitaet(),
                    produkt.getPreis());
        }

        System.out.println("---------------------------------------------");


        System.out.println("Produkte des Sortiments und deren Werte nach den Rechnungen");
        for (int i = 0; i <= 7; i++) {
            System.out.println("Datum: " + today.plusDays(i).format(formatter));
            System.out.println("--------------------------------------------------------------------------");
                        System.out.printf("%-15s %-10s %-10s %-15s %-15s%n", "Name", "Qualität", "Preis", "Status", "Info");
            System.out.println("--------------------------------------------------------------------------");

            for (Product produkt : productList) {
                produkt.istAbgelaufen(today.plusDays(i));
                produkt.warnungBevorAblauf(today.plusDays(i));
                produkt.updateQuality(today.plusDays(i));
                String infoVerfaellt =(produkt.warnungBevorAblauf(today.plusDays(i))?"Verfällt bald":"");
                String infoQualität=((produkt.ausraeumen())?"Niedrige Qualität":"");
                String infoAbgelaufen=((produkt.istAbgelaufen(today.plusDays(i)))?"Abgelaufen":"");
                String info = "";
                if (!infoAbgelaufen.isEmpty()) {
                    info = infoAbgelaufen;
                } else if (!infoVerfaellt.isEmpty()) {
                    info = infoVerfaellt;
                }
                if (!infoQualität.isEmpty()) {
                    if (!info.isEmpty()) {
                        info += ", " + infoQualität;
                    } else {
                        info = infoQualität;
                    }
                }

                String entsorgt = (produkt.ausraeumen() || produkt.istAbgelaufen(today.plusDays(i))) ? "entsorgen." : "-";
                 System.out.printf("%-15s %-10d %,-10.2f€  %-15s %-10s%n",
                        produkt.getBezeichnung(),
                        produkt.getNewQuality(),
                        produkt.getNewPrice(),
                        entsorgt,
                        info);
            }
            System.out.println("--------------------------------------------------------------------------");


        }
    }
}
