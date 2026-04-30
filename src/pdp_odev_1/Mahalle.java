package pdp_odev_1;

/**
*
* @author Yunus Emre Tuncer Yunus.tuncer@ogr.sakarya.edu.tr
* @since Programın yazıldığı tarih
* <p>
* Sınıf ile ilgili açıklama:
* 
* mahalle sınıfı
* </p>
*/

import java.util.ArrayList;

public class Mahalle {
    private final int id;
    private int nufus;
    private final int bagliIlceId;
    private final String name;
    private final ArrayList<Kisi> kisiler = new ArrayList<>();

    public Mahalle(int id, int nufus, int bagliIlceId, String name) {
        this.id = id;
        this.nufus = nufus;
        this.bagliIlceId = bagliIlceId;
        this.name = name;
    }

    public void kisiEkle(Kisi k)       { kisiler.add(k); }
    public int getId()                  { return id; }
    public int getNufus()               { return nufus; }
    public void setNufus(int nufus)     { this.nufus = nufus; }
    public ArrayList<Kisi> getKisiler() { return kisiler; }
    public String getName()             { return name; }
}