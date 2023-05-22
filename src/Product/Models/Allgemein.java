package Product.Models;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Allgemein extends Product {

    public Allgemein(String bezeichnung,int newQuality, int qualitaet,LocalDate lieferTag, LocalDate verfallsdatum,double newPrice, double preis, String typ) {
        super(bezeichnung,newQuality, qualitaet,lieferTag, verfallsdatum,newPrice,preis,typ);
    }

    @Override
    public Boolean ausraeumen() {
        if (getNewQuality() < 10)
        {
            return true;
        }
        return false;
    }

    @Override
    public void updateQuality(LocalDate currentDate) {
        if (currentDate.isBefore(getVerfallsdatum())) {
            int daysBetween = (int) ChronoUnit.DAYS.between(getLieferTag(), currentDate);
            int quality = getQualitaet() - (daysBetween / 4) * 3;
            if (quality >= 0) {
                setNewQuality(quality);
            } else {
                setNewQuality(0);
            }
        } else {
            int daysBetween = (int) ChronoUnit.DAYS.between(getLieferTag(), getVerfallsdatum());
            int quality = getQualitaet() - (daysBetween / 4) * 3;
            if (quality >= 0) {
                setNewQuality(quality);
            } else {
                setNewQuality(0);
            }
        }
        updatePrice();
    }



}
