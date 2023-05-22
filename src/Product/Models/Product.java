package Product.Models;

import java.awt.desktop.AboutEvent;
import java.time.LocalDate;

public abstract class Product {
    private String bezeichnung;
    private int qualitaet;
    private LocalDate lieferTag;
    private LocalDate verfallsdatum;
    private double newPrice;
    private double preis;
    private String typ;

    private  int newQuality;



    public Product(String bezeichnung, int newQuality, int qualitaet, LocalDate lieferTag, LocalDate verfallsdatum, double newPrice, double preis, String typ) {
        this.bezeichnung = bezeichnung;
        this.qualitaet = qualitaet;
        this.verfallsdatum = verfallsdatum;
        this.preis = preis;
        this.lieferTag=lieferTag;
        this.typ=typ;
        this.newQuality=newQuality;
        this.newPrice=newPrice;

    }

    public abstract Boolean ausraeumen();
    public abstract void updateQuality(LocalDate localDate);


    public String toString() {
        return "Product.Models.Produkt{" +
                "bezeichnung='" + bezeichnung + '\'' +
                ", qualitaet=" + qualitaet +
                ", verfallsdatum=" + verfallsdatum +
                ", preis=" + preis +

                '}';
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public LocalDate getLieferTag() {
        return lieferTag;
    }

    public void setLieferTag(LocalDate lieferTag) {
        this.lieferTag = lieferTag;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getQualitaet() {
        return qualitaet;
    }

    public void setQualitaet(int qualitaet) {
        this.qualitaet = qualitaet;
    }

    public LocalDate getVerfallsdatum() {
        return verfallsdatum;
    }

    public void setVerfallsdatum(LocalDate verfallsdatum) {
        this.verfallsdatum = verfallsdatum;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
    public int getNewQuality() {
        return newQuality;
    }

    public void setNewQuality(int newQuality) {
        this.newQuality = newQuality;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }
    public boolean istAbgelaufen(LocalDate currentDate) {
        if(this.getVerfallsdatum() != null) {
            return currentDate.isAfter(this.getVerfallsdatum());
        } else {
            return false;
        }
    }


    public boolean warnungBevorAblauf(LocalDate localDate) {
        return LocalDate.now().plusDays(2).equals(this.getVerfallsdatum());
    }


}
