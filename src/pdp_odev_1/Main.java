package pdp_odev_1;

import java.util.Scanner;

/**
*
* @author Yunus Emre Tuncer Yunus.tuncer@ogr.sakarya.edu.tr
* @since Programın yazıldığı tarih
* <p>
* Sınıf ile ilgili açıklama
* main sınıfı oyunun baslatıldıgı yer
* </p>
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hesaplama h = new Hesaplama();

        System.out.print("Tur sayisini girin: ");
        int tur = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Sehir girdisini girin: ");
        String input = scanner.nextLine();

        new Oyun(tur, input, h);

        scanner.close();
    }
}
