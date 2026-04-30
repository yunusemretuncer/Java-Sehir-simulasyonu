package pdp_odev_1;

/**
*
* @author Yunus Emre Tuncer Yunus.tuncer@ogr.sakarya.edu.tr
* @since Programın yazıldığı tarih
* <p>
* Sınıf ile ilgili açıklama:
* 
* orjinal sayıların hesabının yapıldıgı class
* </p>
*/

public class Hesaplama {
	//mahalle sayisi düzenlenmesi
	public int sayiHesap(int sayi) 
	{
		
		int ilce_sayi = sayi/10;
		int mahalle_sayi = sayi%10;
		
		if (ilce_sayi == 0) return sayi;
		
		if(mahalle_sayi%ilce_sayi == 0) 
			if(mahalle_sayi == 0)
				return sayi +ilce_sayi;
		
			else
				return sayi;
		else 
		{
			if(ilce_sayi>=5) 
				return ilce_sayi*11; 
			else
				 return (sayi +(ilce_sayi-mahalle_sayi%ilce_sayi));
		}
	}
	//hesaplanan sayiya göre nufusunun hesaplanması
	public int nufusDuzenlemesi(int sayi) 
	{
		sayi = sayiHesap(sayi);
	    int mahalle_sayi = sayi % 10;

	    if (mahalle_sayi == 0) return sayi; 

	    if (sayi % mahalle_sayi != 0)
	        return sayi + (mahalle_sayi - sayi % mahalle_sayi);

	    return sayi;
	}
}