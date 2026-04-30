# Şehir Simülasyonu — PDP Ödev 1

Java tabanlı konsol şehir simülasyonu. Şehir, ilçe, mahalle ve kişi hiyerarşisi üzerine kurulu tur tabanlı nüfus büyüme oyunu.

## Çalıştırma

```bash
java -jar dist/pdp_odev.jar
```

## Kullanım

```
Tur sayisini girin: 2
Sehir girdisini girin: 18 25 79 37 62 86 17 50
```

- Sayının **onlar basamağı** → ilçe sayısı
- Sayının **birler basamağı** → ilçe başına mahalle sayısı
- Sayının **kendisi** → şehir nüfusu

## Oyun Mekaniği

- Her tur sonunda nüfus, birler + onlar basamağı oranında artar
- Nüfus 4 basamaklı olursa şehir ikiye bölünür
- Her tur kişilerin yaşı 1 artar
- Tur sonunda 5'erli grid ekrana yazdırılır

## Proje Yapısı

```
src/pdp_odev_1/
├── Main.java
├── Oyun.java
├── model/
│   ├── Sehir.java
│   ├── Ilce.java
│   ├── Mahalle.java
│   └── Kisi.java
├── service/
│   ├── SehirFactory.java
│   └── PopulationService.java
└── ui/
    ├── Yazdirma.java
    └── InputHandler.java
```

## Bağımlılıklar

- Java 21
- [Java Faker](https://github.com/DiUS/java-faker)
