package pdp_odev_1;

/**
*
* @author Yunus Emre Tuncer Yunus.tuncer@ogr.sakarya.edu.tr
* @since Programın yazıldığı tarih
* <p>
* Sınıf ile ilgili açıklama
* 
* sehir sınıfı
* </p>
*/

import java.util.ArrayList;

public class Sehir {
    private final int id;
    private int nufus;
    private int ilceSayisi;
    private int mahalleSayisi;
    private final String name;
    private final ArrayList<Ilce> ilceler = new ArrayList<>();

    public Sehir(int id, int nufus, int ilceSayisi, int mahalleSayisi, String name) {
        this.id = id;
        this.nufus = nufus;
        this.ilceSayisi = ilceSayisi;
        this.mahalleSayisi = mahalleSayisi;
        this.name = name;
    }

    public void ilceEkle(Ilce i)           { ilceler.add(i); }
    public int getId()                      { return id; }
    public int getNufus()                   { return nufus; }
    public int getIlceSayisi()              { return ilceSayisi; }
    public int getMahalleSayisi()           { return mahalleSayisi; }
    public String getName()                 { return name; }
    public ArrayList<Ilce> getIlceler()    { return ilceler; }
    public void setNufus(int nufus)        { this.nufus = nufus; }
    public void setIlceSayisi(int ilceSayisi)     { this.ilceSayisi = ilceSayisi; }
    public void setMahalleSayisi(int mahalleSayisi) { this.mahalleSayisi = mahalleSayisi; }
}