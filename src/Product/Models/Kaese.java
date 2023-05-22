package Product.Models;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Kaese extends Product {

    public Kaese(String bezeichnung, int newQuality, int qualitaet,LocalDate lieferTag, LocalDate verfallsdatum,double newPrice, double preis,String typ) {
        super(bezeichnung, newQuality, qualitaet,lieferTag, verfallsdatum,newPrice, preis,typ);
    }
    @Override
    public Boolean ausraeumen  (){
        if (getNewQuality() < 30)
        {
            return true;
        }
        return false;
    }
    @Override
    public void updateQuality(LocalDate currentDate){
        if( currentDate.isBefore(getVerfallsdatum())){
            int daysBetween = (int) ChronoUnit.DAYS.between(getLieferTag(), currentDate);
            int Quality = getQualitaet() - daysBetween;
            setNewQuality(Quality);
        } else {
            setNewQuality(-1);
        }
        updatePrice();
    }



}