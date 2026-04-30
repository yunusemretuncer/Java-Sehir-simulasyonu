package pdp_odev_1;

/**
*
* @author Yunus Emre Tuncer Yunus.tuncer@ogr.sakarya.edu.tr
* @since Programın yazıldığı tarih
* <p>
* Sınıf ile ilgili açıklama:
* 
* oyunun olustugu ve yönetilgigi sınıf sehir factory ile sehirlerin tüm parcalsrı olusturulur ve oyunDongusu kısmında oyun tur tur ilerletilip gereken işlemler yapılır
* </p>
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import com.github.javafaker.Faker;

public class Oyun {

    private final ArrayList<Sehir> sehirler;
    private final NufusAyar nufusAyar 				  = new NufusAyar();
    private final Yazdirma yazdirma                   = new Yazdirma();
    private final InputHandler inputHandler           = new InputHandler();
    private final Faker faker = new Faker(Locale.forLanguageTag("tr"));
    
    public Oyun(int tur, String input, Hesaplama h) {
        this.sehirler = new SehirFactory().sehirlerOlustur(input, h);
        oyunDongusu(tur);
    }

    private void oyunDongusu(int tur) {
        yazdirma.sehirGridYazdir(sehirler, 0); // başlangıç

        for (int i = 0; i < tur; i++) {
            for (Sehir s : sehirler) {
                s.setNufus(nufusAyar.yeniNufusHesapla(s));
                nufusAyar.nufusDagiliminiGuncelle(s);
            }
            nufusAyar.yasArtis(sehirler);

            bekle(2000);
            yazdirma.ekranTemizle();
            yazdirma.sehirGridYazdir(sehirler, i + 1); // tur numarası

            List<Sehir> yeniSehirler = nufusAyar
                .sehirleriKontrolEtVeBol(sehirler, faker);
            sehirler.addAll(yeniSehirler);

            if (!yeniSehirler.isEmpty()) {
                bekle(2000);
                yazdirma.ekranTemizle();
                yazdirma.sehirGridYazdir(sehirler, i + 1); // bölünmüş hali aynı tur
            }
        }

        Sehir secilen = inputHandler.sehirSec(sehirler);
        if (secilen != null) {
            yazdirma.sehirDetayYazdir(secilen);
        }
        System.out.print("\nDevam etmek icin Enter'a basin...");
        new java.util.Scanner(System.in).nextLine();
    }

    private void bekle(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}