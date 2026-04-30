package pdp_odev_1;

/**
*
* @author Yunus Emre Tuncer Yunus.tuncer@ogr.sakarya.edu.tr
* @since Programın yazıldığı tarih
* <p>
* Sınıf ile ilgili açıklama
* 
* kisi sınıfı
* </p>
*/

public class Kisi {

	private static int sayac = 0; // tüm oyun boyunca artar

    private final int id;
    private String isim;
    private int yas;
    private final int mahalleId;

    public Kisi(String isim, int yas, int mahalleId) {
        this.id = ++sayac;
        this.isim = isim;
        this.yas = yas;
        this.mahalleId = mahalleId;
    }

    
    public void yasArtir()      { this.yas++; }
    public int getId()          { return id; }
    public String getIsim()     { return isim; }
    public int getYas()         { return yas; }
    public int getMahalleId()   { return mahalleId; }

    // Yazdırma
    public void yazdir() {
        System.out.println("      Kisi: " + isim + " - Yas: " + yas +" -id" + id);
    }
}