package pdp_odev_1;

/**
*
* @author Yunus Emre Tuncer Yunus.tuncer@ogr.sakarya.edu.tr
* @since Programın yazıldığı tarih
* <p>
* Sınıf ile ilgili açıklama:
* 
* ilce sınıfı 
* </p>
*/

import java.util.ArrayList;

public class Ilce {
    private final int id;
    private int nufus;
    private final int mahalleSayisi;
    private final int bagliIlId;
    private final String name;
    private final ArrayList<Mahalle> mahalleler = new ArrayList<>();

    public Ilce(int id, int nufus, int mahalleSayisi, int bagliIlId, String name) {
        this.id = id;
        this.nufus = nufus;
        this.mahalleSayisi = mahalleSayisi;
        this.bagliIlId = bagliIlId;
        this.name = name;
    }

    public void mahalleEkle(Mahalle m)        { mahalleler.add(m); }
    public int getId()                         { return id; }
    public int getNufus()                      { return nufus; }
    public int getMahalleSayisi()              { return mahalleSayisi; }
    public void setNufus(int nufus)            { this.nufus = nufus; }
    public ArrayList<Mahalle> getMahalleler()  { return mahalleler; }
    public String getName()                    { return name; }
}