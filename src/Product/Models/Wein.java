package Product.Models;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Wein extends Product {

    public Wein(String bezeichnung,int newQuality, int qualitaet,LocalDate lieferTag , LocalDate verfallsdatum,double newPrice, double preis, String typ) {
        super(bezeichnung,newQuality,qualitaet ,lieferTag, verfallsdatum,newPrice,preis, typ);
    }

    @Override
    public Boolean ausraeumen() {
      return false;
    }

    @Override
    public void updateQuality(LocalDate currentDate) {
        long tageSeitLieferung = ChronoUnit.DAYS.between(this.getLieferTag(), currentDate);

        int zusaetzlichePunkte = (int) (tageSeitLieferung / 10);

        int neueQualitaet = this.getQualitaet() + zusaetzlichePunkte;

        if (neueQualitaet <= 50) {
            this.setNewQuality(neueQualitaet);
        } else {
            this.setQualitaet(50);
        }

        if (this.getQualitaet() < 0) {
            this.setQualitaet(0);
        }
    }

}



