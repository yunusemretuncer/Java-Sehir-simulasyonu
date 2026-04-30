package pdp_odev_1;

/**
*
* @author Yunus Emre Tuncer Yunus.tuncer@ogr.sakarya.edu.tr
* @since Programın yazıldığı tarih
* <p>
* Sınıf ile ilgili açıklama
* 
* turlardaki nufus degişimini kontrol eden bölünme ve artış süresinde nufusları dogru olmasını saglayan sınıf
* </p>
*/

import com.github.javafaker.Faker;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

public class NufusAyar {

    private final Faker faker = new Faker(Locale.forLanguageTag("tr"));

    // Sehirin yeni nüfusunu hesaplar
    public int yeniNufusHesapla(Sehir s) {
        int nufus = s.getNufus();
        int mahalleSayisi = s.getMahalleSayisi();

        

        int onlar = (nufus / 10) % 10;
        int birler = nufus % 10;
        int oran = onlar + birler;
        if (oran == 0) oran = 1;

        int mahalleNufus = nufus / Math.max(1, mahalleSayisi);
        return oran * mahalleSayisi * mahalleNufus;
    }

    // Şehir altındaki tüm ilçe ve mahallelerin nüfusunu günceller
    public void nufusDagiliminiGuncelle(Sehir s) {
        int ilceSayisi = s.getIlceSayisi();

        for (Ilce ilce : s.getIlceler()) {
            int ilceNufus = s.getNufus() / Math.max(1, ilceSayisi);
            ilce.setNufus(ilceNufus);
            mahalleNufusGuncelle(ilce);
        }
    }

    // İlçe altındaki mahallelerin nüfusunu ve kişilerini senkronize eder
    private void mahalleNufusGuncelle(Ilce ilce) {
        int mahalleSayisi = ilce.getMahalleSayisi();

        for (Mahalle m : ilce.getMahalleler()) {
            int yeniNufus = ilce.getNufus() / Math.max(1, mahalleSayisi);
            m.setNufus(yeniNufus);
            kisiListesiniSenkronize(m, yeniNufus);
        }
    }

    // Mahalledeki kişi listesini nüfusa göre ekler veya siler
    private void kisiListesiniSenkronize(Mahalle m, int hedefNufus) {
        ArrayList<Kisi> kisiler = m.getKisiler();
        int mevcut = kisiler.size();

        if (mevcut < hedefNufus) {
            for (int i = 0; i < hedefNufus - mevcut; i++) {
                kisiler.add(new Kisi(
                    faker.name().fullName(),
                    faker.number().numberBetween(1, 50),
                    m.getId()
                ));
            }
        } else if (mevcut > hedefNufus) {
            kisiler.subList(hedefNufus, mevcut).clear();
        }
    }
    
 // Yaş artışı
    public void yasArtis(ArrayList<Sehir> sehirler) {
        for (Sehir s : sehirler) {
            for (Ilce ilce : s.getIlceler()) {
                for (Mahalle m : ilce.getMahalleler()) {
                    for (Kisi k : m.getKisiler()) {
                        k.yasArtir();
                    }
                }
            }
        }
    }

    // Bölünmesi gereken şehirleri tespit et ve böl
    public List<Sehir> sehirleriKontrolEtVeBol(ArrayList<Sehir> sehirler, Faker faker) {
        List<Sehir> yeniSehirler = new ArrayList<>();

        for (Sehir s : sehirler) {
            if (s.getNufus() >= 1000 && s.getIlceSayisi() >= 2) { // en az 2 ilçe lazım
                Sehir yeni = sehiriBol(s, faker);
                yeniSehirler.add(yeni);
            }
        }

        return yeniSehirler;
    }
    //sehiri bölme
    private Sehir sehiriBol(Sehir s, Faker faker) {
        ArrayList<Ilce> tumIlceler = s.getIlceler();
        int toplamIlce = tumIlceler.size();

        int yeniIlceSayisi = toplamIlce / 2;
        int eskiIlceSayisi = toplamIlce - yeniIlceSayisi;

        ArrayList<Ilce> tasinanIlceler = new ArrayList<>(
            tumIlceler.subList(eskiIlceSayisi, toplamIlce)
        );
        tumIlceler.subList(eskiIlceSayisi, toplamIlce).clear();

        int tasinanNufus = 0;
        int tasinanMahalle = 0;
        for (Ilce ilce : tasinanIlceler) {
            tasinanNufus += ilce.getNufus();
            tasinanMahalle += ilce.getMahalleSayisi();
            
        }

        int kalanNufus = s.getNufus() - tasinanNufus;
        

        s.setNufus(kalanNufus);
        int kalanMahalle = 0;
        for (Ilce ilce : tumIlceler) {
            kalanMahalle += ilce.getMahalleSayisi();
        }
        s.setMahalleSayisi(kalanMahalle);
        s.setIlceSayisi(eskiIlceSayisi);

        Sehir yeniSehir = new Sehir(
            s.getId() + 1000,
            tasinanNufus,
            yeniIlceSayisi,
            tasinanMahalle,
            faker.address().cityName()
        );

        for (Ilce ilce : tasinanIlceler) {
            yeniSehir.ilceEkle(ilce);
        }

        return yeniSehir;
    }
}