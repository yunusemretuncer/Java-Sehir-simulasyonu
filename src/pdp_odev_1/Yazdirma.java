package pdp_odev_1;

/**
*
* @author Yunus Emre Tuncer Yunus.tuncer@ogr.sakarya.edu.tr
* @since Programın yazıldığı tarih
* <p>
* Sınıf ile ilgili açıklama
* 
* yazdırma ile ilgili herşeyin oldugu sınıf 
* sehirGridYazdır: turları ve sehirleri yazdır
* sehirDetayYazdir: secilen sehrin illeri mahalleleri ve kişilerin yazılması
* </p>
*/

import java.util.ArrayList;

public class Yazdirma {

	public void sehirGridYazdir(ArrayList<Sehir> sehirler, int tur) {
	    System.out.println("=== Tur " + tur + " ===");
	    int count = 0;
	    for (Sehir s : sehirler) {
	        System.out.print("[" + s.getNufus() + "]");
	        count++;
	        if (count % 5 == 0) {
	            System.out.println();
	        } else if (count < sehirler.size()) {
	            System.out.print("-");
	        }
	    }
	    System.out.println();
	}


    public void sehirDetayYazdir(Sehir s) {
        System.out.println("Sehir: " + s.getName() + " - Nufus: " + s.getNufus());
        for (Ilce i : s.getIlceler()) {
            System.out.println("  Ilce: " + i.getName() + " - Nufus: " + i.getNufus());
            for (Mahalle m : i.getMahalleler()) {
                System.out.println("    Mahalle: " + m.getName() + " - Nufus: " + m.getNufus());
                for (Kisi k : m.getKisiler()) {
                    k.yazdir();
                }
            }
        }
    }

    public void ekranTemizle() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}