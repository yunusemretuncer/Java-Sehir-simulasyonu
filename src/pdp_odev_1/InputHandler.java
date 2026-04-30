package pdp_odev_1;

/**
*
* @author Yunus Emre Tuncer Yunus.tuncer@ogr.sakarya.edu.tr
* @since Programın yazıldığı tarih
* <p>
* Sınıf ile ilgili açıklama:
* 
* sehirleri yazdırmasını inputunu parse edip düzenliyor
* </p>
*/

import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    public Sehir sehirSec(ArrayList<Sehir> sehirler) {
        System.out.print("Satir ve sutun girin (ornek: 1 5): ");
        String[] parcalar = scanner.nextLine().split(" ");

        int satir = Integer.parseInt(parcalar[0]);
        int sutun  = Integer.parseInt(parcalar[1]);
        int index = (satir - 1) * 5 + (sutun - 1);

        if (index >= 0 && index < sehirler.size()) {
            return sehirler.get(index);
        }

        System.out.println("Gecersiz konum!");
        return null;
    }
}