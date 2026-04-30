package pdp_odev_1;

/**
*
* @author Yunus Emre Tuncer Yunus.tuncer@ogr.sakarya.edu.tr
* @since Programın yazıldığı tarih
* <p>
* Sınıf ile ilgili açıklama
* 
* top_down yaklasımıyla sehirlerin illerin mahallelerin ve kişilerin olustugu ve baglandıgı sınıfdır
* </p>
*/

import com.github.javafaker.Faker;


import java.util.ArrayList;
import java.util.Locale;

public class SehirFactory {

    private final Faker faker = new Faker(Locale.forLanguageTag("tr"));
    private int sehirId = 0, ilceId = 0, mahalleId = 0;

    public ArrayList<Sehir> sehirlerOlustur(String input, Hesaplama h) {
        ArrayList<Sehir> sehirler = new ArrayList<>();

        for (String s : input.split(" ")) {
            sehirler.add(sehirOlustur(Integer.parseInt(s), h));
        }
        
        return sehirler;
    }
    //sehir objesi olusur
    private Sehir sehirOlustur(int sayi, Hesaplama h) {
        int ilceSayisi    = sayi / 10;
        int mahalleSayisi = ilceSayisi != 0
            ? (h.sayiHesap(sayi) % 10) / ilceSayisi
            : 0;
        int nufus = h.nufusDuzenlemesi(sayi);

        Sehir sehir = new Sehir(
            sehirId++, nufus, ilceSayisi,
            mahalleSayisi * ilceSayisi,
            faker.address().cityName()
        );

        for (int i = 0; i < ilceSayisi; i++) {
            sehir.ilceEkle(ilceOlustur(nufus, ilceSayisi, mahalleSayisi, sehir.getId()));
        }
        
        return sehir;
    }
    //İlce objesi olusur
    private Ilce ilceOlustur(int sehirNufus, int ilceSayisi, int mahalleSayisi, int bagliIlId) {
        int ilceNufus = sehirNufus / Math.max(1, ilceSayisi);

        Ilce ilce = new Ilce(
            ilceId++, ilceNufus, mahalleSayisi,
            bagliIlId, faker.address().cityName()
        );

        for (int j = 0; j < mahalleSayisi; j++) {
            ilce.mahalleEkle(mahalleOlustur(ilceNufus, mahalleSayisi, ilce.getId()));
        }

        return ilce;
    }
    //mahalle objesi olusur
    private Mahalle mahalleOlustur(int ilceNufus, int mahalleSayisi, int bagliIlceId) {
        int mahalleNufus = ilceNufus / Math.max(1, mahalleSayisi);

        Mahalle mahalle = new Mahalle(
            mahalleId++, mahalleNufus,
            bagliIlceId, faker.address().streetName()
        );
        //kisiler olusur
        for (int k = 0; k < mahalleNufus; k++) {
            mahalle.kisiEkle(new Kisi(
                faker.name().fullName(),
                faker.number().numberBetween(0, 50),
                mahalle.getId()
            ));
        }

        return mahalle;
    }
}